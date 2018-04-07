import java.util.HashMap;
import java.util.Map;

public class Ship {
  private int x;
  private int y;
  private boolean isVertical;
  private int length;
  private boolean isAlive;
  private String input = new Inputs().getInput();

  public Ship(int x, int y, boolean isVertical, String shipName) {
    this.x = x;
    this.y = y;
    this.isVertical = isVertical;
    this.isAlive = true;
    if (shipKinds.containsKey(shipName)) {
      this.length = shipKinds.get(shipName);
    }
  }

  public Ship() {}

  public void setAlive(Ship ship, boolean alive) {
    ship.isAlive = alive;
  }

  public static Map<String, Integer> createMap() {
    Map<String, Integer> myMap = new HashMap<String, Integer>();
    myMap.put("Destroyer", 2);
    myMap.put("Submarine", 3);
    myMap.put("Cruiser", 3);
    myMap.put("Battleship", 4);
    myMap.put("Carrier", 5);

    return myMap;
  }

  public static final Map<String, Integer> shipKinds = createMap();

  public int[] getCord() {
    System.out.println("Enter coordinates: ");

    String cord = input;
    char[] cordsAsChars = cord.toCharArray();
    int cord1 = (int) cordsAsChars[0] - 97;
    int cord2 = (int) cordsAsChars[1] - 49;
    int cords[] = {cord1, cord2};

    return cords;
  }

  //   public Ship createShip(int length) {

  //     //System.out.println("Creating ship " + name);
  //     int[] cords = Display.getCord();
  //     int cordX = cords[0];
  //     int cordY = cords[1];
  //     boolean isVertical;
  //     System.out.println("Vertical or horizontal? 0/1");
  //     int vertical = input.getInt();

  //     if (vertical == 0) {
  //       isVertical = true;
  //     } else isVertical = false;
  //     Ship newShip = new Ship(cordX, cordY, isVertical, length);
  //     Map<String, Integer> map = shipKinds;

  //     return newShip;
  //  }

  public void setShipOnSquares(Ship ship, Board board) {
    int cordY = ship.y;
    int cordX = ship.x;
    for (int i = 0; i < ship.getLength(); i++) {
      board.getSquare(cordX, cordY).setIsShip(true);
      board.getSquare(cordX, cordY).setIsOccupiedArea(true);

      if (isVertical == true) {
        cordY += 1;
        if (i > 0 && i < (ship.getLength() - 1)) {
          board.getSquare(cordX - 1, cordY).setIsOccupiedArea(true);
          board.getSquare(cordX + 1, cordY).setIsOccupiedArea(true);
        } else if (i > 0) {
          board.getSquare(cordX, cordY - 1).setIsOccupiedArea(true);
        } else board.getSquare(cordX, cordY + 1).setIsOccupiedArea(true);
      } else {
        cordX += 1;
      }
    }
  }

  //   public Ship createShip(int length) {

  //     //System.out.println("Creating ship " + name);
  //     int[] cords = Display.getCord();
  //     int cordX = cords[0];
  //     int cordY = cords[1];
  //     boolean isVertical;
  //     System.out.println("Vertical or horizontal? 0/1");
  //     int vertical = input.getInt();

  //     if (vertical == 0) {
  //       isVertical = true;
  //     } else isVertical = false;
  //     Ship newShip = new Ship(cordX, cordY, isVertical, length);
  //     Map<String, Integer> map = shipKinds;

  //     return newShip;
  //
  public void setShipOnSquares(Ship ship, Board board) {
    int cordY = ship.y;
    int cordX = ship.x;
    for (int i = 0; i < ship.length; i++) {
      board.getSquare(cordX, cordY).setIsShip(true);
      board.getSquare(cordX, cordY).setIsOccupiedArea(true);

      try {

        if (isVertical == true) {
          cordY += 1;
          if (i > 0 && i < (ship.length - 1)) {
            board.getSquare(cordX - 1, cordY).setIsOccupiedArea(true);
            board.getSquare(cordX + 1, cordY).setIsOccupiedArea(true);
          } else if (i > 0) {
            board.getSquare(cordX, cordY - 1).setIsOccupiedArea(true);
          } else board.getSquare(cordX, cordY + 1).setIsOccupiedArea(true);
        } else {
          cordX += 1;
          if (i > 0 && i < (ship.length - 1)) {
            board.getSquare(cordX, cordY - 1).setIsOccupiedArea(true);
            board.getSquare(cordX, cordY + 1).setIsOccupiedArea(true);
          } else if (i > 0) {
            board.getSquare(cordX, cordY - 1).setIsOccupiedArea(true);
          } else board.getSquare(cordX, cordY + 1).setIsOccupiedArea(true);
        }
      } catch (ArrayIndexOutOfBoundsException ex) {
        System.out.println("fff");
      }
    }
  }

  public int getXCord() {
    return x;
  }

  public int getYCord() {
    return y;
  }

  public boolean getIsVertical() {
    return isVertical;
  }

  public int getLength() {
    return length;
  }

  public boolean getIsAlive() {
    return isAlive;
  }

  public int getLength() {
    return length;
  }
}
