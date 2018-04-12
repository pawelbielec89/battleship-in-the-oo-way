import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {
  Scanner scanner = new Scanner(System.in);

  public Inputs() {}

  public String getInput() {
    String input = scanner.nextLine();
    return input;
  }

  public int getInt() {
    boolean validInput = false;
    int value = 0;
    while (validInput != true) {
      try {
        value = scanner.nextInt();
        validInput = true;
      } catch (InputMismatchException ex) {
        System.out.println("It's not a number, try again");
        scanner.nextLine();
      }
    }
    return value;
  }
}
