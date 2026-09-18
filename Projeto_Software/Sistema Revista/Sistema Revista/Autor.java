/**
 * Modelo de Dados referente ao Autor
 * 
 * @author Vitor Hugo da Cunha
 */
public abstract class Autor {

    private String nome;
    
    private int tempoCasa;

    /**
     * Construct
     */
    public Autor(String nome, int tempoCasa) {
        this.nome = nome;
        this.tempoCasa = tempoCasa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoCasa() {
        return this.tempoCasa;
    }

    public void setTempoCasa(int tempoCasa) {
        this.tempoCasa = tempoCasa;
    }

    public int getPontuacao() {
        return this.getTempoCasa() * 5;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor that = (Autor)o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}