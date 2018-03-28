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

  public Ship createShip(String name) {
    System.out.println("Creating ship " + name);
    int[] cords = input.getCord();
    int cordX = cords[0];
    int cordY = cords[1];
    boolean isVertical;
    System.out.println("Vertical or horizontal? 0/1");
    int vertical = input.getInt();

    if (vertical == 0) {
      isVertical = true;
    } else isVertical = false;
    Ship newShip = new Ship(cordX, cordY, isVertical, length);

    return newShip;
  }
}
