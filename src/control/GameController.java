package control;

import java.util.List;

import model.Game;
import service.GameService;

/**
 * El orquestrador del programa, dirige según las peticiones del usuario filtrando las excepciones
 */

public class GameController {
	
	private final GameService service;
	
	public GameController(GameService service) {
		this.service = service;
	}
	
	/**ejemplo inicial crear juego*/
	public String createGame(String name) { 
		try { if (name == null || name.isEmpty() || name.length()>100) {
			return "Error de input."; }
			Game game = new Game(name);
			Game create = service.create(game);
			return "Juego creado con éxito" +create; 
		} catch (Exception ex) {
			return "Error inesperado: "+ex.getMessage();
		} 
	}
	public String createGame(
        String rankingStr, String name, String plataformaStr, String anioStr,
        String generoStr, String editor, String naSalesStr, String euSalesStr,
        String jpSalesStr, String otherSalesStr, String globalSalesStr
) {
    try {
        if (name == null || name.trim().isEmpty() || name.length() > 100)
            return "Error: el nombre es obligatorio (≤ 100).";

        Integer ranking = parseIntSafe(rankingStr);
        if (ranking == null || ranking < 1)
            return "Error: ranking inválido.";

        Integer anio = parseIntSafe(anioStr);
        if (anio == null || anio < 1970)
            return "Error: año inválido (≥ 1970).";

        Double na = parseDoubleNonNegative(naSalesStr);
        Double eu = parseDoubleNonNegative(euSalesStr);
        Double jp = parseDoubleNonNegative(jpSalesStr);
        Double other = parseDoubleNonNegative(otherSalesStr);
        Double global = parseDoubleNonNegative(globalSalesStr);
        if (na == null || eu == null || jp == null || other == null || global == null)
            return "Error: ventas inválidas (≥ 0).";

        Plataforma plataforma = parsePlataforma(plataformaStr);
        Genero genero = parseGenero(generoStr);
        if (plataforma == null) return "Error: plataforma inválida.";
        if (genero == null) return "Error: género inválido.";

        Game game = new Game(ranking, name.trim(), plataforma, anio, genero,
                             editor.trim(), na, eu, jp, other, global);

        Game created = service.create(game);
        return "Juego creado con éxito: " + created;

    } catch (Exception ex) {
        return "Error inesperado: " + ex.getMessage();
    }


	public List<Game> ListGames(){
		return service.listAll();
	}
	

}
