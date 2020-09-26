package com.sber.lesson5;

import javax.security.auth.login.AccountLockedException;

public class TerminalImpl implements Terminal{

    private final TerminalServer server;
    private final PinValidator pinValidator;

    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    @Override
    public int getBalance() {
        return server.getSum();
    }

    @Override
    public boolean getMoney(int sum) {
        if (sum % 100 == 0) {
            try {
                server.getSum(sum);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return false;
        }
        return false;
    }

    @Override
    public boolean putMoney(int sum) {
        return server.setSum(sum);
    }

    public static void main(String[] args) throws AccountLockedException {

        PinValidator pinValidator = new PinValidator();

        boolean pinSuccess = false;

        for (int tryIn = 0; tryIn < 3; tryIn++) {
            int numPin = pinValidator.getPinCard();
            pinSuccess = pinValidator.checkCard(numPin);
            if (pinSuccess){
                break;
            } else if (tryIn == 2) {
                pinValidator.startTime = System.currentTimeMillis();
                System.out.println("ПРЕВЫШЕНО МАКСИМАЛЬНОЕ ЧИСЛО ПОПЫТОК, ПОПРОБУЙТЕ ЧЕРЕЗ 10 СЕК");
                return;
            } else {
                System.out.println("Неверный пин-код");
            }
        }
    }
}
