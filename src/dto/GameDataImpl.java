package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Game;

//Como se usa GameDAta

public class GameDataImpl implements GameData {
private final List<model.Game> games = new ArrayList<>();
	
	@Override
	public Game save(Game game) {
		games.add(game);
		return game;
	}
	
	@Override
	public List<Game> findAll(){
		return Collections.unmodifiableList(games);
	}
	@Override
	public boolean deleteByRanking(int ranking) {
		return games.removeIf(g -> g.getRanking() == ranking);
	}
	
}
