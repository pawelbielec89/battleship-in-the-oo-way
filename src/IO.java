import java.util.Scanner;

public class IO {

  public IO() {}

  public int getCord(char symbol) {
    System.out.println("Enter " + symbol + " cord: ");
    Scanner scanner = new Scanner(System.in);

    int cord = scanner.nextInt() - 1;
    return cord;
  }
}
