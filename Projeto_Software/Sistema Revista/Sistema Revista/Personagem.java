/**
 * Modelo de Dados referente ao Personagem.
 * 
 * @author Vitor Hugo da Cunha
 */
public class Personagem {

    private String nome;

    private int idade;

    public Personagem(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}