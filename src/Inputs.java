import java.util.Scanner;

public class Inputs {
  Scanner scanner = new Scanner(System.in);

  public Inputs() {}

  public String getInput() {
    String input = scanner.nextLine();
    return input;
  }

  public int[] getCord() {
    System.out.println("Enter coordinates: ");

    String cord = scanner.nextLine();
    char[] cordsAsChars = cord.toCharArray();
    int cord1 = (int) cordsAsChars[0] - 97;
    int cord2 = (int) cordsAsChars[1] - 49;
    int cords[] = {cord1, cord2};

    return cords;
  }

  public int getInt() {
    int var = scanner.nextInt();
    return var;
  }

  public int getInt() {
    int var = scanner.nextInt();
    return var;
  }
}
