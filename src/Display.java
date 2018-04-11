import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Display {

  private List<String> usedShips = new ArrayList<>();
  private Player player = new Player();
  private String letters = "   A  B  C  D  E  F  G  H  I  J ";
  private String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

  /* Prints String. Shorter version than System.out.println() for clean code */

  public void print(String text) {
    System.out.println(text);
  }

  /* Displays possibilities of ships to choose in while loop. Takes player's input and converts it to index of ships arraylist.
  It displays proper massage if player choose wrong option. It calls checkIsShipProperlyChosen which ends while if it returns true.
  Returns shipName as String. */

  public String chooseShip() {
    List<String> ships =
        new ArrayList<>(
            Arrays.asList("Destroyer", "Submarine", "Cruiser", "Battleship", "Carrier"));
    int index;
    boolean shipChosen = false;
    String shipName = "";

    while (shipChosen == false) {
      print(
          "Ships which you can choose: \n"
              + "1. Destroyer - 2 spaces long\n"
              + "2. Submarine - 3 spaces long\n"
              + "3. Cruiser - 3 spaces long\n"
              + "4. Battleship - 4 spaces long\n"
              + "5. Carrier - 5 spaces long\n"
              + "Choose number of ship you want to put on now");
      Inputs input = new Inputs();
      index = input.getInt() - 1;

      if (index < 0 || index > 4) {
        print("There is no such an option!");
      } else {
        shipName = ships.get(index);
        shipChosen = checkIsShipProperlyChosen(shipName);
      }
    }
    return shipName;
  }

  /* Checks whether usedShips array contains already chosen shipName.
  If it does, prints a proper massage. Returns boolean. */

  public boolean checkIsShipProperlyChosen(String shipName) {
    if (usedShips.contains(shipName)) {
      print("You've already placed this ship!\n");
      return false;
    } else {
      usedShips.add(shipName);
      return true;
    }
  }

  /* Displays question and takes player's input, repeating it until it gets a proper input.
  Every time it gets wrong input it displays massage about it.
  Returns boolean. */

  public boolean chooseIsVertical() {
    int position = 0;
    boolean isVertical = false;
    while (position != 1 && position != 2) {
      Inputs input = new Inputs();
      print(
          "Do you want to place this ship vertical or horizontal?\n"
              + "1. Vertical\n"
              + "2. Horizontal");
      position = input.getInt();
      if (position == 1) {
        isVertical = true;
      } else if (position != 2) {
        print("There is no such an option!");
      }
    }
    return isVertical;
  }

  /* Displays massage and takes player's input. Converts to char array.
  Returns coordinates as chars, with already changed first letter to lowercase. */

  public char[] chooseCoords() {
    print("Enter coordinates: ");
    Inputs input = new Inputs();
    String coord = input.getInput();
    char[] coordsAsChars = coord.toCharArray();
    coordsAsChars[0] = Character.toLowerCase(coordsAsChars[0]);

    return coordsAsChars;
  }

  /* Displays massage that helps player to understand what he actually did wrong sending input. */

  public void wrongCoordsMassage1() {
    print(
        "Wrong coordinates!\n"
            + "You should enter a letter between a-j and a number between 1 and 10, like a4 :)\n");
  }

  /* Displays massage that helps player to understand what he actually did wrong sending input. */

  public void wrongCoordsMassage2() {
    print(
        "Wrong coordinates!\n"
            + "Remember that you can't put your ship on area occupied by another one.");
  }

  /* Displays massage that helps player to understand what he actually did wrong sending input. */

  public void wrongCoordsMassage3() {
    print("You've already shooted in this place!");
  }

  /* Displays massage that helps player to understand what he actually did wrong sending input. */

  public void wrongCoordsMassage4(String shipName) {
    usedShips.remove(shipName);
    print("You can't set ship on occupied area! Try again.");
  }

  public void displayBoards(Board board1, Board board2) {
    print("            P L A Y E R 1                  P L A Y E R 2 ");
    print(letters + letters);

    for (int x = 0; x < 10; x++) {
      if (x != 9) {
        System.out.print(numbers[x] + " ");
      } else {
        System.out.print(numbers[x] + "");
      }
      displayTwoBoards(board1, board2, x);
    }
  }

  public void displayTwoBoards(Board board1, Board board2, int x) {
    char sign;

    for (int y = 0; y < 20; y++) {

      if (y == 10) {
        if (x != 9) {
          System.out.print(numbers[x] + " ");
        } else {
          System.out.print(numbers[x] + "");
        }
      }

      if (y < 10) {
        sign = board1.assignCharInPosition(x, y);
      } else {
        sign = board2.assignCharInPosition(x, y - 10);
      }

      System.out.print(" " + sign + " ");
    }
    print("");
  }

  /* Displays Board as table by using for loop - for each repetition prints one line.
  First it print a number from numbers[]. At last repetition(i==9) it prints number without additional space.
  After displaying number it calls displaySingleBoard() to display Squares in this board as signs. */

  public void displayBoards(Board board, String name) {

    print("         " + name + "           ");
    print(letters);
    for (int x = 0; x < 10; x++) {
      if (x != 9) {
        System.out.print(numbers[x] + " ");
      } else {
        System.out.print(numbers[x] + "");
      }
      displaySingleBoard(board, x);
    }
  }

  /* Prints sign by sign in one line. Sign represents current state of Squares in this Board,  */

  public void displaySingleBoard(Board board, int x) {
    for (int y = 0; y < 10; y++) {
      char sign = board.assignCharInPosition(x, y);
      System.out.print(" " + sign + " ");
    }
    print("");
  }
}
