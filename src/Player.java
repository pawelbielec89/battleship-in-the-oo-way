public class Player {
  String name;
  int score;


  public Player() {
    this.score = 117;
  }

  public Player(String name) {
    this.name = name;
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

}
