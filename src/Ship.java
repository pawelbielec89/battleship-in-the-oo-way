import java.util.HashMap;
import java.util.Map;

public class Ship {
  private int x;
  private int y;
  private static boolean isVertical;
  private int length;
  private boolean isAlive;
  private Display dis = new Display();
  private String shipName;

  public Ship(int x, int y, boolean isVertical, String shipName) {
    this.shipName = shipName;
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

  public final Map<String, Integer> createMap() {
    Map<String, Integer> myMap = new HashMap<String, Integer>();
    myMap.put("Destroyer", 2);
    myMap.put("Submarine", 3);
    myMap.put("Cruiser", 3);
    myMap.put("Battleship", 4);
    myMap.put("Carrier", 5);

    return myMap;
  }

  public final Map<String, Integer> shipKinds = createMap();

  public Ship[] createShips(Board board) {
    Ship[] listOfShips = new Ship[5];
    String position;
    String shipName;
    Ship ship;

    for (int i = 0; i < 5; i++) {
      boolean canSetShip = false;

      while (canSetShip == false) {
        shipName = dis.chooseShip();
        boolean isVertical = dis.chooseIsVertical();
        int[] coords = board.coordinatesManager();
        ship = new Ship(coords[0], coords[1], isVertical, shipName);
        canSetShip = board.checkIfCanSetShip(ship);
        System.out.print("beeeeniz" + canSetShip);

        if (canSetShip == true) {
          if (isVertical == false) {
            position = "horizontal";
          } else {
            position = "vertical";
          }
          System.out.printf("Ship %s created as %s in chosen coordinates\n\n", shipName, position);
          listOfShips[i] = ship;
          board.setShipOnSquares(listOfShips[i]);
          dis.displayBoards(board, board);
        } else {
          dis.wrongCoordsMassage4(shipName);
        }
      }
    }
    return listOfShips;
  }

  public int getXCord() {
    return this.x;
  }

  public int getYCord() {
    return this.y;
  }

  public boolean getIsVertical() {
    return this.isVertical;
  }

  public int getLength() {
    return this.length;
  }

  public boolean getIsAlive() {
    return this.isAlive;
  }

  public String getShipName() {
    return this.shipName;
  }
}
