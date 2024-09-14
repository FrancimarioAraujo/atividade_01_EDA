import java.util.Random;

public class TestesNanoTime {

    Filme[] vetor100milAleatorio = new Filme[100000];
    Filme[] vetor500milAleatorio = new Filme[500000];
    Filme[] vetor1milhaoAleatorio = new Filme[1000000];
    //
    Filme[] vetor100milOrdenado = new Filme[100000];
    Filme[] vetor500milOrdenado = new Filme[500000];
    Filme[] vetor1milhaoOrdenado = new Filme[1000000];
    //
    Filme[] vetor100milInverso = new Filme[100000];
    Filme[] vetor500milInverso = new Filme[500000];
    Filme[] vetor1milhaoInverso = new Filme[1000000];
    Random random = new Random();

    void preencherVetoresAleatorios() {
        for (int i = 0; i < vetor100milAleatorio.length; i++) {
            vetor100milAleatorio[i] = gerarFilmeAleatorio(i);
        }
        for (int i = 0; i < vetor500milAleatorio.length; i++) {
            vetor500milAleatorio[i] = gerarFilmeAleatorio(i);
        }
        for (int i = 0; i < vetor1milhaoAleatorio.length; i++) {
            vetor1milhaoAleatorio[i] = gerarFilmeAleatorio(i);
        }
    }

    void preencherVetoresOrdenados() {
        for (int i = 0; i < vetor100milOrdenado.length; i++) {
            vetor100milOrdenado[i] = gerarFilmeOrdenado(i);
        }
        for (int i = 0; i < vetor500milOrdenado.length; i++) {
            vetor500milOrdenado[i] = gerarFilmeOrdenado(i);
        }
        for (int i = 0; i < vetor1milhaoOrdenado.length; i++) {
            vetor1milhaoOrdenado[i] = gerarFilmeOrdenado(i);
        }
    }

    // void preencherVetoresInversos() {
    // for (int i = 0; i < vetor100milInverso.length; i++) {
    // vetor100milInverso[i] = gerarFilme(i);
    // }
    // for (int i = 0; i < vetor500milInverso.length; i++) {
    // vetor500milInverso[i] = gerarFilme(i);
    // }
    // for (int i = 0; i < vetor1milhaoInverso.length; i++) {
    // vetor1milhaoInverso[i] = gerarFilme(i);
    // }
    // }

    void pecorrerVetor(Filme[] vetor) {
        for (Filme filme : vetor) {
            System.out.println(filme);
        }
        System.out.println("Tamanho: " + vetor.length);
    }

    Filme gerarFilmeAleatorio(int i) {
        String nome = "Filme " + (i + 1);
        int nota = random.nextInt(5) + 1;
        int ano = random.nextInt(40) + 1980;
        return new Filme(nome, nota, ano);
    }

    Filme gerarFilmeOrdenado(int i, int tamanhoVetor) {
        String nome = "Filme " + (i + 1);

        int nota = 5 - (i % 5);

        int ano = 1980 + (i % 40);

        return new Filme(nome, nota, ano);
    }
}