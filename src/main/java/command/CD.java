package command;

public class CD implements Command {
    private static final String USER_DIR = "user.dir";
    private static final String HOME = "~";
    private static final String HOME_DIR = System.getProperty("user.home");

    @Override
    public String execute(String[] args) {
        if (args.length > 1) {
            return "cd: too many arguments";
        }
        if (args.length == 0 || this.isHomeDirectory(args[0])) {
            System.setProperty(USER_DIR, HOME_DIR);
        }
        String targetDir = args[0];
        if (!Utils.isDirectoryPresent(targetDir)) {
            return "cd: " + targetDir + ": No such file or directory";
        }
        if (this.isCurrentDirectory(targetDir)) {
            targetDir = System.getProperty(USER_DIR) + "/" + targetDir;
        }
        if (this.isParentDirectory(targetDir)) {
            targetDir = this.handleParentDirectory(targetDir);
        }
        System.setProperty(USER_DIR, targetDir);
        return "";
    }

    private String handleParentDirectory(final String path) {
        String currentDir = System.getProperty(USER_DIR);
        String parentDir = currentDir.substring(0, currentDir.lastIndexOf('/'));
        return parentDir + path.substring(2);
    }

    private boolean isCurrentDirectory(final String path) {
        return path.startsWith("./") || !path.matches("^[^/]*");
    }

    private boolean isHomeDirectory(final String path) {
        return path.startsWith(HOME);
    }

    private boolean isParentDirectory(final String path) {
        return path.startsWith("../");
    }
}
