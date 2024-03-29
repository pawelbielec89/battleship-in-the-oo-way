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
    Square sqr = board.getSquare(cordY, cordX);

    if (sqr.getCanShoot()) {
      sqr.setCanShoot(false);
      System.out.println("Shoot!");
      if (sqr.getIsShip()) {
        System.out.println("Hit");
        checkWhichShipHitted(board, cordY, cordX);
      } else {
        System.out.println("Miss");
      }
    } else {
      System.out.println("Not allowed!");
      tryShoot(board);
    }
  }

  public void tryShoot(Board board, int cordX, int cordY) {
    board.getSquare(cordX, cordY).setCanShoot(false);
  }

  public void checkWhichShipHitted(Board board, int cordX, int cordY) {
    Ship[] list = board.listOfShips;
    for (int i = 0; i < 5; i++) {

      if (list[i].getIsShipOnPosition(cordX, cordY)) {
        list[i].looseLife(cordX, cordY);
      }
    }
  }
}
