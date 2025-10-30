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
	@Override
	public boolean delete(int ranking) {
		return data.deleteByRanking(ranking);
	}
	@Override
	public List<Game> listarPorGenero(model.Genero genero) {
		return data.findAll().stream()
				.filter(g -> g.getGenero() == genero)
				.toList();
	}
	@Override
	public List<String> listEditors() {	
		return data.findAll().stream()
				.map(Game::getEditor)
				.distinct()
				.toList();
	}
	@Override
	public List<Game> listarSigloXX() {
		final int anio = 2000;
		return data.findAll().stream()
				.filter (g -> g.getAnio() > anio)
				.toList();
	}


	
	
	
}
