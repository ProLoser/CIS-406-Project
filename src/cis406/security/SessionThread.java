package cis406.security;

import javax.swing.JOptionPane;

public class SessionThread implements Runnable {

	Thread runner;
	public SessionThread() {
	}
	public SessionThread(String threadName) {
            runner = new Thread(this, threadName);
            runner.start();
	}
	public void run() {
            try {
                while (true) {
                    if (Win32IdleTime.getIdleTimeMillisWin32() > cis406.MainApp.settings.getSession_timeout() * 60 * 1000) {
                        JOptionPane.showMessageDialog(null, "You have been automatically logged out due to inactivity!");
                        System.exit(0);
                    }
                    Thread.sleep(5 * 1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
	}
}