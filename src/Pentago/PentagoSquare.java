package Pentago;

import java.util.Arrays;

public class PentagoSquare {
    private Pent[][] pents = new Pent[3][3];

    public PentagoSquare() {
        for(var y = 0; y < 3; y++) {
            for(var x = 0; x < 3; x++) {
                pents[y][x] = Pent.None;
            }
        }
    }

    public Pent getPent(int y, int x) {
        return pents[y][x];
    }

    public void setPent(int y, int x, Pent pent) throws AlreadyOccupiedException {
        if (pents[y][x].equals(Pent.None))
            pents[y][x] = pent;
        else
            throw new AlreadyOccupiedException();
    }

    public void rotateLeft() {
        rotate(0, 1, 2, -1);
    }

    public void rotateRight() {
        rotate(2,-1,0,1);
    }

    private void rotate(int dy, int my, int dx, int mx) {
        Pent[][] newPents = new Pent[3][3];
        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                newPents[dx + mx * x][dy + my * y] = pents[y][x];
            }
        }
        pents = newPents;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for(var y = 0; y < 3; y++) {
            for (var x = 0; x < 3; x++) {
                sb.append(pents[y][x].equals(Pent.White) ? "W " : pents[y][x].equals(Pent.Black) ? "B " : "_ ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
