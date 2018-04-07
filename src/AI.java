import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AI extends Player {
  List<Integer> allBoardCoords = new ArrayList<>();

  public AI() {
    for (int i = 0; i < 100; i++) {
      this.allBoardCoords.add(i);
    }
  }

  public int getRandomCoordFromList(List<Integer> array) {
    int randomCoordFromList = new Random().nextInt(array.size());
    return randomCoordFromList;
  }

  public void removeCoordsFromList(int randomCoord) {
    for (int i = 0; i < allBoardCoords.size(); i++) {
      if (randomCoord == allBoardCoords.get(i)) {
        allBoardCoords.remove(allBoardCoords.get(i));
      }
    }
  }
}
