public class Game {
  public Game() {
    Player player1 = new Player();
    Player player2 = new Player();
    Board board1 = new Board();
    Board board2 = new Board();
    Display disp = new Display();
    boolean is_game = true;
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Board> boards = new ArrayList<Board>();
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
      current_player(tryShoot(opposite_board, disp));
      is_game = checkGameStatus();
      if (!is_game) break;
    }
  }

  public void prepareGame(boolean is_game) {
    disp.print("1player");
    Ship[] p1Ships = createShips();
    disp.print("2player");

    Ship[] p2Ships = createShips();
    for (int i = 0; i < 5; i++) {
      Ship.setShipOnSquares(p1Ships[i], board1);
      Ship.setShipOnSquares(p2Ships[i], board2);
    }
  }

  public boolean checkGameStatus() {
    if (players.get(0).health_points == 0 || players.get(1).health_points == 0) {
      return false;
    }
    return true;
  }
}
