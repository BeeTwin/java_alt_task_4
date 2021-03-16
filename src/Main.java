import Console.BorderType;
import Console.ConsolePentagoGame;
import Console.PentagoGameInterpreter;
import Pentago.GameState;
import Pentago.PentagoGame;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        var cpg = new ConsolePentagoGame(new PentagoGame(), BorderType.Double);
        cpg.run();
    }
}
