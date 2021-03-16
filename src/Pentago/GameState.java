package Pentago;

public enum GameState {
    White,
    Black,
    Draw,
    None;

    public static GameState getState(boolean isWhite, boolean isBlack) {
        if(isBlack) {
            if (isWhite) {
                return GameState.Draw;
            } else {
                return GameState.Black;
            }
        } else if (isWhite) {
            return GameState.White;
        } else {
            return GameState.None;
        }
    }
}
