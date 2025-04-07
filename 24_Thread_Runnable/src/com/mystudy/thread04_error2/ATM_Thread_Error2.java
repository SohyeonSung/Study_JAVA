package com.mystudy.thread04_error2;

class Bank {
	int money = 0;
}

class ATM extends Thread {
	Bank bank;
	String thredName;
	public ATM(Bank bank, String thredName) {
		super(thredName); //쓰레드명 전달
		this.bank = bank;
		this.thredName = thredName;
	}

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
	// synchronized : 동기화처리
	// 사용중에 다른 쓰레드가 사용하려고 할 때 대기상태가 됨
	synchronized void add(int money) {
		bank.money += money;
		System.out.println(Thread.currentThread().getName() + " - " +
				"입금: " + money + ", 잔액: " + bank.money);
	}
	synchronized void out(int money) {
		bank.money -= money;
		System.out.println(thredName + " - " +
				"출금: " + money + ", 잔액: " + bank.money);
	}
	private void bankSleep(int milliseconds) {
		try {
			Thread.currentThread().sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


public class ATM_Thread_Error2 {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ----");
		Bank bank = new Bank();
		System.out.println("은행잔고 : " + bank.money);
		
		ATM atm1 = new ATM(bank, "ATM-1");
		atm1.start();
		
		ATM atm2 = new ATM(bank, "ATM-2");
		atm2.start();

		System.out.println("--- main() 끝 ----");
	}

}







