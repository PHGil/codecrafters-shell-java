package command;

public class CD implements Command {
    @Override
    public String execute(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        if (args.length > 1) {
            return "cd: too many arguments";
        }
        String targetDir = args.length == 0
                ? System.getProperty("user.home")
                : args[0];
        System.out.println(targetDir);
        if (args.length == 1 && !Utils.isDirectoryPresent(targetDir)) {
            return "cd: " + targetDir + ": No such file or directory";
        }
        System.setProperty("user.dir", targetDir);
        System.out.println(System.getProperty("user.dir"));
        System.out.println(targetDir);
        return "";
    }
}
