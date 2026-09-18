import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Sistema de Revistas.
 * 
 * @author Vitor Hugo da Cunha
 */
public class App {

    /**
     * Main
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("=== INICIANDO TESTES DO SISTEMA DE REVISTAS ===\n");

        // 1. Criando Personagens
        Personagem p1 = new Personagem("Mônica", 7);
        Personagem p2 = new Personagem("Cebolinha", 7);
        System.out.println("Personagens criados: " + p1.getNome() + ", " + p2.getNome());

        // 2. Criando Autores (Escritor e Desenhista)
        // Mauricio (Escritor): 10 anos de casa -> Pontuação esperada: 10 * 5 = 50
        Escritor escritor1 = new Escritor("Mauricio de Sousa", 10, 12345);
        
        // Titi (Desenhista): 4 anos de casa -> Pontuação esperada: (4 * 5) + (4 * 2) = 20 + 8 = 28
        Desenhista desenhista1 = new Desenhista("Titi Desenhista", 4, "Mangá");
        
        System.out.println("Autor Escritor: " + escritor1.getNome() + " | Pontuação: " + escritor1.getPontuacao());
        System.out.println("Autor Desenhista: " + desenhista1.getNome() + " | Pontuação: " + desenhista1.getPontuacao());

        // 3. Criando Histórias
        Historia h1 = new Historia("O Coelhinho Enfeitiçado", "Aventura no Limoeiro.");
        h1.addAutor(escritor1);
        h1.addAutor(desenhista1);
        h1.addPersonagem(p1);
        h1.addPersonagem(p2);

        Historia h2 = new Historia("O Plano Infalível", "Mais um plano que vai dar errado.");
        h2.addAutor(escritor1);
        h2.addPersonagem(p2);

        // 4. Criando Revista e adicionando as histórias
        Revista revista1 = new Revista("Turma da Mônica", 1);
        revista1.addHistoria(h1);
        revista1.addHistoria(h2);

        // Criando uma segunda revista para testar contagem de revistas
        Revista revista2 = new Revista("Turma da Mônica", 2);
        Historia h3 = new Historia("Férias na Praia", "Dona Mônica viaja.");
        h3.addAutor(desenhista1);
        h3.addPersonagem(p1);
        revista2.addHistoria(h3);

        List<Revista> listaRevistas = List.of(revista1, revista2);
        App app = new App();

        System.out.println("\n--- TESTANDO MÉTODOS ---");

        // Teste 1: possuiAutor
        boolean temAutor = app.possuiAutor(revista1, escritor1);
        System.out.println("1. A revista 1 possui o autor Mauricio? " + temAutor + " (Esperado: true)");

        // Teste 2: qtdRevistas (A Mônica aparece na revista 1 e na revista 2)
        int qtdRev = app.qtdRevistas(listaRevistas, p1);
        System.out.println("2. Em quantas revistas a personagem Mônica aparece? " + qtdRev + " (Esperado: 2)");

        // Teste 3: qtdDesenhistas (Na revista 1, quem desenhou foi o desenhista1)
        int qtdDes = app.qtdDesenhistas(revista1);
        System.out.println("3. Quantos desenhistas diferentes na revista 1? " + qtdDes + " (Esperado: 1)");

        // Teste 4: autorUsaPersonagem
        List<Historia> historicos = revista1.getHistorias();
        boolean usaPers = app.autorUsaPersonagem(historicos, escritor1, p2);
        System.out.println("4. O escritor Mauricio usa o Cebolinha nas histórias? " + usaPers + " (Esperado: true)");

        // Teste 5: pontuacaoTotal
        List<Autor> todosAutores = List.of(escritor1, desenhista1);
        int pontTotal = app.pontuacaoTotal(todosAutores);
        System.out.println("5. Pontuação total dos autores (50 + 28): " + pontTotal + " (Esperado: 78)");

        // Teste 6: pontuacaoDaRevista (Revista 1 tem o escritor1 e desenhista1)
        int pontRev = app.pontuacaoDaRevista(revista1);
        System.out.println("6. Pontuação total da Revista 1: " + pontRev + " (Esperado: 78)");

        System.out.println("\n=== TESTES FINALIZADOS COM SUCESSO! ===");

        System.out.println("\n--- TESTANDO CASOS EXTREMOS E NEGATIVOS ---");

        // Teste 7: possuiAutor retornando false
        Escritor escritorFalso = new Escritor("Stan Lee", 5, 9999);
        boolean naoTemAutor = app.possuiAutor(revista1, escritorFalso);
        System.out.println("7. A revista 1 possui o autor Stan Lee? " + naoTemAutor + " (Esperado: false)");

        // Teste 8: qtdRevistas para personagem inexistente/ausente
        Personagem pFalso = new Personagem("Hulk", 40);
        int qtdRevFalso = app.qtdRevistas(listaRevistas, pFalso);
        System.out.println("8. Em quantas revistas o Hulk aparece? " + qtdRevFalso + " (Esperado: 0)");

        // Teste 9: qtdDesenhistas em revista sem desenhistas (ou criando uma só com escritor)
        Historia hEscritorSo = new Historia("Romance Histórico", "Sem desenhos.");
        hEscritorSo.addAutor(escritor1);
        Revista revistaSoEscritor = new Revista("Livro Ilustrado", 1);
        revistaSoEscritor.addHistoria(hEscritorSo);
        
        int qtdDesZero = app.qtdDesenhistas(revistaSoEscritor);
        System.out.println("9. Quantos desenhistas na revista só de escritor? " + qtdDesZero + " (Esperado: 0)");

        // Teste 10: autorUsaPersonagem retornando false
        boolean autorNaoUsa = app.autorUsaPersonagem(historicos, escritor1, pFalso);
        System.out.println("10. O escritor Mauricio usa o Hulk? " + autorNaoUsa + " (Esperado: false)");

        System.out.println("\n--- TESTANDO MÉTODOS DE REMOÇÃO ---");

        // Teste 11: Remover autor da história
        System.out.println("Autores na h1 antes da remoção: " + h1.getAutores().size());
        h1.removeAutor("Titi Desenhista");
        System.out.println("Autores na h1 após remover o Titi: " + h1.getAutores().size() + " (Esperado: 1)");

        // Teste 12: Remover história da revista
        System.out.println("Histórias na revista 1 antes da remoção: " + revista1.getHistorias().size());
        revista1.removeHistoria("O Plano Infalível");
        System.out.println("Histórias na revista 1 após remoção: " + revista1.getHistorias().size() + " (Esperado: 1)");

        System.out.println("\n=== TODOS OS TESTES EXECUTADOS COM SUCESSO! ===");
    }

    public boolean possuiAutor(Revista revista, Autor autor) {
        for (Historia hist : revista.getHistorias()) {
            if (hist.possuiAutor(autor)) {
                return true;
            }
        }
        return false;
    }

    public int qtdRevistas(List<Revista> listaRevistas, Personagem personagem) {
        int qtd = 0;
        for (Revista rev : listaRevistas) {
            boolean exists = false;
            for (Historia hist : rev.getHistorias()) {

                for (Personagem pers : hist.getPersonagens()) {
                    if (pers.getNome().equals(personagem.getNome())) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    break;
                }
            }
            if (exists) {
                qtd++;
            }
        }
        return qtd;
    }

    public int qtdDesenhistas(Revista revista) {
        Set<Autor> autores = new HashSet<>();        
        for (Autor autor : revista.getAutores()) {
            if (autor instanceof Desenhista) {
                autores.add(autor);
            }
        }
        return autores.size();
    }

    public boolean autorUsaPersonagem(List<Historia> listaHistorias, Autor autor, Personagem personagem) {
        for (Historia hist : listaHistorias) {
            /** Verifica se a história pertence ao autor */
            if (!hist.possuiAutor(autor)) {
                continue;
            }
            for (Personagem pers : hist.getPersonagens()) {
                if (pers.getNome().equals(personagem.getNome())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int pontuacaoTotal(List<Autor> listaAutores) {
        int total = 0;
        for (Autor autor : listaAutores) {
            total += autor.getPontuacao();
        }
        return total;
    }

    public int pontuacaoDaRevista(Revista revista) {
        return this.pontuacaoTotal(revista.getAutores());
    }
}
