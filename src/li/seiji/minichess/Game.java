package li.seiji.minichess;

import li.seiji.minichess.move.Move;
import li.seiji.minichess.player.IPlayer;

public class Game {

    private Board state = new Board();
    private IPlayer white;
    private IPlayer black;

    public Game(IPlayer white, IPlayer black) {
        state.initialize();
        this.white = white;
        this.black = black;
    }

    public void run() throws InvalidMoveException {
        white.start();
        black.start();

        while(state.turn != Player.NONE) {
            IPlayer turnPlayer;
            IPlayer otherPlayer;
            if(state.turn == Player.WHITE) {
                turnPlayer = white; otherPlayer = black;
            } else {
                turnPlayer = black; otherPlayer = white;
            }

            Move move = turnPlayer.getMove(state);
            state = state.move(move);
            otherPlayer.setMove(state, move);
        }
    }

}
