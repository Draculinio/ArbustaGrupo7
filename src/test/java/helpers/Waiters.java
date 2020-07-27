package helpers;

public class Waiters {
	public static void waitForTime(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void something() {System.out.println("something");}
}
