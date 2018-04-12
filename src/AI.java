import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AI extends Player {
  public List<Integer> allBoardCoords = new ArrayList<>();
  public List<Integer> potentialShipContinuation = new ArrayList<>();
  private int upPotential;
  private int downPotential;
  private int leftPotential;
  private int rightPotential;

  public AI() {
    for (int i = 0; i < 100; i++) {
      this.allBoardCoords.add(i);
    }
  }
  /*
  Get random integer from list, remove it and split it's characters to list of integers.
   * @param none.
   * @return List of integers.
  */
  public int[] randomAiCoordsToShot(List<Integer> array) {
    int[] shotCoords = {0, 0};
    int randomCoord = getRandomCoordFromList(array);
    shotCoords = coordsToList(array.get(randomCoord));
    removeCoordsFromList(array, randomCoord);
    return shotCoords;
  }
  /*
  Get random integer from list.
   * @param List of Integers.
   * @return Integer.
  */
  public int getRandomCoordFromList(List<Integer> array) {
    int randomCoordFromList = new Random().nextInt(array.size());
    return randomCoordFromList;
  }
  /*
  Get Integer and remove equal values from list
   * @param Integer
   * @return none
  */
  public void removeCoordsFromList(List<Integer> array, int randomCoord) {
    array.remove(randomCoord);
  }
  /*
  Get set of integers and concatenate its characters to integer
   * @param Integers to concatenate
   * @return Integer
  */
  public int coordsToInt(int x, int y) {
    String intStringX = Integer.toString(x);
    String intStringY = Integer.toString(y);
    return Integer.parseInt(intStringY + intStringX);
  }
  /*
  Get integer and split its characters to list of integers
   * @param Integer
   * @return List of integers
  */
  public int[] coordsToList(int x) {
    int[] coordsInList = {0, 0};
    String stringCoords = Integer.toString(x);
    int xCoord;
    int yCoord;
    if (stringCoords.length() < 2) {
      xCoord = 0;
      yCoord = x;
    } else {
      char xCoordChar = stringCoords.charAt(0);
      char yCoordChar = stringCoords.charAt(1);
      xCoord = Character.getNumericValue(xCoordChar);
      yCoord = Character.getNumericValue(yCoordChar);
    }
    coordsInList[0] = xCoord;
    coordsInList[1] = yCoord;
    return coordsInList;
  }
  /*
  Set square and adjacent diagonally squares canShoot to false and
  put its vertical and horizontal adjacent squares coordinates to potentialShipContinuation
  list as integer
   * @param Board board
   * @param Integer coordinate x of square in board
   * @param Integer coordinate y of square in board
   * @return none
  */
  public void setAdjacentStatus(Board board, int x, int y) {
    excludeCoordsFromBoardCoordList(board, x, y);
    addPotentialShipCoordsToList(board, x, y);
  }
  /*
  Set square and adjacent diagonally squares canShoot to false
   * @param Board board
   * @param Integer coordinate x of square in board
   * @param Integer coordinate y of square in board
   * @return none
  */
  private void excludeCoordsFromBoardCoordList(Board board, int x, int y) {
    board.getSquare(x, y).setCanShoot(false);
    try {
      board.getSquare(x - 1, y - 1).setCanShoot(false);
    } catch (IndexOutOfBoundsException exLeftUp) {;
    }
    try {
      board.getSquare(x - 1, y + 1).setCanShoot(false);
    } catch (IndexOutOfBoundsException exLeftDown) {;
    }
    try {
      board.getSquare(x + 1, y - 1).setCanShoot(false);
    } catch (IndexOutOfBoundsException exRightDown) {;
    }
    try {
      board.getSquare(x + 1, y + 1).setCanShoot(false);
    } catch (IndexOutOfBoundsException exRightUp) {;
    }
  }
  /*
  Put square vertical and horizontal adjacent squares coordinates to potentialShipContinuation
  list as integer
   * @param Integer coordinate x of square in board
   * @param Integer coordinate y of square in board
   * @return none
  */
  private void addPotentialShipCoordsToList(Board board, int x, int y) {
    try {
      upPotential = coordsToInt(x, (y - 1));
      if (board.getSquare(x, y).getCanShoot()) {;
      } else {
        potentialShipContinuation.add(upPotential);
      }

    } catch (IndexOutOfBoundsException exUp) {;
    }

    try {
      downPotential = coordsToInt(x, (y + 1));
      if (board.getSquare(x, y).getCanShoot()) {;
      } else {
        potentialShipContinuation.add(downPotential);
      }

    } catch (IndexOutOfBoundsException exDown) {;
    }

    try {
      leftPotential = coordsToInt((x - 1), y);
      if (board.getSquare(x, y).getCanShoot()) {;
      } else {
        potentialShipContinuation.add(leftPotential);
      }

    } catch (IndexOutOfBoundsException exLeft) {;
    }

    try {
      rightPotential = coordsToInt((x + 1), y);
      if (board.getSquare(x, y).getCanShoot()) {;
      } else {
        potentialShipContinuation.add(rightPotential);
      }

    } catch (IndexOutOfBoundsException exRight) {;
    }
  }
}
