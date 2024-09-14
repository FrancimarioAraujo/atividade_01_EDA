import java.util.Arrays;
import java.util.Comparator;

public class Busca implements Busca_IF {

    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {
        for (int i = 0; i < filmes.length - 1; i++) {
            if (filmes[i].compareTo(filmes[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Filme buscaLinear_iterativa(Filme[] filmes, int nota) throws Exception {
        if (nota < 0) {
            throw new NotaNegativaException("A nota precisa ser positiva");
        }
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i].getNota() == nota) {
                return filmes[i];
            }
        }
        return null;

    }

    @Override
    public Filme buscaLinear_recursiva(Filme[] filmes, int nota) throws Exception {
        return buscaLinearRecursivaAuxiliar(filmes, nota, 0);
    }

    @Override
    public Filme buscaBinaria_iterativa(Filme[] filmes, int nota) throws Exception {
        int inicio = 0;
        int fim = filmes.length - 1;
        if (nota < 0) {
            throw new NotaNegativaException("A nota precisa ser positiva");
        }
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            if (filmes[meio].getNota() == nota) {
                return filmes[meio];
            }
            if (filmes[meio].getNota() > nota) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return null;

    }

    @Override
    public Filme buscaBinaria_recursiva(Filme[] filmes, int nota) throws Exception {
        int resultado = buscaBinariaRecursivaAuxiliar(filmes, nota, 0, filmes.length - 1);
        if (nota < 0) {
            throw new NotaNegativaException("A nota precisa ser positiva");
        }
        if (resultado != -1) {
            return filmes[resultado];
        } else {
            return null;
        }
    }

    @Override
    public Filme buscaLinear_iterativa_duasPontas(Filme[] filmes, int nota) throws Exception {
        int inicio = 0;
        int fim = filmes.length - 1;

        if (nota < 0) {
            throw new NotaNegativaException("A nota precisa ser positiva");
        }
        while (inicio <= fim) {

            if (filmes[inicio].getNota() == nota) {
                return filmes[inicio];
            }

            if (filmes[fim].getNota() == nota) {
                return filmes[fim];
            }

            inicio++;
            fim--;
        }

        return null;
    }

    private Filme buscaLinearRecursivaAuxiliar(Filme[] filmes, int nota, int index)
            throws NotaNegativaException {
        if (nota < 0) {
            throw new NotaNegativaException("A nota precisa ser positiva");
        }
        if (index >= filmes.length) {
            return null;
        }

        if (filmes[index].getNota() == nota) {
            return filmes[index];
        }

        return buscaLinearRecursivaAuxiliar(filmes, nota, index + 1);
    }

    private int buscaBinariaRecursivaAuxiliar(Filme[] vetor, int notaBuscada, int inicio, int fim) {

        if (inicio > fim) {
            return -1;
        }

        int meio = inicio + (fim - inicio) / 2;

        if (vetor[meio].getNota() == notaBuscada) {
            return meio;
        }

        if (vetor[meio].getNota() > notaBuscada) {
            return buscaBinariaRecursivaAuxiliar(vetor, notaBuscada, inicio, meio - 1);
        }

        return buscaBinariaRecursivaAuxiliar(vetor, notaBuscada, meio + 1, fim);
    }

}
