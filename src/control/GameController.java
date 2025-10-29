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
	
	/**ejemplo inicial crear juego con solo nombre*/
	
	public String createGame(String name) {
		try {
			if (name == null || name.isEmpty() || name.length()>100) {
				return "Error de input.";
			}
			Game game = new Game(name);
			Game create = service.create(game);
			return "Juego creado con éxito" +create;
		} catch (Exception ex) {
			return "Error inesperado: "+ex.getMessage();
		}
	}
	public List<Game> ListGames(){
		return service.listAll();
	}
	

}
