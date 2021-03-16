package Pentago;

import java.awt.*;

public class PentagoMap {
    private PentagoSquare[][] squares = new PentagoSquare[2][2]; {
        squares[0][0] = new PentagoSquare();
        squares[0][1] = new PentagoSquare();
        squares[1][1] = new PentagoSquare();
        squares[1][0] = new PentagoSquare();
    }

    public void setPent(int y, int x, Pent pent) throws AlreadyOccupiedException {
        int dy = 0, dx = 0;
        if (y > 2) {
            dy++;
        }
        if (x > 2) {
            dx++;
        }
        squares[dy][dx].setPent(y - dy * 3, x - dx * 3, pent);
    }

    public Pent getPent(int y, int x) {
        int dy = 0, dx = 0;
        if (y > 2) {
            dy++;
        }
        if (x > 2) {
            dx++;
        }
        return squares[dy][dx].getPent(y - dy * 3, x - dx * 3);
    }

    public Pent getPent(Point point) {
        return getPent(point.y, point.x);
    }

    public void rotate(int y, int x, boolean isToRight) {
        if(isToRight)
            squares[y][x].rotateRight();
        else
            squares[y][x].rotateLeft();
    }
}
