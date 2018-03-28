public class Player {
  String name;
  int score;
  Inputs input = new Inputs();

  public Player(String name) {
    this.name = name;
    this.score = 117;
  }

  public Player() {
    this.score = 117;
  }

  public void tryShoot(Board board) {
    int[] cords = input.getCord();
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
