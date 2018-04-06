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

  public boolean checkSquare(Board board, int x, int y) {
    Square sqr = board.getSquare(x, y);
    if (sqr.getIsShip() == false && sqr.getIsOccupiedArea() == false) {
      System.out.println("True");
      return true;

    } else {
      System.out.println("False");
      return false;
    }
  }

  public void checkSquares(Board board, int x, int y, boolean isVertical, int len) {
    if (isVertical == false) {
      for (int i = 0; i < len; i++) {
        boolean checked = checkSquare(board, x + i, y);
        if (checked = false) {
          System.out.println("False");
          break;
        }
      }
    }
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
    Ship newShip = new Ship(cordX, cordY, isVertical, 1);
    System.out.println("Ship created!");

    return newShip;
  }
}
