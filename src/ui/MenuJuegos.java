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
    System.out.println("== Crear juego ==");
    System.out.println("");
    System.out.print("Ranking (entero ≥ 1): ");
    String buffer = scn.nextLine();
    String ranking = scn.nextLine();

    System.out.println("Nombre: ");
    String name = scn.nextLine();

    System.out.print("Plataforma (PC, PS, XB, NI): ");
    String plataforma = scn.nextLine();

    System.out.print("Año (≥ 1970): ");
    String anio = scn.nextLine();

    System.out.print("Género (ACCION, PUZZLE, SPORTS): ");
    String genero = scn.nextLine();

    System.out.print("Editor: ");
    String editor = scn.nextLine();

    System.out.print("NA_Sales (>=0): ");
    String na = scn.nextLine();

    System.out.print("EU_Sales (>=0): ");
    String eu = scn.nextLine();

    System.out.print("JP_Sales (>=0): ");
    String jp = scn.nextLine();

    System.out.print("Other_Sales (>=0): ");
    String other = scn.nextLine();

    System.out.print("Global_Sales (>=0): ");
    String global = scn.nextLine();

    //String result = controller.createGame1(ranking);
    String result = controller.createGame(
        ranking, name, plataforma, anio, genero, editor, na, eu, jp, other, global
    );

    System.out.println(result);
    System.out.println();
}

	private void screenList() {
		
	}
	

}
