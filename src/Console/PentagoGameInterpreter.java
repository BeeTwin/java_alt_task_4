package Console;

import Pentago.PentagoGame;

public class PentagoGameInterpreter {
    public static BorderType borderType = BorderType.Single;

    public static String draw(PentagoGame pentagoGame) {
        var borderDrawer = new BorderDrawer(borderType);
        char[][] map = borderDrawer.draw();
        map = drawGame(map, pentagoGame);
        StringBuilder sb = new StringBuilder();
        for(char[] chrArr : map) {
            sb.append(new String(chrArr));
            sb.append("\n");
        }
        return sb.toString();
    }

    private static char[][] drawGame(char[][] map, PentagoGame pentagoGame) {
        for(var y = 0; y < 3; y++) {
            for(var x = 0; x < 6; x += 2) {
                map[y + 1][x + 2] =         pentagoGame.getPent(y, x / 2).toChar();
                map[y + 4 + 1][x + 2] =     pentagoGame.getPent(y + 3, x / 2).toChar();
                map[y + 4 + 1][x + 8 + 2] = pentagoGame.getPent(y + 3, x / 2 + 3).toChar();
                map[y + 1][x + 8 + 2] =     pentagoGame.getPent(y, x / 2 + 3).toChar();
            }
        }
        return map;
    }
}
