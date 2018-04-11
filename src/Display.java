import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Display {

  private List<String> usedShips = new ArrayList<>();

  public void print(String text) {
    System.out.println(text);
  }

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
        if (usedShips.contains(shipName)) {
          print("You've already placed this ship!\n");
        } else {
          usedShips.add(shipName);
          shipChosen = true;
        }
      }
    }
    return shipName;
  }

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

  public char[] chooseCoords() {
    print("Enter coordinates: ");
    Inputs input = new Inputs();
    String coord = input.getInput();
    char[] coordsAsChars = coord.toCharArray();
    coordsAsChars[0] = Character.toLowerCase(coordsAsChars[0]);

    return coordsAsChars;
  }

  public void wrongCoordsMassage1() {
    print(
        "Wrong coordinates!\n"
            + "You should enter a letter between a-j and a number between 1-9, like a4 :)\n");
  }

  public void wrongCoordsMassage2() {
    print(
        "Wrong coordinates!\n"
            + "Remember that you can't put your ship on area occupied by another one.");
  }

  public void wrongCoordsMassage3() {
    print("You've already shooted in this place!");
  }

  public void wrongCoordsMassage4(String shipName) {
    usedShips.remove(shipName);
    print("You can't set ship on occupied area! Try again.");
  }

  public char assignCharInPosition(Board board, int x, int y) {
    Square sqr = board.getSquare(x, y);
    // roboczo nazwane, nie wiem jak się dostać do tej funkcji w konkretnym obiekcie
    if (sqr.getCanShoot()) {
      if (sqr.getIsShip() && board.getIsHidden() == false) {
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

  char[][] charBoard = new char[10][10];

  public void displayBoards(Board board1, Board board2) {
    String letters = "   A  B  C  D  E  F  G  H  I  J ";
    String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    char sign;

    print("            P L A Y E R 1                  P L A Y E R 2 ");
    print(letters + letters);

    for (int i = 0; i < 10; i++) {
      if (i == 0) {}

      if (i != 9) {
        System.out.print(numbers[i] + " ");
      } else {
        System.out.print(numbers[i] + "");
      }

      for (int j = 0; j < 20; j++) {
        if (j == 10) {
          if (i != 9) {
            System.out.print(numbers[i] + " ");
          } else {
            System.out.print(numbers[i] + "");
          }
        }

        if (j < 10) {
          sign = assignCharInPosition(board1, i, j);
        } else {
          sign = assignCharInPosition(board2, i, j - 10);
        }

        System.out.print(" " + sign + " ");
      }

      print("");
    }
  }

  //  public void displaySingleBoard(Board board) {}

}
