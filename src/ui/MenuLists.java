package ui;

import java.util.List;
import java.util.Scanner;
import control.GameController;
import model.Game;

public class MenuLists {

    private final Scanner scn = new Scanner(System.in);
    private final GameController controller;

    public MenuLists(GameController controller) {
        this.controller = controller;
    }

    public void show() {
        while (true) {
            System.out.println("\n== Listings ==");
            System.out.println("1) List all games");
            System.out.println("2) List editors (distinct)");
            System.out.println("3) List games by genre");
            System.out.println("4) List 20th-century games (<= 2000)");
            System.out.println("0) Back");
            System.out.print("Option: ");
            String opt = scn.nextLine();

            switch (opt) {
                case "1": listAll(); break;
                case "2": listEditors(); break;
                case "3": listByGenre(); break;
                case "4": listCenturyXX(); break;
                case "0": return;
                default: System.out.println("Invalid option\n");
            }
        }
    }

    private void listAll() {
        List<Game> games = controller.listAll();
        if (games.isEmpty()) System.out.println("(empty)");
        else games.forEach(System.out::println);
        System.out.println();
    }

    private void listEditors() {
        List<String> editors = controller.listEditors();
        if (editors.isEmpty()) System.out.println("(empty)");
        else editors.forEach(e -> System.out.println("- " + e));
        System.out.println();
    }

    private void listByGenre() {
        System.out.print("Genre (ACCION/PUZZLE/SPORTS): ");
        String g = scn.nextLine();
        List<Game> games = controller.listByGenre(g);
        if (games.isEmpty()) System.out.println("(empty)");
        else games.forEach(System.out::println);
        System.out.println();
    }

    private void listCenturyXX() {
        List<Game> games = controller.listCenturyXX();
        if (games.isEmpty()) System.out.println("(empty)");
        else games.forEach(System.out::println);
        System.out.println();
    }
}
