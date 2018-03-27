public class Player {
  String name;
  int score;
  Inputs input = new Inputs();

  public Player(String name) {
    this.name = name;
    this.score = 117;
  }

  public void tryShoot(Board board) {
    int cordX = input.getCord('x');
    int cordY = input.getCord('y');
    Square sqr = board.getSquare(cordX, cordY);

    if (sqr.getCanShoot()) {
      sqr.setCanShoot(false);
      System.out.println("Shooted!");
    } else {
      System.out.println("Not allowed!");
      // Wywołać wypisanie prośby o nowe koordynanty!!!!!
    }
  }

  public void tryShoot(Board board, int cordX, int cordY) {
    Square sqr = board.getSquare(cordX, cordY);
    sqr.setCanShoot(false);
  }
}
