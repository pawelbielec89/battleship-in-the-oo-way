import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Ship {
  private int x;
  private int y;
  private boolean isVertical;
  private int length;
  private boolean isAlive;
  private Display dis = new Display();
  private String shipName;
  public final Map<String, Integer> shipKinds = createMap();
  public List<String> positionsOfShip = new ArrayList<>();
  private List<String> occupiedAreaCoords = new ArrayList<>();
  private List<String> ships =
      new ArrayList<>(Arrays.asList("Destroyer", "Submarine", "Cruiser", "Battleship", "Carrier"));
  private Random generator = new Random();
  static boolean aiMode = false;

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

  public void createShips(Board board) {
    String position;
    Ship ship;

    for (int i = 0; i < 5; i++) {
      boolean canSetShip = false;

      while (canSetShip == false) {
        int randomIndex = generator.nextInt(ships.size());
        shipName = ships.get(randomIndex);

        dis.displayBoards(board, "Player");
        if (aiMode) {
        ship = randomShipCreation(board, i, shipName);
        }
        else { ship = createShip(board); }
        canSetShip = board.checkIfCanSetShip(ship);

        if (canSetShip == true) {
          if (isVertical == false) {
            position = "horizontal";
          } else {
            position = "vertical";
          }
          System.out.printf(
              "Ship %s created as %s in chosen coordinates\n\n", ship.shipName, position);
          System.out.print("\033[H\033[2J");
              
          board.listOfShips[i] = ship;
          board.setShipOnSquares(ship);
          ships.remove(randomIndex);
        } else {
          dis.wrongCoordsMassage4(ship.shipName);
        }
      }
    }
    board.setShipsAsCreated();
  }

  /* Testing method */

  public Ship fakeShipCreation(Board board, int i) {
    shipName = dis.chooseShip();
    boolean isVertical = true;
    int[] coords = new int[2];
    switch (i) {
      case 0:
        coords[1] = 0;
        coords[0] = 0;
        break;
      case 1:
        coords[1] = 0;
        coords[0] = 2;
        break;
      case 2:
        coords[1] = 0;
        coords[0] = 4;
        break;
      case 3:
        coords[1] = 0;
        coords[0] = 6;
        break;
      case 4:
        coords[1] = 0;
        coords[0] = 8;
        break;
    }
    Ship ship = new Ship(coords[0], coords[1], isVertical, shipName);
    return ship;
  }

  public static boolean getRandomBoolean() {
    return Math.random() < 0.5;
  }

  public Ship randomShipCreation(Board board, int i, String shipName) {
    boolean isVertical = getRandomBoolean();
    int[] coords = new int[2];

    switch (i) {
      case 0:
        coords[1] = generator.nextInt(10);
        coords[0] = generator.nextInt(10);
        break;
      case 1:
        coords[1] = generator.nextInt(10);
        coords[0] = generator.nextInt(10);
        break;
      case 2:
        coords[1] = generator.nextInt(10);
        coords[0] = generator.nextInt(10);
        break;
      case 3:
        coords[1] = generator.nextInt(10);
        coords[0] = generator.nextInt(10);
        break;
      case 4:
        coords[1] = generator.nextInt(10);
        coords[0] = generator.nextInt(10);
        break;
    }
    Ship ship = new Ship(coords[0], coords[1], isVertical, shipName);
    return ship;
  }

  /* Calls methods allowing player to create chosen ship on his board in specific position.
  Returns new object Ship. */

  public Ship createShip(Board board) {
    shipName = dis.chooseShip();
    boolean isVertical = dis.chooseIsVertical();
    int[] coords = board.coordinatesManager();
    Ship ship = new Ship(coords[0], coords[1], isVertical, shipName);
    return ship;
  }

  public String coordsToString(int x, int y) {
    String intStringX = Integer.toString(x);
    String intStringY = Integer.toString(y);
    return intStringY + intStringX;
  }

  public void addToPositionsList(int x, int y) {
    String coords = coordsToString(x, y);
    this.positionsOfShip.add(coords);
  }

  public void addToOccupationList(int x, int y) {
    String coords = coordsToString(x, y);
    this.occupiedAreaCoords.add(coords);
  }

  public boolean getIsShipOnPosition(int x, int y) {
    String coords = coordsToString(x, y);
    if (this.positionsOfShip.contains(coords)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean getIsAreaAroundShip(int y, int x) {
    String coords = coordsToString(y, x);
    if (this.occupiedAreaCoords.contains(coords)) {
      return true;
    } else {
      return false;
    }
  }

  public void looseLife(int x, int y) {
    // String coords = coordsToString(x, y);
    // try {
    this.length--;
    if (this.length < 1) {
      this.isAlive = false;
    }
    // } catch (ArrayIndexOutOfBoundsException ex) {
    // }
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
