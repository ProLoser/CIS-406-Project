/*
 * MainApp.java
 */
package cis406;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class MainApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        boolean successfulLogin = false;
        String[] loginInformation = new String[2];

        do{
            loginInformation = UserLoginBox.getUserInformation();
            if (User.tryLogon(loginInformation[0], loginInformation[1])){
                successfulLogin = true;
            }
        }
        while (successfulLogin == false);

        show(new MainView(this, 1, 1));

	Thread sessionThread = new Thread(new SessionThread(), "thread1");
        sessionThread.start();
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
