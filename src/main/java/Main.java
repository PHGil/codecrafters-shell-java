import java.util.Scanner;

void main() throws Exception {
    System.out.print("$ ");
    Scanner scanner = new Scanner(System.in);
    String command = scanner.nextLine();
    System.out.println(command + ": command not found" );
}
