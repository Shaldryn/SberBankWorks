package com.sber.lesson5;

import java.util.Scanner;

public class PinValidator implements Runnable{

    private final int pinCard = 1234;
    private final int MAX_LENGTH = 4;
    public boolean pinLock = false;

    public boolean checkCard(int pinCard) {
        return this.pinCard == pinCard;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            pinLock = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getPinCard() {
        Scanner in = new Scanner(System.in);
        int numPin = 0;
        while (true) {
            System.out.print("Введите пин-код(4 цифры): ");
            try {
                numPin = in.nextInt();
                if (String.valueOf(numPin).length() == MAX_LENGTH) {
                    return numPin;
                } else {
                    System.out.println("ERROR: Введенный пин-код не соответствует требуемой длины");
                }
            } catch (Exception e) {
                System.out.println("ERROR: Некорректный ввод, пин-код должен состоять только из цифр");
                in.next();
            }
        }
    }
}
