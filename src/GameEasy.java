import java.util.ArrayList;

public class GameEasy {
  static Player player1 = new Player();
  static EasyAI player2 = new EasyAI();
  static Board board1 = new Board();
  static Board board2 = new Board();
  static Display disp = new Display();
  static boolean is_game = true;
  static ArrayList<Player> players = new ArrayList<Player>();
  static ArrayList<Board> boards = new ArrayList<Board>();
  Ship ship = new Ship();

  public GameEasy() {
    players.add(player1);
    players.add(player2);
    boards.add(board1);
    boards.add(board2);
  }

  public void handleGame() {
    prepareGame();
    do {
      handleRound();
    } while (is_game);
  }

  public void handleRound() {
    player1.tryShoot(board2);
    int[] cords = player2.easyAIShot();
    player2.tryShoot(board1, cords[0], cords[1]);
  }

  public void prepareGame() {
    disp.print("1player");
    ship.createShips(board1);

    ship.createShips(board2);
    disp.print("2player");
  }

  public boolean checkGameStatus() {
    return true;
  }
}
