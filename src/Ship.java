public class Ship {
  private int x;
  private int y;
  private boolean isVertical;
  private int length;
  private boolean isAlive = true;

  public Ship(int x, int y, boolean isVertical, int length) {
    this.x = x;
    this.y = y;
    this.isVertical = isVertical;
    this.length = length;
  }

  public void setAlive(boolean alive) {
    this.isAlive = alive;
  }

  public int getXCord() {
    return x;
  }

  public int getYCord() {
    return y;
  }

  public boolean getIsVertical() {
    return isVertical;
  }

  public int getLength() {
    return lenght;
  }

  public boolean getIsAlive() {
    return isAlive;
  }
}
