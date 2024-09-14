public class Filme implements Filme_IF {
    private String nome;
    private int nota;
    private int ano;

    public Filme(String nome, int nota, int ano) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getNota() {
        return nota;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return nome + " (" + ano + ")" + " [" + nota + "]";
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Filme_IF outro_filme) {
        if (this.nota == outro_filme.getNota()) {
            if (this.ano == outro_filme.getAno()) {
                return this.nome.compareTo(outro_filme.getNome());
            } else {
                return Integer.compare(this.ano, outro_filme.getAno());
            }
        } else {
            return Integer.compare(outro_filme.getNota(), this.nota);
        }
    }

    public Filme clone() {
        return new Filme(nome, nota, ano);
    }

}
