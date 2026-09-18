import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Modelo de Dados referente a Revista
 * 
 * @author Vitor Hugo da Cunha
 */
public class Revista {

    private String nome;

    private int edicao;

    private ArrayList<Historia> historias;

    /**
     * Construct
     */
    public Revista(String nome, int edicao) {
        this.nome = nome;
        this.edicao = edicao;
        this.historias = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEdicao() {
        return this.edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public boolean addHistoria(Historia hist) {
        return this.historias.add(hist);
    }

    public boolean removeHistoria(String titulo) {
        return this.historias.removeIf(hist -> hist.getTitulo().equals(titulo));
    }

    public List<Autor> getAutores() {
        Set<Autor> autores = new HashSet<Autor>();
        for (Historia hist : this.getHistorias()) {
            autores.addAll(hist.getAutores());
        }
        return new ArrayList<>(autores);
    }

    public ArrayList<Historia> getHistorias() {
        return this.historias;
    }
}