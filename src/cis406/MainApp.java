/*
 * MainApp.java
 */
package cis406;

import cis406.security.SessionThread;
import cis406.security.Settings;
import cis406.security.UserLoginBox;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class MainApp extends SingleFrameApplication {
    /**
     * Returns an integer, 0 for admin, 1 for coordinator, 2 for assistant
     */
    public static String[] loginResult = new String[3];
    public static Settings settings = new Settings();
    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        loginResult = UserLoginBox.login();
        if (Boolean.parseBoolean(loginResult[0])) {
            show(new MainView(this, loginResult[1], Integer.parseInt(loginResult[2])));
            Thread sessionThread = new Thread(new SessionThread(), "thread1");
            sessionThread.start();
        } else {
            System.exit(0);
        }

    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of MainApp
     */
    public static MainApp getApplication() {
        return Application.getInstance(MainApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(MainApp.class, args);
    }
}
