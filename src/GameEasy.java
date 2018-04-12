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
    player2.easyAIShot(board1);
  }

  public void prepareGame() {
    Ship[] p1Ships = new Ship().createShips(board1);
    disp.print("1player");

    Ship[] p2Ships = new Ship().createShips(board2);
    disp.print("2player");
  }

  public boolean checkGameStatus() {
    return true;
  }
}
