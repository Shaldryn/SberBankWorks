package com.sber.lesson6.reflection1;

public class CalculatorImpl implements Calculator{
    //Без кэша и расчета больших чисел
    @Override
    public int calc(int number) {

        if (number < 0) {
            throw new IllegalArgumentException("Факторил не может быть рассчитан у отрицательных числах");
        }

        if (number == 0) {
            return 1;
        }
        return number * calc(number - 1);
    }

    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        System.out.println(calculator.calc(2));
    }

}
