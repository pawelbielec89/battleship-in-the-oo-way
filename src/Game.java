import java.util.ArrayList;

public class Game {
  static Player player1 = new Player();
  static Player player2 = new Player();
  private Board board1 = new Board();
  private Board board2 = new Board();
  static Display disp = new Display();
  static boolean is_game = true;
  static ArrayList<Player> players = new ArrayList<Player>();
  static ArrayList<Board> boards = new ArrayList<Board>();

  public Game() {
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
    for (int i = 0; i < 2; i++) {
      int current_player_index = (i + 1) / 2;
      int opposite_player_index = (i + 1) % 2;
      Player current_player = players.get(current_player_index);
      Player opposite_player = players.get(opposite_player_index);
      Board current_board = boards.get(current_player_index);
      Board opposite_board = boards.get(opposite_player_index);
      System.out.println("Player " + current_player_index);
      disp.displayBoards(board1, board2);
      current_player.tryShoot(opposite_board);
      is_game = checkGameStatus();
      if (!is_game) break;
    }
  }
  
  public void prepareGame() {
    new Ship().createShips(board1);
    disp.print("1player");

    new Ship().createShips(board2);
    disp.print("2player");
  }

  public boolean checkGameStatus() {

    return true;
  }
}
