public class Board {
  public Board() {
    Square[][] gameBoard = new Square[10][10];
    for (int i = 0; i < gameBoard.length(); i++) {
      for (int j = 0; j < gameBoard[i].length(); j++) {
        gameBoard[i][j] = Square();
      }
    }
  }
}
