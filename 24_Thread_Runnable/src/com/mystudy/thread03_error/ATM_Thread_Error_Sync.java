package com.mystudy.thread03_error;

class ATM implements Runnable {
	int money;

	@Override
	public void run() {
		add(1000);
		bankSleep(1000);
		out(500);
		bankSleep(1000);
		out(300);
		bankSleep(1000);
		out(200);
	}
	// synchronized : 사용중에 다른 쓰레드가 사용하려고 할 때 대기상태가 됨
	synchronized void add(int money) {
		this.money += money;
		System.out.println(Thread.currentThread() + " - " +
				"입금: " + money + ", 잔액: " + this.money);
	}
	synchronized void out(int money) {
		this.money -= money;
		System.out.println(Thread.currentThread() + " - " +
				"출금: " + money + ", 잔액: " + this.money);
	}
	private void bankSleep(int milliseconds) {
		try {
			Thread.currentThread().sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


public class ATM_Thread_Error_Sync {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ----");
		ATM bank = new ATM();
		System.out.println("은행잔고 : " + bank.money);
		
		Thread th1 = new Thread(bank);
		Thread th2 = new Thread(bank);
		
		th1.start();
		th2.start();

		System.out.println("--- main() 끝 ----");
	}

}







