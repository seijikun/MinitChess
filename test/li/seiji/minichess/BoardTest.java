package li.seiji.minichess;

import li.seiji.minichess.board.Board;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void testBoardParsing() throws IOException {
        Board board = new Board();
        board.state.read(new StringReader(Board.DEFAULT_BOARD));

        char[][] defaultBoard = {
                {'k', 'q', 'b', 'n', 'r'},
                {'p', 'p', 'p', 'p', 'p'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'P', 'P', 'P', 'P', 'P'},
                {'R', 'N', 'B', 'Q', 'K'},
        };

        for(int y = 0; y < Board.ROWS; ++y) {
            for(int x = 0; x < Board.COLUMNS; ++x) {
                assertTrue(board.state.board[y][x] == defaultBoard[y][x]);
            }
        }
    }

}
