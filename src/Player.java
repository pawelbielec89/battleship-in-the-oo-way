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

  public void tryShoot(Board board) {
    int[] cords = board.coordinatesManager();
    int cordX = cords[0];
    int cordY = cords[1];
    Square sqr = board.getSquare(cordX, cordY);

    if (sqr.getCanShoot()) {
      sqr.setCanShoot(false);
      System.out.println("Shoot!");
      if (sqr.getIsShip()) {
        System.out.println("Hit");
      } else {
        System.out.println("Miss");
      }
    } else {
      System.out.println("Not allowed!");
    }
  }

  public void tryShoot(Board board, int cordX, int cordY) {
    board.getSquare(cordX, cordY).setCanShoot(false);
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
        if (checked == false) {
          System.out.println("False");
          break;
        }
      }
    }
  }
}
