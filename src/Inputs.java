import java.util.Scanner;

public class Inputs {
  Scanner scanner = new Scanner(System.in);

  public Inputs() {}

<<<<<<< HEAD
  public String getInput() {
    String input = scanner.nextLine();
    return input;
=======
  public int[] getCord() {
    System.out.println("Enter coordinates: ");

    String cord = scanner.nextLine();
    char[] cordsAsChars = cord.toCharArray();
    int cord1 = (int) cordsAsChars[0] - 96;
    int cord2 = (int) cordsAsChars[1] - 48;
    int cords[] = {cord1, cord2};

    return cords;
>>>>>>> 8d9b4816dfb49979c7f8e9b77aec16a2108cf87d
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
