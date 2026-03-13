void main() throws Exception {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("$ ");
        String command = scanner.nextLine();
        if (command.equals("exit")) {
            break;
        }
        System.out.println(command + ": command not found");
    }
}
