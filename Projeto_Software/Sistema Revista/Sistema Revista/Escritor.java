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

    public int getRegistro() {
        return this.registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }
}