package command;

public class CD implements Command {
    @Override
    public String execute(String[] args) {
        if (args.length > 1) {
            return "cd: too many arguments";
        }
        String targetDir = args.length == 0
                ? System.getProperty("user.home")
                : args[0];
        if (args.length == 1 && !Utils.isDirectoryPresent(targetDir)) {
            return "cd: " + targetDir + ": No such file or directory";
        }
        System.setProperty("user.dir", targetDir);
        return "";
    }
}
