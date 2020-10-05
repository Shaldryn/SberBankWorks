package com.sber.lesson5;

import javax.security.auth.login.AccountLockedException;
import java.util.Timer;
import java.util.TimerTask;

public class TerminalImpl implements Terminal {

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
                System.err.println("Недостаточно средств на карте! Остаток на карте: " + server.getSum());
            }
        } else {
            System.out.println("Сумма снятия должна быть кратна 100!");
            return false;
        }
        return false;
    }

    @Override
    public boolean putMoney(int sum) {
        if (sum % 100 == 0) {
            server.setSum(sum);
            return true;
        } else {
            System.out.println("Сумма пополнения должна быть кратна 100!");
            return false;
        }
    }

    public static void main(String[] args) throws AccountLockedException {

        PinValidator pinValidator = new PinValidator();

        boolean pinSuccess;

        while (true) {
            for (int tryIn = 0; tryIn < 3; tryIn++) {
                int numPin = pinValidator.getPinCard();
                pinSuccess = pinValidator.checkCard(numPin);
                if (pinSuccess) {
                    break;
                } else if (pinValidator.pinLock) {
                    throw new AccountLockedException("Ввод невозможен! Осталось ");
                } else if (tryIn == 2) {
                    pinValidator.pinLock = true;
                    System.out.println("ПРЕВЫШЕНО МАКСИМАЛЬНОЕ ЧИСЛО ПОПЫТОК, ПОПРОБУЙТЕ ЧЕРЕЗ 10 СЕК");
                    pinValidator.run();
                } else {
                    System.out.println("Неверный пин-код");
                }
            }
        }


//        final Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            int i = Integer.parseInt("10");
//            public void run() {
//                System.out.println(i--);
//                if (i< 0)
//                    timer.cancel();
//            }
//        }, 0, 1000);

    }
}
