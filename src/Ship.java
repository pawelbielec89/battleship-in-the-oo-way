public class Ship {
    int x;
    int y;
    boolean isVertical;
    int lives;
    boolean isAlive;


    public Ship(int x, int y, boolean isVertical, int lives){
        this.x = x;
        this.y = y;
        this.isVertical = isVertical;
        this.lives = lives;
        this.isAlive = true;
    }

    public setAlive(boolean alive){
        ship.isAlive = alive;
    }

}