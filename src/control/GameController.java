package control;

import model.Game;
import model.Plataforma;
import model.Genero;
import service.GameService;

/**
 * Controller sencillo: valida lo mínimo y maneja todos los errores aquí.
 * La UI solo muestra el String devuelto.
 */
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    /**
     * Crea un juego con todos los campos
     */
    public String createGame(
            String rankingStr,
            String name,
            String plataformaStr,
            String anioStr,
            String generoStr,
            String editor,
            String naSalesStr,
            String euSalesStr,
            String jpSalesStr,
            String otherSalesStr,
            String globalSalesStr
    ) {
        try {
            if (name == null || name.trim().isEmpty()) {
                return "Error: el nombre es obligatorio.";
            }

            // Parseos simple si falla, devolvemos error genérico de input)
            final int ranking = Integer.parseInt(nonNullTrim(rankingStr));
            final int anio    = Integer.parseInt(nonNullTrim(anioStr));
            final double na   = Double.parseDouble(nonNullTrim(naSalesStr).replace(',', '.'));
            final double eu   = Double.parseDouble(nonNullTrim(euSalesStr).replace(',', '.'));
            final double jp   = Double.parseDouble(nonNullTrim(jpSalesStr).replace(',', '.'));
            final double other= Double.parseDouble(nonNullTrim(otherSalesStr).replace(',', '.'));
            final double global= Double.parseDouble(nonNullTrim(globalSalesStr).replace(',', '.'));
           
            final Plataforma plataforma = Plataforma.valueOf(nonNullTrim(plataformaStr).toUpperCase());
            final Genero genero         = Genero.valueOf(nonNullTrim(generoStr).toUpperCase());
            
            final String editorOk = editor == null ? "" : editor.trim();

            Game game = new Game(
                    ranking,
                    name.trim(),
                    plataforma,
                    anio,
                    genero,
                    editorOk,
                    na, eu, jp, other, global
            );

            Game created = service.create(game);
            return "Juego creado con éxito: " + created;

        } catch (IllegalArgumentException e) {
            return "Error de input (número o enum inválido).";
        } catch (Exception ex) {
            return "Error inesperado: " + ex.getMessage();
        }
    }
    
    /*public String createGame1(
            String rankingStr
            String name,
            String plataformaStr,
            String anioStr,
            String generoStr,
            String editor           
    ) {
        try {
            /*if (name == null || name.trim().isEmpty()) {
                return "Error: el nombre es obligatorio.";
            }

            // Parseos simple si falla, devolvemos error genérico de input)
            final int ranking = Integer.parseInt(nonNullTrim(rankingStr));
            //final int anio    = Integer.parseInt(nonNullTrim(anioStr));
           
            //final Plataforma plataforma = Plataforma.valueOf(nonNullTrim(plataformaStr).toUpperCase());
            /*final Genero genero         = Genero.valueOf(nonNullTrim(generoStr).toUpperCase());
            
            final String editorOk = editor == null ? "" : editor.trim();
            Game game = new Game(ranking);

            Game created = service.create(game);
            return "Juego creado con éxito: " + created;

        } catch (IllegalArgumentException e) {
            return "Error de input (número o enum inválido).";
        } catch (Exception ex) {
            return "Error inesperado: " + ex.getMessage();
        }
    }*/

   

    /**
     * Actualiza un juego existente (identificado por ranking).
     */
    public String updateGame(
            String rankingStr,
            String name,
            String plataformaStr,
            String anioStr,
            String generoStr,
            String editor,
            String naSalesStr,
            String euSalesStr,
            String jpSalesStr,
            String otherSalesStr,
            String globalSalesStr
    ) {
        try {
            if (name == null || name.trim().isEmpty()) {
                return "Error: el nombre es obligatorio.";
            }

            final int ranking = Integer.parseInt(nonNullTrim(rankingStr));
            final int anio    = Integer.parseInt(nonNullTrim(anioStr));
            final double na   = Double.parseDouble(nonNullTrim(naSalesStr).replace(',', '.'));
            final double eu   = Double.parseDouble(nonNullTrim(euSalesStr).replace(',', '.'));
            final double jp   = Double.parseDouble(nonNullTrim(jpSalesStr).replace(',', '.'));
            final double other= Double.parseDouble(nonNullTrim(otherSalesStr).replace(',', '.'));
            final double global=Double.parseDouble(nonNullTrim(globalSalesStr).replace(',', '.'));

            final Plataforma plataforma = Plataforma.valueOf(nonNullTrim(plataformaStr).toUpperCase());
            final Genero genero         = Genero.valueOf(nonNullTrim(generoStr).toUpperCase());
            final String editorOk       = editor == null ? "" : editor.trim();

            Game game = new Game(
                    ranking,
                    name.trim(),
                    plataforma,
                    anio,
                    genero,
                    editorOk,
                    na, eu, jp, other, global
            );

            Game updated = service.update(game);
            return "Juego actualizado con éxito: " + updated;

        } catch (IllegalArgumentException e) {
            return "Error de input (número o enum inválido).";
        } catch (Exception ex) {
            return "Error inesperado: " + ex.getMessage();
        }
    }


    public String deleteGame(String rankingStr) {
        try {
            final int ranking = Integer.parseInt(nonNullTrim(rankingStr));
            service.delete(ranking);
            return "Juego eliminado con éxito.";
        } catch (IllegalArgumentException e) {
            return "Error de input (número inválido).";
        } catch (Exception ex) {
            return "Error inesperado: " + ex.getMessage();
        }
    }

    private String nonNullTrim(String s) {
        return (s == null) ? "" : s.trim();
    }

    public java.util.List<model.Game> listAll() {
        return service.listAll();
    }

    public java.util.List<String> listEditors() {
        return service.listEditors(); // o construir aquí con stream sobre listarTodos()
    }

    public java.util.List<model.Game> listByGenre(String generoStr) {
        try {
            model.Genero genero = model.Genero.valueOf(generoStr.trim().toUpperCase());
            return service.listarPorGenero(genero);
        } catch (IllegalArgumentException e) {
            System.out.println("Género inválido.");
            return java.util.Collections.emptyList();
        }
    }

    public java.util.List<model.Game> listCenturyXX() {
        return service.listarSigloXX(); // año <= 2000
    }
}
