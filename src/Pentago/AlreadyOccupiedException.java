package Pentago;

public class AlreadyOccupiedException extends Exception {
    @Override
    public String getMessage() {
        return "This pent is already occupied!";
    }
}
