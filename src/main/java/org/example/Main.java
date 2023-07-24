package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
    private final double EPS = 1e-6; // похибка
    private final double a = -0.5;
    private final double b = 2.0;
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }

    public double f(double x) {
        if(x <= 0.7+EPS) return 1;
        if(x > 1.4 + EPS){
            return Math.exp(a*x)*Math.cos(b*x);
        }
        return a*x*x*Math.log(x);
    }

    public int steps(double start, double end, double step) {
        return (int) (Math.round((end -start)/ step) + 1);
    }

    public double[] fillX(double start, double end, double step) {
//        double[] x = new double[steps(start, end, step)];
//        for(int i =0; i < x.length; i++){
//            x[i] = start + i *step;
//        }
//        return x;
        return IntStream.
                range(0, steps(start, end, step))
                .mapToDouble(i -> start + i * step)
                .toArray();
    }

    public double[] fillY(double[] x) {
        return DoubleStream.of(x).map(this::f).toArray();
    }

    public int findIndexOfMaxValue(double[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[index]) {
                index = i;
            }
        }
        return index;
    }

    public int findIndexOfMinValue(double[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }

    public double calculateSum(double[] array) {
//        double sum =0;
//        for(double value: array){
//            sum += value;
//        }
//        return sum;
        return Arrays.stream(array).sum();
    }

    public double calculateArithmeticMean(double[] array) {
        double sum = calculateSum(array);
        return sum / array.length;
    }
}