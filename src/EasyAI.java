public class EasyAI extends AI {

  public EasyAI(String name) {
    this.name = name;
    this.score = 117;
  }

  public int[] easyAiShot() {
    int[] shotCoords = {0, 0};
    int randomCoord = getRandomCoordFromList(allBoardCoords);
    //  if allBoardCoords.isEmpty()
    removeCoordsFromList(randomCoord);
    String stringCoords = Integer.toString(randomCoord);
    int xCoord;
    int yCoord;
    if (stringCoords.length() < 2) {
      xCoord = 0;
      yCoord = randomCoord;
    } else {
      char xCoordChar = stringCoords.charAt(0);
      char yCoordChar = stringCoords.charAt(1);
      xCoord = Character.getNumericValue(xCoordChar);
      yCoord = Character.getNumericValue(yCoordChar);
    }

    shotCoords[0] = xCoord;
    shotCoords[1] = yCoord;
    return shotCoords;
  }
}
