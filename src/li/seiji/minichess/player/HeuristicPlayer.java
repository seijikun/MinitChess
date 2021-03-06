package li.seiji.minichess.player;

import li.seiji.minichess.InvalidMoveException;
import li.seiji.minichess.Player;
import li.seiji.minichess.board.Board;
import li.seiji.minichess.move.Move;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HeuristicPlayer extends PlayerBase {

    @Override
    public void start(Player color) {}

    @Override
    public Move getMove(Board board) throws InvalidMoveException {
        List<Move> possibleMoves = board.getPossibleMoves();
        Move bestMove = null;
        float bestScore = -Float.MAX_VALUE;
        for(Move possibleMove : possibleMoves) {

            board.state.move(possibleMove);
            float score = -evaluator.calculate(board.state, possibleMove);
            board.state.unmove(possibleMove);

            if(score > bestScore || (score == bestScore && ThreadLocalRandom.current().nextBoolean())) {
                bestMove = possibleMove;
                bestScore = score;
            }
        }

        return bestMove;
    }

    @Override
    public void setMove(Board state, Move move) {
    }

    @Override
    public void end() {

    }

}
