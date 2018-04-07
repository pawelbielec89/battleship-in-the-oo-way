public class Main {

  public static void main(String[] args) {
    Square squar = new Square();
    Board board1 = new Board();
    Board board2 = new Board();
    Display dis = new Display();
    dis.displayBoard(board1, board2);
    Player player1 = new Player();
    Player player2 = new Player();
    Inputs input = new Inputs();

    dis.print("1. New game");
    dis.print("2. Highscores");
    dis.print("3. Exit");
    int mainMenu = input.getInt();
    if (mainMenu == 1) {
      dis.print("Select game type:");
      dis.print("1. Player vs player");
      dis.print("2. Player vs computer");
      dis.print("3. Computer vs computer");
      int gameType = input.getInt();
      if (gameType == 1) {}

      if (gameType == 2) {}

      if (gameType == 3) {}
    }
    if (mainMenu == 2) {
      // Print Highscores
    }
    if (mainMenu == 3) {
      System.exit(0);
    }
  }
}
