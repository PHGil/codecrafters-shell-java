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
        if (args.length == 0) {
            System.setProperty(USER_DIR, HOME_DIR);
            return "";  // Must return here to avoid ArrayIndexOutOfBoundsException
        }

        String targetDir = args[0];

        // Handle ~ (home directory)
        if (this.isHomeDirectory(targetDir)) {
            targetDir = targetDir.replaceFirst("~", HOME_DIR);
        }
        // Handle .. (parent directory)
        else if (this.isParentDirectory(targetDir)) {
            targetDir = this.handleParentDirectory(targetDir);
        }
        // Handle relative paths (don't start with /)
        else if (this.isRelativePath(targetDir)) {
            targetDir = System.getProperty(USER_DIR) + "/" + targetDir;
        }
        // Absolute paths (start with /) - no modification needed

        if (!Utils.isDirectoryPresent(targetDir)) {
            return "cd: " + targetDir + ": No such file or directory";
        }

        System.setProperty(USER_DIR, targetDir);
        return "";
    }

    private String handleParentDirectory(final String path) {
        String currentDir = System.getProperty(USER_DIR);
        String parentDir = currentDir.substring(0, currentDir.lastIndexOf('/'));
        return parentDir + path.substring(2);
    }

    private boolean isRelativePath(final String path) {
        return !path.startsWith("/");  // Simple and correct
    }

    private boolean isHomeDirectory(final String path) {
        return path.startsWith(HOME);
    }

    private boolean isParentDirectory(final String path) {
        return path.startsWith("..");
    }
}
