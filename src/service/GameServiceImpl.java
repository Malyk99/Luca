package service;

import dto.GameData;
import model.Game;

import java.util.List;
import java.util.Objects;



public class GameServiceImpl implements GameService {
	
	private final GameData data;
	
	public GameServiceImpl (GameData data) {
		
		this.data = Objects.requireNonNull(data);
	}	
	
	@Override
	public Game create(Game game) {
		return data.save(game);
	}

	@Override
	public List<Game> listAll() {
		
		return data.findAll() ;
	}

	@Override
	public Game update(Game game) {
		return null;
	}
	
	
	
	
}
