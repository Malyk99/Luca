package service;

import model.Game;
import java.util.List;


//reglas del negocio

public interface GameService {
	Game create (Game game);
	List <Game> listAll();
}
