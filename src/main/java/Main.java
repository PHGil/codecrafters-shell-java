void main() throws Exception {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("$ ");
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            break;
        }
        if (input.startsWith("echo ")) {
            System.out.println(input);
        }
        System.out.println(input + ": input not found");
    }
}
