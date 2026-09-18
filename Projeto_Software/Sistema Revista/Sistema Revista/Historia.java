import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de Dados referente a História.
 * 
 * @author Vitor Hugo da Cunha
 */
public class Historia {

    private String titulo;
    
    private String resumo;

    private List<Autor> autores;
    
    private ArrayList<Personagem> personagens;

    public Historia(String titulo, String resumo) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.personagens = new ArrayList<>();
        this.autores = new ArrayList<>();
    }

    public ArrayList<Personagem> getPersonagens() {
        return this.personagens;
    }

    public boolean addPersonagem(Personagem pers) {
        return this.personagens.add(pers);
    }

    public boolean removePersonagem(String nome) {
        return this.personagens.removeIf(pers -> pers.getNome().equals(nome));
    }

    private void setResumo(String resumo) {
        this.resumo = resumo;
    } 

    public String getResumo() {
        return this.resumo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return this.autores;
    }

    public void addAutor(Autor autor) {
        this.autores.add(autor);
    }

    public boolean removeAutor(String nome) {
        return this.autores.removeIf(aut -> aut.getNome().equals(nome));
    }

    public boolean possuiAutor(Autor autor) {
        for (Autor aut : this.getAutores()) {
            if (aut.getNome().equals(autor.getNome())) {
                return true;
            }
        }
        return false;
    }
}