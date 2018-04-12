public class EasyAI extends AI {

  /*
  Get unique random coordinates from list, remove them from it and set canShoot
  of square with given coords to false
   * @param Board - board of AI enemy
   * @return none
  */
  public int[] easyAIShot() {
    int[] shotCoords = randomAiCoordsToShot(allBoardCoords);
    return shotCoords;
  }
}
