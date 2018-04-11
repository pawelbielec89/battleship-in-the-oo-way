import java.util.Random;

public class HardAI extends AI {

  private int[] shotCoords;
  private int xCoord;
  private int yCoord;
  private Random rand = new Random();
  /*
  Check if potentialShipContinuation is empty, if true shot in random square on given
  board else take random coordinate from potentialShipContinuation list and shot square
  with this coordinate on board, if at any point shot found ship set its adjacent
  diagonal squares status canShoot to false and put its vertical and horizontal squares
  coordinates to potentialShipContinuation list.
   * @param Board - board of AI enemy
   * @return none
  */
  public void hardAIShot(Board board) {
    if (potentialShipContinuation.isEmpty()) {
      shotCoords = randomAiCoordsToShot();
    } else {

      int randomPotentialCoords =
          this.potentialShipContinuation.get(rand.nextInt(potentialShipContinuation.size()));
      shotCoords = coordsToList(randomPotentialCoords);
    }
    if (board.getSquare(shotCoords[0], shotCoords[1]).getIsShip()) {
      setAdjacentStatus(board, shotCoords[0], shotCoords[1]);
      this.potentialShipContinuation =
          clearPotentialBoardList(allBoardCoords, potentialShipContinuation);
    }
    tryShoot(board, shotCoords[0], shotCoords[1]);
  }
}
