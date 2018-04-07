import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Display {


  public void print(String text) {
    System.out.println(text);
  }


  public String chooseShip() {
    Inputs input = new Inputs();    
    List<String> ships = new ArrayList<>(Arrays.asList("Destroyer", "Submarine", "Cruiser", "Battleship", "Cruiser"));    
    List<Integer> usedShips = new ArrayList<>();
    int index = 6;
    String shipName = "";

    while (index < 0 || index > 5) {
      print("Ships which you can choose: \n"
            + "1. Destroyer - 2 spaces long\n"
            + "2. Submarine - 3 spaces long\n"
            + "3. Cruiser - 3 spaces long\n"
            + "4. Battleship - 4 spaces long\n"
            + "5. Carrier - 5 spaces long\n"
            + "Choose number of ship you want to put on now");
      index = input.getInt();
      usedShips.add(index);

      if (index < 0 || index > 5) { print("There is no such an option!"); }  
      else if (usedShips.contains(index)) { print("You've already placed this ship!"); }
      else { index--; shipName = ships.get(index); }    
    }
    
    return shipName;
    
  }

  public boolean chooseIsVertical(){
    Inputs input = new Inputs();    
    int position = 0;
    boolean isVertical = false; 
    while (position != 1 && position != 2) {
    print("Do you want to place this ship vertical or horizontal?\n"
    + "1. Vertical\n" + "2. Horizontal");
    position = input.getInt();
    if (position == 1) { isVertical = true; }
    else if (position == 2) { isVertical = false; }
    else { print("There is no such an option!"); }
    }
    return isVertical;
  }


  public int[] chooseCords() {
    Inputs input = new Inputs();    
    int[] cords = new int[2];
    print("Enter coordinates: ");
    String cord = input.getInput();
    char[] cordsAsChars = cord.toCharArray();      
    cords[0] = (int)cordsAsChars[0] - 97;
    cords[1] = (int)cordsAsChars[1] - 49;

    return cords;
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
    //char[][] charBoard = new char[10][10];

 //   public
    

 }


