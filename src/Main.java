public class Main {

  public static void main(String[] args) {
    Square squar = new Square();
    Board board1 = new Board();
    Board board2 = new Board();
    Display dis = new Display();
    dis.displayBoard(board1, board2);
    Player gracz = new Player();
    Ship ship1 = gracz.createShip("carrier");
    //  Ship ship2 = gracz.createShip("c");

    gracz.checkSquares(board1, 2, 2, false, 5);
    gracz.checkSquares(board1, 0, 0, false, 5);
    System.out.println(ship1.getXCord());
    System.out.println(ship1.getYCord());
    System.out.println(ship1.getIsVertical());
    System.out.println(ship1.getLength());
    System.out.println(ship1.getIsAlive());

    dis.displayBoard(board1, board2);
  }
}
