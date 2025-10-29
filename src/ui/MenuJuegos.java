package ui;

import java.util.Scanner;

import control.GameController;

/**
 * Interfaz simple de juegos.
 */

public class MenuJuegos {
	
	private final GameController controller;
	private final Scanner scn = new Scanner(System.in);
	
	public MenuJuegos(GameController controller) {
		this.controller = controller;
	}
	
	public void showMainMenu() {
		//int opt=1;
		while(true) {
			System.out.println("---LucaSteam - Game Library Manager---");
			System.out.println("1. Create Game");
			System.out.println("2. List Games");
			System.out.println("0. Exit");
			System.out.println("Option chosen:");
			
			int opt = scn.nextInt();
			switch (opt) {
				case 1:
					screenCreate();
					System.out.println("enter 1");
					
					break;
				case 2:
					screenList();
					break;
				case 0:
					System.out.println("Bye.");
					return;
				default:
					System.out.println("Not valid input.");
			}
		}
	}
	
	
	private void screenCreate() {
		System.out.print("Introduce the game name:");
		String name = scn.nextLine();
		//String show = controller.createGame(name);
		//System.out.println(show);
	}
	
	private void screenList() {
		
	}
	

}
