void main() throws Exception {
    Scanner scanner = new Scanner(System.in);
    final String echoInput = "echo ";
    while (true) {
        System.out.print("$ ");
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            break;
        }
        if (input.startsWith(echoInput)) {
            System.out.println(input.substring(echoInput.length()));
        }
        System.out.println(input + ": input not found");
    }
}
