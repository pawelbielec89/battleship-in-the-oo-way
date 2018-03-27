public class Display{
    public void print(String text) { System.out.println(text); }

    public char generateChar(Board board, int x, int y){
        Square sqr = board.getSquare(x,y);//roboczo nazwane, nie wiem jak się dostać do tej funkcji w konkretnym obiekcie
        if (sqr.getCanShoot() ){
            if (sqr.getIsShip() && board.getIsHidden() == false) { 
                return 'X';
            }
            else { return '~'; }
        }
        else { return 'O'; }
    }

    char[][] charBoard = new char[10][10];

 //   public

    public void displayBoard(Board board1, Board board2){
        String letters = "   A  B  C  D  E  F  G  H  I  J ";
        String[] numbers = {"1","2","3","4","5","6","7","8","9","10"};   
        char sign;   

        for(int i = 0; i < 10; i++) {
            if (i == 0) {
                print(letters + letters);
            }
            if (i != 9) { print(numbers[i] + " ");  }
            else { print(numbers[i] + ""); }                            
            
            for (int j = 0; j < 20; j ++) {
                if (j == 10) {     
                    if (i != 9) { System.out.print(numbers[i] + " ");  }
                    else { System.out.print(numbers[i] + ""); } 
                }

                if (j < 10) { 
                    sign = generateChar(board1, i,j); }
                else { 
                    sign = generateChar(board2, i,j-10);;                                  
                }

                System.out.print(" " + sign + " ");
            }

            print("");
        }
    }

    //public 
}