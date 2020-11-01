package schack.engine;

import schack.Position;

import java.util.List;

public interface Engine {

    /**
     * Gets the optimal position from a given position
     * @param position the current position
     * @return the position that will arise when performing the best possible move
     */
    public Position getMove(Position position);


}
