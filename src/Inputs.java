import java.util.Scanner;

public class Inputs {
  Scanner scanner = new Scanner(System.in);

  public Inputs() {}

  public int[] getCord() {
    System.out.println("Enter coordinates: ");

    String cord = scanner.nextLine();
    char[] cordsAsChars = cord.toCharArray();
    int cord1 = (int) cordsAsChars[0] - 96;
    int cord2 = (int) cordsAsChars[1] - 48;
    int cords[] = {cord1, cord2};

    return cords;
  }

  public String getName() {
    String name = scanner.nextLine();
    return name;
  }
}
