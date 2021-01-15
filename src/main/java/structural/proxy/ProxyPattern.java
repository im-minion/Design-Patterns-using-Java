/*
 * Structural patterns provide different ways to create a class structure,
 * for example using inheritance and composition to create a large object from small objects.
 * */

package structural.proxy;

import java.io.IOException;

/*
 * Proxy pattern intent is to “Provide a surrogate or placeholder for another object to control access to it”.
 * Proxy pattern is used when we want to provide controlled access of a functionality.
 * */
public class ProxyPattern {
    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutorProxyImpl("test", "wrong_pwd");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand("rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }
    }
}

// interface which provides some functionality, in our case its runCommand
interface CommandExecutor {
    void runCommand(String cmd) throws Exception;
}

// main class implementation for internal use
class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void runCommand(String cmd) throws IOException {
        //some heavy implementation
        Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }
}

// client class where only privilaged user can run a command
class CommandExecutorProxyImpl implements CommandExecutor {
    private boolean isAdmin;
    private final CommandExecutor executor;

    public CommandExecutorProxyImpl(String user, String pwd) {
        if ("test".equals(user) && "correct_pwd".equals(pwd)) isAdmin = true;
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for non-admin users.");
            } else {
                executor.runCommand(cmd);
            }
        }
    }
}