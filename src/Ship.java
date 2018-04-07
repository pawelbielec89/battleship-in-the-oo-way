import java.util.HashMap;
import java.util.Map;

public class Ship {
  private int x;
  private int y;
  private boolean isVertical;
  private int length;
  private boolean isAlive;
  private Display dis = new Display();

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

  public Ship[] createShips() {
    Ship[] listOfShips = new Ship[5];

    for (int i = 0; i < 5; i++) {

        String shipName = dis.chooseShip();        
        boolean isVertical = dis.chooseIsVertical();
        int[] cords = dis.chooseCords();
        listOfShips[i] = new Ship(cords[0], cords[1], isVertical, shipName);
    }
    return listOfShips;
  }
  
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

}
