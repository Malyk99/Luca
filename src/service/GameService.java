package service;

import model.Game;
import java.util.List;


//reglas del negocio

public interface GameService {
	Game create (Game game);
	List <Game> listAll();
	Game update(Game game);
	boolean delete (int ranking);
	List<Game> listarPorGenero (model.Genero genero);
	List<String> listEditors();
	List<Game> listarSigloXX ();
	
}
