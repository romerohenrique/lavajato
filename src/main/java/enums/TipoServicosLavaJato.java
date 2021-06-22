package enums;

public enum TipoServicosLavaJato {
    MOTO_LAVAGEM(1, "Moto - Lavagem Simples ", 20),
    MOTO_POLIMENTO(2, "Moto - Polimento", 30),
    MOTO_POLIMENTO_CRISTALIZADO(3, "Moto - Polimento Cristalizado", 100),
    CARRO_LAVAGEM(4, "Carro - Lavagem Simples", 30),
    CARRO_POLIMENTO(5, "Carro - Polimento", 50),
    CARRO_POLIMENTO_CRISTALIZADO(6, "Carro - Polimento Cristalizado", 150),
    CAMIONETE_LAVAGEM(7, "Camionete - Lavagem Simples", 50),
    CAMIONETE_POLIMENTO(8, "Camionete - Polimento", 80),
    CAMIONETE_POLIMENTO_CRISTALIZADO(9, "Camionete- Polimento CRistalizado", 200),
    CAMINHAO_LAVAGEM(10, "Caminhão - Lavagem",80),
    CAMINHAO_POLIMENTO(11, "Caminhão - Polimento", 180),
    CAMINHAO_POLIMENTO_CRISTALIZADO(12, "Caminhão - Polimento Cristalizado", 250);


    private final int tipo;
    private final String nome;
    private final double preco;

    TipoServicosLavaJato(int tipo, String nome, double preco) {
        this.tipo = tipo;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Service{" +
                "tipo=" + tipo +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                "} " + super.toString();
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
