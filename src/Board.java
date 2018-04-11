import java.util.List;
import java.util.ArrayList;
import org.omg.CORBA.TCKind;

public class Board {

  private int BOARDSIZE = 10;
  private Square[][] gameBoard = new Square[BOARDSIZE][BOARDSIZE];
  private boolean isHidden;
  private Display dis = new Display();
  private boolean shipsAreCreated = false;

  public Board() {
    isHidden = false; // isHidden = false - current player board, true - another player
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        gameBoard[i][j] = new Square();
      }
    }
  }

  /* Method which prints a chosen square's properties. It is not used yet. 
  Returns void.
  Actually maybe we will cancel it? 
  */

  public void printSquare(int x, int y) {
    Square sqr = getSquare(x, y);
    System.out.println(sqr.getIsShip());
    System.out.println(sqr.getCanShoot());
    System.out.println(sqr.getIsOccupiedArea());
  }

/* Returns a specific object Square stored in gameBoard array */

  public Square getSquare(int y, int x) {
    return gameBoard[x][y];
  }
  
  public void setIsHidden(boolean isHidden) {
    this.isHidden = isHidden;
  }

  public boolean getIsHidden() {
    return isHidden;
  }

  /*Checks whether coordinates are properly chosen - if object Square in this Board is already
  shooted or occupied, it returns false.
  Calls getCanShoot() and getIsOccupiedArea() on object Square in this Board.
  Returns boolean*/
  
  public boolean checkCoords(int x, int y) {
    boolean coordsAreProper = false; 

    if (this.getSquare(x, y).getCanShoot() == false) { dis.wrongCoordsMassage3(); }
    else if (this.getSquare(x, y).getIsOccupiedArea()) {
      if (shipsAreCreated) { coordsAreProper = true; } 
      else { dis.wrongCoordsMassage2(); }
    }
    else { coordsAreProper = true; }
       
    return coordsAreProper;
    }

  /* Checks is it possible to set object Ship on specific coordinates(x and y variables) 
  in this Board according to Ship's variable length. Calls getIsOccupiedArea()
  on every Square in this Board. Returns boolean.  */

  public boolean checkIfCanSetShip(Ship ship) {
    int x = ship.getXCord();
    int y = ship.getYCord();
    boolean canSetShip = true;

    for (int i = 0; i < ship.getLength(); i++) {
        try { 
          if(this.getSquare(y, x).getIsOccupiedArea()) { return false; }
          if (ship.getIsVertical()) { y++; }
          else { x++; }  
        } catch (ArrayIndexOutOfBoundsException ex) { return false; }
      }
    
    return canSetShip;
  } 

/* Method that takes coordinates using chooseCoords() as chars and convert it to int. Calls checkCoords().
   While boolean coordsAreProper is not true, checks if coordinates are present in this Board.
   If not, calls a wrongCoordsMassage1() and takes new coordinates.
   If coordinates are present, it converts letters & numbers to int using ASCII code.
   Calls checkCoords() to check whether coordinates are proper.
   Returns proper coordinates int[]. */
  
  public int[] coordinatesManager() {
    boolean coordsAreProper = false;
    int[] coords = new int[3];
    int LETTER = 0;
    int NUMBER = 1;
    int ASCIIA = 97;
    int ASCII1 = 49;
    
    do {      
      char[] coordinates = dis.chooseCoords();      
      if (checkIfCoordsInBoard(coordinates)) { 
        coords[LETTER] = (int)coordinates[LETTER] - ASCIIA;
        if (coordinates.length < 3) { 
          coords[NUMBER] = (int)coordinates[NUMBER] - ASCII1;
        } else { coords[NUMBER] = 9; 
        }
        coordsAreProper = checkCoords(coords[LETTER], coords[NUMBER]);
        if (coordsAreProper != true) { coordinates = dis.chooseCoords(); }
      }
      else { 
        dis.wrongCoordsMassage1(); 
      }
    } while (coordsAreProper != true);

    return coords;
  }

  /* Method that checks if coordinates are present in this Board, using lists of letters and numbers. 
  Returns boolean. */

  public boolean checkIfCoordsInBoard(char[] coordinates) {
    String letters = "abcdefghij";
    String numbers = "123456789";
    boolean coordsInBoard = false;
    int LETTER = 0;
    int NUMBER = 1;

    if (coordinates.length > 3 || coordinates.length < 2) { 
      return coordsInBoard; 
    } else if (letters.indexOf(coordinates[LETTER]) < 0) { 
      return coordsInBoard; 
    } else if (numbers.indexOf(coordinates[NUMBER]) < 0) { 
      return coordsInBoard; 
    } else if (coordinates.length == 3) {
      if (coordinates[1] == '1' && coordinates[2] == '0') {
      } else { return coordsInBoard; }
    }
    
    coordsInBoard = true; 
    

    return coordsInBoard;
  }

  /* Method that assigns ship to coordinates in loop for every Square in it's length,
  checking is it vertical or not to set ship in proper place.
  */

  public void setShipOnSquares(Ship ship) {
    int x = ship.getYCord();
    int y = ship.getXCord();
    occupyAreaAroundShips(ship);        

    for (int i = 0; i < ship.getLength(); i++) {
      getSquare(x, y).setIsShip(true);
        if (ship.getIsVertical()) { x++; }
        else { y++; }
    }
  }

  /* Calls setIsOccupiedArea setting is at true for every Square around specific ship
  Checks isVertical and according to it starts a proper loop. For each x & y coordinates it gets specific Square building this ship and tries to setIsOccupiedArea to true.
  After every width loop it sets length coordinate(x/y) back to the start value.  */

  public void occupyAreaAroundShips(Ship ship) {
    int x = ship.getXCord()-1;
    int y = ship.getYCord()-1;

    int occupationLength = ship.getLength() + 2;
    int occupationWidth = 3;
    boolean isVertical = ship.getIsVertical();

    if (isVertical) {occupationWidth += x; }
    else { occupationWidth += y; }
      if (isVertical == true) { 
        for (;x < occupationWidth; x++) {
          for (int i = 0; i < occupationLength; i++) {
            try { this.getSquare(y, x).setIsOccupiedArea(true);  
            } catch (ArrayIndexOutOfBoundsException ex) {}
            y ++;
          }
          y = ship.getYCord()-1;
        }
      }
      else {
        for (;y < occupationWidth; y++) {
          for (int i = 0; i < occupationLength; i++) {
            try { this.getSquare(y, x).setIsOccupiedArea(true);  
            } catch (ArrayIndexOutOfBoundsException ex) {}
            x ++;
          }
          x = ship.getXCord()-1;
      }
    } 
  }

  /* It sets boolean for this Board as true, informing, that ships in this Board are already created */

  public void setShipsAsCreated() {
    this.shipsAreCreated = true;
  }

  /* Assigns specific sign for specific Square in this Board according to it's fields. 
    Returns char. */

    public char assignCharInPosition(int x, int y) {
      Square sqr = this.getSquare(x, y);
      if (sqr.getCanShoot()) {
        if (sqr.getIsShip() && this.getIsHidden() == false) {
          return 'X';
        } else if (sqr.getIsOccupiedArea() == true) {
          return '#';
        } else {
          return '~';
        }
      } else {
        return 'O';
      }
    }
}