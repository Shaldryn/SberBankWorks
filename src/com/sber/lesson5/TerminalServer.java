package com.sber.lesson5;

public class TerminalServer {

    private int sum = 1500;

    public int getSum() {
        return sum;
    }

    public boolean setSum(int balance) {
        this.sum += balance;
        return true;
    }

    public void getSum(int sum) throws Exception {
        if (sum > this.sum) {
            this.sum -= sum;
        } else {
            throw new Exception();
        }
    }
}
