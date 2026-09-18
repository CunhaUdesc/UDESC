/**
 * Modelo de Dados do Escritor
 * 
 * @author Vitor Hugo da Cunha
 */
public class Escritor extends Autor {

    private int registro;

    public Escritor(String nome, int tempoCasa, int registro) {
        super(nome, tempoCasa);
        this.registro = registro;
    }

    @Override 
    public int getPontuacao() {
        return super.getPontuacao() + this.getTempoCasa() * 2;
    }

    public int getRegistro() {
        return this.registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }
}