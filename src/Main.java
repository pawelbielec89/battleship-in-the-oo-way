public class Main {

  public static void main(String[] args) {
    Square squar = new Square();
    Board board1 = new Board();
    Board board2 = new Board();
    Display dis = new Display();
    dis.displayBoard(board1, board2);
    Player gracz = new Player();
    //  Ship ship2 = gracz.createShip("c");

    //gracz.checkSquares(board1, 2, 2, false, 5);
    //gracz.checkSquares(board1, 0, 0, false, 5);


    dis.displayBoard(board1, board2);
    String shipName = dis.chooseShip();
    boolean isVertical = true;
    while (true) {
    int[] cords = Ship.getCord();
    Ship ship = new Ship(cords[0], cords[1], isVertical, shipName);
    ship.setShipOnSquares(ship, board1); 
    dis.displayBoard(board1, board2);
  }


    }
  
}
