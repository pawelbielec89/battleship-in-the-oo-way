import java.util.ArrayList;
import java.util.Scanner;

public class Game {
  static Player player1 = new Player();
  static Player player2 = new Player();
  private Board board1 = new Board();
  private Board board2 = new Board();
  static Display disp = new Display();
  static boolean is_game = true;
  static ArrayList<Player> players = new ArrayList<Player>();
  static ArrayList<Board> boards = new ArrayList<Board>();
  Scanner input = new Scanner(System.in);

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
      boards.get(current_player_index).setIsHidden(false);
      boards.get(opposite_player_index).setIsHidden(true);

      System.out.println("Player " + current_player_index);
      disp.displayBoards(board1, board2);
      current_player.tryShoot(opposite_board);
      is_game = checkGameStatus();
      try {
        Thread.sleep(1500);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }

      System.out.print("\033[H\033[2J");
      System.out.println("Press enter to change player!");
      String enter = input.nextLine();

      if (!is_game) {
        System.out.println("Player " + current_player_index + 1 + " won game!");

        break;
      }
    }
    disp.displayBoards(board1, board2);
  }

  public void prepareGame() {
    new Ship().createShips(board1);
    disp.print("1player");

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
