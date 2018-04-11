import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Ship {
  private int x;
  private int y;
  private boolean isVertical;
  private int length;
  private boolean isAlive;
  private Display dis = new Display();
  private String shipName;
  public final Map<String, Integer> shipKinds = createMap();  

  /* Constructs ship and assigns values to its fields */

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

  /* Constructs ship without specifying fields, needed only for calling methods in other classes. */

  public Ship() {}

  /* Creates and returns map with names and lengths of possible ships. */

  public final Map<String, Integer> createMap() {
    Map<String, Integer> myMap = new HashMap<String, Integer>();
    myMap.put("Destroyer", 2);
    myMap.put("Submarine", 3);
    myMap.put("Cruiser", 3);
    myMap.put("Battleship", 4);
    myMap.put("Carrier", 5);

    return myMap;
  }

  /* Calls methods displayBoard and createShip in while loop until it get's a Ship possible to set on specified Board.
  When checkIfCanSetShip returns true, it leaves loop and calls setShipOnSquares on specified Board.
  If not, it calls method about wrong coordinates to show information about it to player and repeat loop.
  When all possible Ships are created, it calls setShipsAsCreated on specified Board.
  Returns list of Ships. */

  public Ship[] createShips(Board board) {
    Ship[] listOfShips = new Ship[5];
    String position;
    String shipName;
    Ship ship;

    for (int i = 0; i < 5; i++) {
      boolean canSetShip = false;

      while (canSetShip == false) {
        dis.displayBoards(board, "Beniz <3");        
        ship = createShip();        
        canSetShip = board.checkIfCanSetShip(ship);
        
        if (canSetShip == true) {
          if (isVertical == false) {
            position = "horizontal";
          } else {
            position = "vertical";
          }
          System.out.printf("Ship %s created as %s in chosen coordinates\n\n", shipName, position);
          listOfShips[i] = ship;
          board.setShipOnSquares(listOfShips[i]);
        } else {
          dis.wrongCoordsMassage4(ship.shipName);
        }
      }
      board.setShipsAsCreated();
    }
    return listOfShips;
  }

  /* Calls methods allowing player to create chosen ship on his board in specific position.
  Returns new object Ship. */

  public Ship createShip() {
    shipName = dis.chooseShip();
    boolean isVertical = dis.chooseIsVertical();
    int[] coords = board.coordinatesManager();
    Ship ship = new Ship(coords[0], coords[1], isVertical, shipName);
    return Ship;
  }

  

  /* Allows set isAlive boolean from other classes */

  public void setAlive(Ship ship, boolean alive) {
    ship.isAlive = alive;
  }

  /* Returns X coordinate */

  public int getXCord() {
    return this.x;
  }

  /* Returns Y coordinate */
  
  public int getYCord() {
    return this.y;
  }

  /* Returns isVertical boolean */

  public boolean getIsVertical() {
    return this.isVertical;
  }

  /* Returns length of this Ship */

  public int getLength() {
    return this.length;
  }

  /* Returns isAlive boolean of this Ship */

  public boolean getIsAlive() {
    return this.isAlive;
  }

  /* Returns name of this Ship */

  public String getShipName() {
    return this.shipName;
  }
}
