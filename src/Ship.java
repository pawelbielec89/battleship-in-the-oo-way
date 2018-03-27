public class Ship {
    private int x;
    private int y;
    private boolean isVertical;
    private int length;
    private boolean isAlive = true;


    public Ship(int x, int y, boolean isVertical, int length){
        this.x = x;
        this.y = y;
        this.isVertical = isVertical;
        this.length = length;
    }

    public setAlive(boolean alive){
        ship.isAlive = alive;
    }

}