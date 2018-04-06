public class Main {

  public static void main(String[] args) {
    Square squar = new Square();
    Board board1 = new Board();
    Board board2 = new Board();
    Display dis = new Display();
    dis.displayBoard(board1, board2);
    String len = dis.chooseShip();
    Player player = new Player();
    //Ship ship = new Ship().createShip(len);

  }
}
