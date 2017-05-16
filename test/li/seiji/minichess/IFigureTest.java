package li.seiji.minichess;

import li.seiji.minichess.figure.IFigure;
import li.seiji.minichess.move.Move;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class IFigureTest {

    public static final String testState = "....." + System.lineSeparator() +
            "....." + System.lineSeparator() +
            "p..p." + System.lineSeparator() +
            "....." + System.lineSeparator() +
            "....." + System.lineSeparator() +
            "....." + System.lineSeparator();
    public static final String testState2 = "....." + System.lineSeparator() +
            "....." + System.lineSeparator() +
            ".p..q" + System.lineSeparator() +
            "....." + System.lineSeparator() +
            "....." + System.lineSeparator() +
            "....." + System.lineSeparator();

    @Test
    public void testCheckStraightIsBlocked() throws IOException {
        State state = new State();
        state.initialize();
        //bottom to up
        Move move = new Move("a2-a3");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("a2-a4");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("a2-a5");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("a2-a6");
        assertTrue(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));

        //up to bottom
        move = new Move("a5-a4");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("a5-a3");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("a5-a2");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("a5-a1");
        assertTrue(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));

        //left to right
        state.read(new StringReader(testState));
        move = new Move("a4-b4");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("a4-c4");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("a4-d4");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("a4-e4");
        assertTrue(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));

        //right to left
        state.read(new StringReader(testState2));
        move = new Move("e4-d4");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("e4-c4");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("e4-b4");
        assertFalse(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
        move = new Move("e4-a4");
        assertTrue(IFigure.checkStraightIsBlocked(state, move, player -> player != Player.NONE));
    }

    @Test
    public void testCheckDiagonalIsBlocked() {

    }

}
