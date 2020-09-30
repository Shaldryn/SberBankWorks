package com.sber.lesson6.reflection1_5_6;

import java.util.HashMap;

public class CalculatorCacheProxy implements Calculator {

    private Calculator calculator;
    private HashMap<Integer, Integer> cacheFactorials = new HashMap<>();

    public CalculatorCacheProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int calc(int number) {

        Integer result;

        if (null != (result = cacheFactorials.get(number))) {
            return result;
        }
        result = calculator.calc(number);
        cacheFactorials.put(number, result);
        return result;
    }
}
