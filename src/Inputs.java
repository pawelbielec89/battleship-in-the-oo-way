import java.util.Scanner;

public class Inputs {
  Scanner scanner = new Scanner(System.in);

  public Inputs() {}

  public String getInput() {
    String input = scanner.nextLine();
    return input;
  }

  public int getInt() {
    int var = scanner.nextInt();
    return var;
  }
}
