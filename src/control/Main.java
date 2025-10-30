package control;

import dto.GameDataImpl;
import service.GameService;
import service.GameServiceImpl;
import ui.MainMenu;

public class Main {

	public static void main(String[] args) {
		
		GameDataImpl data = new GameDataImpl();
		GameService service = new GameServiceImpl(data);
		GameController controller = new GameController(service);
		
		MainMenu ui = new MainMenu(controller); 
		ui.showMainMenu();
		
		
	}

}
