import java.util.ArrayList;
import java.util.Random;

public class AI extends Player {
  public AI() {
    List<String> allBoardCoords = new ArrayList<>();
    for (i = 0; i < 100; i++) {
      allBoardCoords.add(i);
    }
  }

  public void easyAiShot(Board board) {
    int randomCoord = getRandomCoordsFromList(allBoardCoords);
    String stringCoords = Integer.toString(randomCoord);
    if (stringCoords.length() < 2) {
      int xCoord = 0;
      int yCoord = randomCoord;
    } else {

      char xCoordChar = text.charAt(0);
      char yCoordChar = text.charAt(1);
      int xCoord = Character.getNumericValue(xCoordChar);
      int xCoord = Character.getNumericValue(yCoordChar);
      System.out.println(xCoord);
    }
    System.out.println(xCoord);
    System.out.println(yCoord);
    Square squareToShot = getSquare(xCoord, yCoord);
    suqareToShot.setCanShoot(False);
    for (int i = 0; i < allBoardCoords.length; i++) {
      if (randomCoord == allBoardCoords[i]) {
        allBoardCoords.remove(allBoardCoords[i]);
      }
    }
  }

  private int getRandomCoordsFromList(ArrayList allBoardCoords) {
    Random rand = new Random();
    int randomCoord = allBoardCoords.get(rand.nextInt(allBoardCoords.size()));
    return randomCoord;
  }
}
