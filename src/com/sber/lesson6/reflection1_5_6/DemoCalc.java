package com.sber.lesson6.reflection1_5_6;

public class DemoCalc {

    static int value = 5;

    public static void main(String[] args) {

        // Задача 5: Реализовать кэширующий прокси
        Calculator naiveCalc = new CalculatorImpl();
        Calculator smartCalc = new CalculatorCacheProxy(naiveCalc);
        /* Задача 6: Создать свою аннотацию Metric. Реализовать proxy класс PerformanceProxy,
        который в случае если метод аннотирован Metric будет выводить на консоль время выполнения метода.
         */
        Calculator metricCalc = PerformanceProxy.proxyFactory(naiveCalc);

        System.out.printf("Task 5: Factorial %d = %d\n" , value, smartCalc.calc(value));

        long naive = test(naiveCalc);
        long smart = test(smartCalc);
        System.out.println("Time saved by caching proxy: " + (naive - smart) + "ms");

        System.out.println("Task 6:");
        metricCalc.calc(value);

    }

    private static long test(Calculator calculator) {
        long startTime = System.currentTimeMillis();

        calculator.calc(value);
        calculator.calc(value);

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }

}
