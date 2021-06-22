package entidade;

public class Cliente extends Pessoa {

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String contato, String cpf) {
        super(id, nome, contato, cpf);
    }
}
