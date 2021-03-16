package Pentago;

public enum Pent {
    None,
    White,
    Black;

    public Pent change() {
        return this.equals(Pent.White) ? Pent.Black : Pent.White;
    }

    public GameState toState() {
        return this.equals(Pent.White) ? GameState.White :
               this.equals(Pent.Black) ? GameState.Black : GameState.None;
    }

    public char toChar() {
        return this.equals(Pent.White) ? 'W' :
               this.equals(Pent.Black) ? 'B' : '░';
    }
}
