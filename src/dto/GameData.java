package dto;

import java.util.List;

import model.Game;

public interface GameData {
	Game save(Game game);
	List<Game> findAll();
	boolean deleteByRanking(int ranking);
	

}
