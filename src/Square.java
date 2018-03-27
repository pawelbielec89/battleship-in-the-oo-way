public class Square {
  public boolean isOccupiedArea = false;
  public boolean canShoot = true;
  public boolean isShip = false;

  public Square() {}

  public void changeIsShipToTrue() {
    isShip = true;
  }

  public void changeCanShootToFalse() {
    canShoot = false;
  }

  public void changeIsOccupiedAreaToTrue() {
    isOccupiedArea = true;
  }

  public void getFields() {}
}
