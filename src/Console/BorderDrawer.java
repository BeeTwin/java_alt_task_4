package Console;

public class BorderDrawer {
    private BorderType borderType;

    public BorderDrawer(BorderType borderType) {
        this.borderType = borderType;
    }

    public char[][] draw() {
        char[][] res = new char[9][17];
        for(int y = 0; y < res.length; y++) {
            for(int x = 0; x < res[y].length; x++) {
                res[y][x] =
                        y == 0 || y == res.length - 1    || y == res.length / 2     ? borderType.getChar(Place.Horizontal)  :
                        x == 0 || x == res[y].length - 1 || x == res[y].length / 2  ? borderType.getChar(Place.Vertical) : ' ';
            }
        }

        res[0][0] =                                             borderType.getChar(Place.TopLeft);
        res[0][res[0].length / 2] =                             borderType.getChar(Place.TopMiddle);
        res[0][res[0].length - 1] =                             borderType.getChar(Place.TopRight);

        res[res.length / 2][0] =                                borderType.getChar(Place.LeftMiddle);
        res[res.length / 2][res[res.length / 2].length / 2] =   borderType.getChar(Place.Centre);
        res[res.length / 2][res[res.length / 2].length - 1] =   borderType.getChar(Place.RightMiddle);

        res[res.length - 1][0] =                                borderType.getChar(Place.BottomLeft);
        res[res.length - 1][res[res.length - 1].length / 2] =   borderType.getChar(Place.BottomMiddle);
        res[res.length - 1][res[res.length - 1].length - 1] =   borderType.getChar(Place.BottomRight);
        return res;
    }
}
