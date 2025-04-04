package com.mystudy.thread03_error;

class ATM_Error implements Runnable {
	int money;

	@Override
	public void run() {
		add(1000);
		bankSleep(500);
		out(500);
		bankSleep(500);
		out(500);
		
	}
	private void bankSleep(int milliseconds) {
		try {
			Thread.currentThread().sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void add(int money) {
		this.money += money;
		System.out.println(Thread.currentThread() + " - " +
				"입금: " + money + ", 잔액: " + this.money);
	}
	private void out(int money) {
		this.money -= money;
		System.out.println(Thread.currentThread() + " - " +
				"출금: " + money + ", 잔액: " + this.money);
	}
	
}


public class ATM_Thread_Error {

	public static void main(String[] args) {
		System.out.println("[main 시작]");
		ATM_Error bank = new ATM_Error();
		System.out.println("은행 잔고 : " + bank.money);

		
		Thread th1 = new Thread(bank);
		th1.start();
		
		Thread th2 = new Thread(bank);
		th2.start();
		
		
		
		
		System.out.println("[main 끝]");
	}

}















