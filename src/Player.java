public class Player { 
    String name;
    int score;

    public Player(String name) {
        this.name = name;
        this.score = 117;
    }

    public void shoot(int x, int y){
        if (canShoot == true) {
            Square[x][y].canShoot = false;
            if (Square[x][y].isShip == true) {
                
            }
        } 
    }
}