package ui;

import java.util.Scanner;

import control.GameController;

/**
 * Interfaz simple de Menu.
 */

public class MainMenu {
	
	private final Scanner scn = new Scanner(System.in);
    private GameController controller;
    private MenuGames menuGames = new MenuGames(controller);
    private MenuLists menuLists = new MenuLists(controller);
   
    public MainMenu(GameController controller) {
        this.menuGames = new MenuGames(controller);
        this.menuLists = new MenuLists(controller);
    }
    
    
	public void showMainMenu() {
		while(true) {
			System.out.println("==== MAIN MENU ====");
            System.out.println("1) Game options (Create / Update / Delete)");
            System.out.println("2) Listings (all, editors, by genre, 20th century)");
            System.out.println("0) Exit");
            System.out.print("Option: ");
            String opt = scn.nextLine();

			switch (opt) {
                case "1": menuGames.show(); break;
                case "2": menuLists.show(); break;
                case "0": System.out.println("Bye!"); return;
                default: System.out.println("Invalid option\n");
            }
		}
	}
	

}
