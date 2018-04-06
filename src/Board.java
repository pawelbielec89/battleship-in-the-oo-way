public class Board {
  Square[][] gameBoard = new Square[10][10];
  private boolean isHidden;

  public Board() {
    isHidden = false; // isHidden = false - current player board, true - another player
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        gameBoard[i][j] = new Square();
      }
    }
  }

  public void printSquare(int x, int y) {
    Square sqr = getSquare(x, y);
    System.out.println(sqr.getIsShip());
    System.out.println(sqr.getCanShoot());
    System.out.println(sqr.getIsOccupiedArea());
  }

  public Square getSquare(int x, int y) {
    return gameBoard[x][y];
  }
  
  public void setIsHidden(boolean isHidden) {
    this.isHidden = isHidden;
  }

  public boolean getIsHidden() { return isHidden; }
}
