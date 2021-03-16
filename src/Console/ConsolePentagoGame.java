package Console;

import Pentago.AlreadyOccupiedException;
import Pentago.GameState;
import Pentago.PentagoGame;

import java.awt.*;
import java.util.Scanner;

public class ConsolePentagoGame {
    private PentagoGame pentagoGame;

    public ConsolePentagoGame(PentagoGame pentagoGame, BorderType borderType) {
        PentagoGameInterpreter.borderType = borderType;
        this.pentagoGame = pentagoGame;
    }

    public void run() {
        var game = new PentagoGame();
        var state = GameState.None;
        Point point;
        Point rotate;
        Scanner in;
        boolean isToRight;
        do {
            System.out.println(game);

            System.out.println(game.pent + " to play.");
            try {
                System.out.print("Pent to: ");
                in = new Scanner(System.in);
                String[] input = in.nextLine().split(" ");
                point = new Point(Integer.parseInt(input[1]), Integer.parseInt(input[0]));

                System.out.print("Rotate square: ");
                in = new Scanner(System.in);
                input = in.nextLine().split(" ");
                rotate = new Point(Integer.parseInt(input[1]), Integer.parseInt(input[0]));

                System.out.print("To: ");
                in = new Scanner(System.in);
                isToRight = in.nextLine().equals("r");


                System.out.println();
                //Console.ClearScreen() i would like to......... :(
                try {
                    state = game.nextTurn(point, rotate, isToRight);
                } catch (AlreadyOccupiedException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Incorrect input. Try again.");
                continue;
            }
        } while (state.equals(GameState.None));

        System.out.println(game);

        System.out.println(state + (state.equals(GameState.Draw) ? "!" : " win!"));
    }
}
