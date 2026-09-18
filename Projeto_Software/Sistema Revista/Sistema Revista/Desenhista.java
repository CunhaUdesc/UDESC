/**
 * Modelo de Dados referente ao Desenhista.
 * 
 * @author Vitor Hugo da Cunha
 */
public class Desenhista extends Autor {

    private String estilo;

    /**
     * Construct
     */
    public Desenhista(String nome, int tempoCasa, String estilo) {
        super(nome, tempoCasa);
        this.estilo = estilo;
    }

    @Override 
    public int getPontuacao() {
        return super.getPontuacao() + this.getTempoCasa() * 2;
    }

    public String getEstilo() {
        return this.estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}