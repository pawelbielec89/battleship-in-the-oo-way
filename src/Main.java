import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static EasyAI easyAI2 = new EasyAI();
  static MedAI medAI2 = new MedAI();
  static HardAI hardAI2 = new HardAI();
  static EasyAI easyAI1 = new EasyAI();
  static MedAI medAI1 = new MedAI();
  static HardAI hardAI1 = new HardAI();
  static Board board1 = new Board();
  static Board board2 = new Board();
  static Display dis = new Display();
  static Player player1 = new Player();
  static Player player2 = new Player();
  static Inputs input = new Inputs();
  ArrayList<Ship> shipsP1 = new ArrayList<Ship>();
  ArrayList<Ship> shipsP2 = new ArrayList<Ship>();
  static Scanner scanner = new Scanner(System.in);
  static String[] ship_names = {"Destroyer", "Submarine", "Cruiser", "Battleship", "Carrier"};
  static GameEasy gameEasy = new GameEasy();
  static GameMed gameMed = new GameMed();
  static GameHard gameHard = new GameHard();

  public static void main(String[] args) {

    dis.print("Main menu");
    dis.print("1. New game");
    dis.print("2. Exit");
    int mainMenu = input.getInt();

    if (mainMenu == 1) {
      dis.print("Select game type:");
      dis.print("1. Player vs player");
      dis.print("2. Player vs computer");
      dis.print("3. Computer vs computer");
      int gameType = input.getInt();

      if (gameType == 1) {
        Game game = new Game(player1,player2);
        game.handleGame();
      }

      if (gameType == 2) {
        System.out.println("Select difficult: 1 - EASY\n 2 - MEDIUM\n 3 - HARD\n");
        int computerMode = input.getInt();
        Ship.aiMode = true;
        if (computerMode == 1) {
          gameEasy.handleGame();
        }
        if (computerMode == 2) {
          gameMed.handleGame();
        }
        if (computerMode == 3) {
          gameHard.handleGame();
        }
      }

      if (gameType == 3) {}
    }
    if (mainMenu == 2) {
      System.exit(0);
    }
  }

  /*  public static void pvpMode() {
    dis.print("Player1 set ships!");
    dis.displayBoard(board1, board2);

    for (int i = 0; i < 5; i++) {
      boolean isValid = false;
      System.out.println(
          "Enter coordinates for: "
              + ship_names[i]
              + " of length "
              + Ship.shipKinds.get(ship_names[i]));

      String cord = scanner.nextLine();
      char[] cordsAsChars = cord.toCharArray();
      int cord1 = (int) cordsAsChars[0] - 97;
      int cord2 = (int) cordsAsChars[1] - 49;
      if (cord1 + Ship.shipKinds.get(ship_names[i]) < 10)
        shipsP1.add(new Ship(cord2, cord1, false, ship_names[i]));
      System.out.println(shipsP1.get(i));
      shipsP1.get(i).setShipOnSquares(shipsP1.get(i), board1);
      dis.displayBoard(board1, board2);
    }
  }

  public static void wait(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException exj) {
      Thread.currentThread().interrupt();
    }
  }*/
}
