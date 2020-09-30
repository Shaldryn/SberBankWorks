package com.sber.lesson6.reflection1_5_6;

public class CalculatorImpl implements Calculator{
    //Без расчета больших чисел
    @Override
    public int calc(int number) {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (number < 0) {
            throw new IllegalArgumentException("Факторил не может быть рассчитан у отрицательных числах");
        }

        if (number == 0) {
            return 1;
        }
        return number * calc(number - 1);
    }

}
