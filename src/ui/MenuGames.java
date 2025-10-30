package ui;

import java.util.Scanner;
import control.GameController;

public class MenuGames {

    private final Scanner scn = new Scanner(System.in);
    private final GameController controller;

    public MenuGames(GameController controller) {
        this.controller = controller;
    }

    public void show() {
        while (true) {
            System.out.println("\n== Game Options ==");
            System.out.println("1) Create game");
            System.out.println("2) Update game (by ranking)");
            System.out.println("3) Delete game (by ranking)");
            System.out.println("0) Back");
            System.out.print("Option: ");
            String opt = scn.nextLine();

            switch (opt) {
                case "1": screenCreate(); break;
                case "2": screenUpdate(); break;
                case "3": screenDelete(); break;
                case "0": return;
                default: System.out.println("Invalid option\n");
            }
        }
    }

    private void screenCreate() {
        System.out.println("-- Create game --");
        System.out.print("Ranking: ");        String ranking = scn.nextLine();
        System.out.print("Name: ");           String name = scn.nextLine();
        System.out.print("Platform (PC/PS/XB/NI): "); String plat = scn.nextLine();
        System.out.print("Year: ");           String year = scn.nextLine();
        System.out.print("Genre (ACCION/PUZZLE/SPORTS): "); String gen = scn.nextLine();
        System.out.print("Editor: ");         String editor = scn.nextLine();
        System.out.print("NA_Sales: ");       String na = scn.nextLine();
        System.out.print("EU_Sales: ");       String eu = scn.nextLine();
        System.out.print("JP_Sales: ");       String jp = scn.nextLine();
        System.out.print("Other_Sales: ");    String other = scn.nextLine();
        System.out.print("Global_Sales: ");   String global = scn.nextLine();

        String res = controller.createGame(ranking, name, plat, year, gen, editor, na, eu, jp, other, global);
        System.out.println(res + "\n");
    }

    private void screenUpdate() {
        System.out.println("-- Update game (by ranking) --");
        System.out.print("Ranking (existing): "); String ranking = scn.nextLine();
        System.out.print("Name: ");               String name = scn.nextLine();
        System.out.print("Platform (PC/PS/XB/NI): "); String plat = scn.nextLine();
        System.out.print("Year: ");               String year = scn.nextLine();
        System.out.print("Genre (ACCION/PUZZLE/SPORTS): "); String gen = scn.nextLine();
        System.out.print("Editor: ");             String editor = scn.nextLine();
        System.out.print("NA_Sales: ");           String na = scn.nextLine();
        System.out.print("EU_Sales: ");           String eu = scn.nextLine();
        System.out.print("JP_Sales: ");           String jp = scn.nextLine();
        System.out.print("Other_Sales: ");        String other = scn.nextLine();
        System.out.print("Global_Sales: ");       String global = scn.nextLine();

        String res = controller.updateGame(ranking, name, plat, year, gen, editor, na, eu, jp, other, global);
        System.out.println(res + "\n");
    }

    private void screenDelete() {
        System.out.println("-- Delete game (by ranking) --");
        System.out.print("Ranking: ");
        String ranking = scn.nextLine();
        String res = controller.deleteGame(ranking);
        System.out.println(res + "\n");
    }
}
