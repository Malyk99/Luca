package control;

import dto.GameDataImpl;
import service.GameService;
import service.GameServiceImpl;
import ui.MenuJuegos;

public class Main {

	public static void main(String[] args) {
		
		GameDataImpl data = new GameDataImpl();
		GameService service = new GameServiceImpl(data);
		GameController controller = new GameController(service);
		
		MenuJuegos ui = new MenuJuegos(controller); 
		ui.showMainMenu();
		
		
	}

}
