package com.sber.lesson4;

import java.util.Scanner;

public class PinValidator {

    private int pinCard = 1234;
    public long startTime = 0L;

    public boolean checkCard(int pinCard) {
        return this.pinCard == pinCard;
    }

    public int getPinCard() {
        Scanner in = new Scanner(System.in);
        final int MAX_LENGTH = 4;
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
