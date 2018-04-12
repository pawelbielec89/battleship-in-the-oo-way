import java.util.ArrayList;

public class GameHard {
  static Player player1 = new Player();
  static HardAI player2 = new HardAI();
  private Board board1 = new Board();
  private Board board2 = new Board();
  static Display disp = new Display();
  static boolean is_game = true;
  static ArrayList<Player> players = new ArrayList<Player>();
  static ArrayList<Board> boards = new ArrayList<Board>();

  public GameHard() {
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

    System.out.println("Player ");
    disp.displayBoards(board1, board2);
    player1.tryShoot(board1);
    player2.tryShoot(board2);
    is_game = checkGameStatus();
  }

  public void prepareGame() {
    disp.print("1player");
    new Ship().createShips(board1);

    new Ship().createShips(board2);
    disp.print("2player");
  }

  public boolean checkGameStatus() {
    boolean is_game = false;
    boolean board1Lives = false;
    boolean board2Lives = false;
    for (int i = 0; i < 5; i++) {
      if (board1.listOfShips[i].getIsAlive()) {
        board1Lives = true;
      }
      if (board2.listOfShips[i].getIsAlive()) {
        board2Lives = true;
      }
    }
    if (board1Lives && board2Lives) {
      is_game = true;
    }
    return is_game;
  }
}
