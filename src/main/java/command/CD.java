package command;

import java.nio.file.Paths;

public class CD implements Command {
    private static final String USER_DIR = "user.dir";
    private static final String HOME_DIR = System.getProperty("user.home");

    @Override
    public String execute(String[] args) {
        if (args.length > 1) {
            return "cd: too many arguments";
        }
        if (args.length == 0 || args[0].equals("~")) {
            System.out.println("Changing to home directory: " + HOME_DIR);
            System.setProperty(USER_DIR, HOME_DIR);
            return "";
        }
        String targetDir = args[0];
        if (this.isHomeDirectory(targetDir)) {
            targetDir = targetDir.replaceFirst("~", HOME_DIR);
        } else if (this.isRelativePath(targetDir)) {
            targetDir = System.getProperty(USER_DIR) + "/" + targetDir;
        }
        targetDir = Paths.get(targetDir).normalize().toString();
        if (!Utils.isDirectoryPresent(targetDir)) {
            return "cd: " + targetDir + ": No such file or directory";
        }

        System.setProperty(USER_DIR, targetDir);
        return "";
    }

    private boolean isRelativePath(final String path) {
        return !path.startsWith("/");
    }

    private boolean isHomeDirectory(final String path) {
        return path.startsWith("~");
    }
}
