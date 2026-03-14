package command;

public interface Command {
    default void initArgs(String[] args) {
        if (args[1] != null && !args[1].isEmpty()) {
            args[1] = args[1].trim();
        }
    }

    String execute(String[] args);
}
