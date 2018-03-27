public class Square {
  private boolean isOccupiedArea;
  private boolean canShoot;
  private boolean isShip;

  public Square() {
    this.isOccupiedArea = false;
    this.canShoot = true;
    this.isShip = false;
  }

  public void setIsShip(boolean value) {
    isShip = value;
  }

  public void setCanShoot(boolean value) {
    canShoot = value;
  }

  public void setIsOccupiedArea(boolean value) {
    this.isOccupiedArea = value;
  }

  public boolean getIsOccupiedArea() {
    return isOccupiedArea;
  }

  public boolean getCanShoot() {
    return canShoot;
  }

  public boolean getIsShip() {
    return isShip;
  }
}
