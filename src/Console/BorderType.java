package Console;

import java.util.HashMap;
import java.util.Map;

public enum BorderType {
    Single {
        protected Map<Place, Character> _singleChars = new HashMap<>(); {
            _singleChars.put(Place.BottomLeft,      '└');
            _singleChars.put(Place.BottomRight,     '┘');
            _singleChars.put(Place.TopRight,        '┐');
            _singleChars.put(Place.TopLeft,         '┌');
            _singleChars.put(Place.Horizontal,      '─');
            _singleChars.put(Place.Vertical,        '│');
            _singleChars.put(Place.LeftMiddle,      '├');
            _singleChars.put(Place.RightMiddle,     '┤');
            _singleChars.put(Place.TopMiddle,       '┬');
            _singleChars.put(Place.BottomMiddle,    '┴');
            _singleChars.put(Place.Centre,          '┼');
        }

        @Override
        Map<Place, Character> getChars() {
            return _singleChars;
        }
    },
    Double {
        protected Map<Place, Character> _doubleChars = new HashMap<>(); {
            _doubleChars.put(Place.BottomLeft,      '╚');
            _doubleChars.put(Place.BottomRight,     '╝');
            _doubleChars.put(Place.TopRight,        '╗');
            _doubleChars.put(Place.TopLeft,         '╔');
            _doubleChars.put(Place.Horizontal,      '═');
            _doubleChars.put(Place.Vertical,        '║');
            _doubleChars.put(Place.LeftMiddle,      '╠');
            _doubleChars.put(Place.RightMiddle,     '╣');
            _doubleChars.put(Place.TopMiddle,       '╦');
            _doubleChars.put(Place.BottomMiddle,    '╩');
            _doubleChars.put(Place.Centre,          '╬');
        }

        @Override
        Map<Place, Character> getChars() {
            return _doubleChars;
        }
    };
    abstract Map<Place, Character> getChars();

    public char getChar(Place place) {
        return getChars().get(place);
    }
}