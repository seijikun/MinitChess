package li.seiji.minichess;

import com.sun.media.sound.InvalidFormatException;
import li.seiji.minichess.board.Board;
import li.seiji.minichess.board.State;

import java.util.regex.Pattern;

public class Square {

    private static Pattern positionStringPattern = Pattern.compile("[a-e][1-6]");

    public int x;
    public int y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Square(String position) throws InvalidFormatException {
        if(!positionStringPattern.matcher(position).matches())
            throw new InvalidFormatException("Not a valid position string");

        x = (position.charAt(0) - 'a');
        y = Board.ROWS - (position.charAt(1) - '1') - 1;
    }

    public char getFieldValue(State state) {
        return state.board[y][x];
    }

    public char getIdentifier(State state) {
        return getIdentifier(state.board, x, y);
    }

    public void setIdentifier(State state, char identifier) { state.board[y][x] = identifier; }

    @Override
    public String toString() {
        char[] posStr = {
                (char)((int)'a' + x),
                (char)((int)'1' +  (Board.ROWS - y - 1))
        };
        return new String(posStr);
    }

    @Override
    public int hashCode() {
        return x^y;
    }

    @Override
    public boolean equals(Object obj) {
        Square o = (Square)obj;
        return (o.x == x && o.y == y);
    }


    public static char getIdentifier(char[][] board, int x, int y) {
        char fieldVal = board[y][x];
        if(fieldVal >= 'A' && fieldVal <= 'Z')
            fieldVal += 32;
        return fieldVal;
    }

    public static char toIdenifier(char fieldVal) {
        if(fieldVal >= 'A' && fieldVal <= 'Z')
            fieldVal += 32;
        return fieldVal;
    }
}