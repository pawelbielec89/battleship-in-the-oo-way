import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Display {

  public static void print(String text) {
    System.out.println(text);
  }

  public String chooseShip() {
    List<String> ships =
        new ArrayList<>(
            Arrays.asList("Destroyer", "Submarine", "Cruiser", "Battleship", "Cruiser"));
    String shipName = "";
    int shipsLeft = ships.size();

    while (shipsLeft > 0) {

      print(
          "Ships which you can choose: \n"
              + "1. Destroyer - 2 spaces long\n"
              + "2. Submarine - 3 spaces long\n"
              + "3. Cruiser - 3 spaces long\n"
              + "4. Battleship - 4 spaces long\n"
              + "5. Carrier - 5 spaces long\n"
              + "Choose number of ship you want to put on now");

      int input = new Inputs().getInt();

      if (input > 0 && input < 6) {
        int index = input - 1;
        print(ships.get(index));
        shipName = ships.get(index);
        shipsLeft -= 1;

      } else {
        print("Wrong number!");
      }
    }

    return shipName;
  }

  public char generateChar(Board board, int x, int y) {
    Square sqr = board.getSquare(x, y);
    // roboczo nazwane, nie wiem jak się dostać do tej funkcji w konkretnym obiekcie
    if (sqr.getCanShoot()) {
      if (sqr.getIsShip() && board.getIsHidden() == false) {
        return 'X';
      } else {
        return '~';
      }
    } else {
      return 'O';
    }
  }

  char[][] charBoard = new char[10][10];

  //   public

  public void displayBoard(Board board1, Board board2) {
    String letters = "   A  B  C  D  E  F  G  H  I  J ";
    String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    char sign;

    for (int i = 0; i < 10; i++) {
      if (i == 0) {
        print("            P L A Y E R 1                  P L A Y E R 2 ");
        print(letters + letters);
      }
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
          sign = generateChar(board1, i, j);
        } else {
          sign = generateChar(board2, i, j - 10);
        }

        System.out.print(" " + sign + " ");
      }

      print("");
    }
  }
  // char[][] charBoard = new char[10][10];

  //   public

}
