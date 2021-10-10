package org.yeasheng.componet;

public class Account {
    public int id;
    public int balance;

    public void transfer(Account target, int amt) {
        Account left = this;
        Account right = target;
        if (this.id > target.id) {
            left = target;
            right = this;
        }
        synchronized (left) {
            synchronized (right) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

    public Account(int id,int balance) {
    	this.id = id;
    	this.balance = balance;

	}
	public Account(){}

}
