public class Player {
  String name;
  int score;

  public Player(String name) {
    this.name = name;
    this.score = 117;
  }

  public void tryShoot(Board board, int x, int y) {
    Square sqr = board.getSquare(x, y);

    if (sqr.getCanShoot()) {
      sqr.setCanShoot(false);
      System.out.println("Shooted!");
    } else {
      System.out.println("Not allowed!");
      // Wywołać wypisanie prośby o nowe koordynanty!!!!!
    }
  }
}
