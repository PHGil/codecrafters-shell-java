package command;

public enum CommandsEnum {
    EXIT("exit"),
    ECHO("echo"),
    TYPE("type"),
    PWD("pwd"),
    CD("cd");

    CommandsEnum(String command) {
    }

    public static boolean contains(String command) {
        for (CommandsEnum c : CommandsEnum.values()) {
            if (c.name().equalsIgnoreCase(command)) {
                return true;
            }
        }
        return false;
    }
}
