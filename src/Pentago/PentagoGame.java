package Pentago;

import Console.BorderType;
import Console.PentagoGameInterpreter;

import java.awt.*;

public class PentagoGame {
    private PentagoMap pentagoMap = new PentagoMap();
    public Pent pent = Pent.White;

    public GameState nextTurn(Point point, Point rotate, boolean isToRight) throws AlreadyOccupiedException {
        GameState state;

        pentagoMap.setPent(point.y, point.x, pent);
        state = checkWin();
        if (!state.equals(GameState.None))
            return state;

        pentagoMap.rotate(rotate.y, rotate.x, isToRight);
        state = checkWin();
        if (state.equals(GameState.None))
            pent = pent.change();

        return state;
    }

    public Pent getPent(int y, int x) {
        return pentagoMap.getPent(y, x);
    }

    private GameState checkWin() {
        var isWhite = checkWin(Pent.White);
        var isBlack = checkWin(Pent.Black);

        return GameState.getState(isWhite, isBlack);
    }

    private boolean checkWin(Pent pentType) {
        for(var y = 0; y < 6; y++) {
            for(var x = 0; x < 6; x++) {
                if (checkWin(pentType, new Point(x, y))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Point[] ds = {
        new Point(1, 1),
        new Point(0, 1),
        new Point(1, 0),
        new Point(-1, 1)
    };

    private boolean checkWin(Pent pentType, Point point) {
        if(pentagoMap.getPent(point).equals(pentType)) {
            for(var d : ds) {
                if(checkWin(pentType, point, new Point(point.x + d.x, point.y + d.y), d.y, d.x, 1, false))
                    return true;
            }
        }
        return false;
    }

    private boolean checkWin(
            Pent pentType,
            Point start,
            Point current,
            int dy, int dx,
            int count,
            boolean isReversed) {
        if (count == 5)
            return true;

        if(!(current.x >= 0 && current.x <= 5 && current.y >= 0 && current.y <= 5))
            return false;

        if(pentagoMap.getPent(current).equals(pentType)) {
            if (isReversed) {
                current = start;
                dy *= -1;
                dx *= -1;
            } else {
                count++;
            }
        } else if (!isReversed){
            isReversed = true;
        } else {
            return false;
        }

        return checkWin(pentType, start, new Point(current.x + dx, current.y + dy), dy, dx, count, isReversed);
    }

    @Override
    public String toString() {
        return PentagoGameInterpreter.draw(this);
    }
}
