package li.seiji.minichess;

import li.seiji.minichess.move.Move;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class SquareTest {

    @Test
    public void testAutoPositionStringParsing() {
        String[][] positions = new String[Board.ROWS][Board.COLUMNS];
        for(int y = 0; y < Board.ROWS; ++y) {
            for(int x = 0; x < Board.COLUMNS; ++x) {
                char[] posStr = {
                        (char)((int)'a' + x),
                        (char)((int)'1' + y)
                }; //construct position strings like: "c4"
                positions[y][x] = new String(posStr);
            }
        }

        for(int y = 0; y < Board.ROWS; ++y) {
            for(int x = 0; x < Board.COLUMNS; ++x) {
                Square square = new Square(positions[y][x]);
                assertSquareCorrect(square, x, Board.ROWS - y);
            }
        }
    }

    @Test
    public void testPositionStringParsing() {
        for(int y = 0; y < 250; ++y) {
            for(int x = 0; x < 250; ++x) {
                Square square = new Square(x, y);
                Square parsedSquare = new Square(square.toString());
                assertEquals(parsedSquare.toString(), square.toString());
            }
        }
    }


    @Test
    public void testHashAndEquality() {
        HashSet<Square> squares = new HashSet<>();
        for(int y = 0; y < 250; ++y) {
            for(int x = 0; x < 250; ++x) {
                squares.add(new Square(x, y));
            }
        }

        //test that the HashSet can find them
        for(Square sqr : squares) {
            assertTrue(squares.contains(sqr));
        }
    }


    private static void assertSquareCorrect(Square square, int x, int y) {
        assertEquals(x, square.x);
        assertEquals(y, square.y);
    }

}
