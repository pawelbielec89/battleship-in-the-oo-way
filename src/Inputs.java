import java.util.Scanner;

public class Inputs {
  Scanner scanner = new Scanner(System.in);

  public Inputs() {}

  public int getCord(char symbol) {
    System.out.println("Enter " + symbol + " cord: ");

    int cord = scanner.nextInt() - 1;
    return cord;
  }

  public String getName() {
    String name = scanner.nextLine();
    return name;
  }
}
