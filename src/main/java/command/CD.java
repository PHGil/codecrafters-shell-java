package command;

public class CD implements Command {
    @Override
    public String execute(String[] args) {
        if (args.length == 0) {
            System.setProperty("user.dir", System.getProperty("user.home"));
            return "";
        } else if (args.length == 1) {
            String newPath = Utils.extractPathFromCommand(args[0]);
            if (newPath != null) {
                System.setProperty("user.dir", newPath);
                return "";
            } else {
                return "cd: " + args[0] + ": No such file or directory";
            }
        } else {
            return "cd: too many arguments";
        }
    }
}
