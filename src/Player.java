public class Player {
  String name;
  int score;

  public Player(String name) {
    this.name = name;
    Player();
  }

  public Player() {
    this.score = 117;
  }

  public void tryShoot(Board board, Ship ship) {
    int[] cords = ship.getCord();
    int cordX = cords[0];
    int cordY = cords[1];
    Square sqr = board.getSquare(cordX, cordY);

    if (sqr.getCanShoot()) {
      sqr.setCanShoot(false);
      System.out.println("Shooted!");
    } else {
      System.out.println("Not allowed!");
    }
  }

  public void tryShoot(Board board, int cordX, int cordY) {
    Square sqr = board.getSquare(cordX, cordY);
    sqr.setCanShoot(false);
  }

}
