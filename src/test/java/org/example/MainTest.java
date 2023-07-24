package org.example;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.*;

public class MainTest {

    public final static double EPS = 1e-6;
    Main main;
    @BeforeMethod
    void setUp() {
        main = new Main();
    }

    @Test(dataProvider = "dataForFunction", dataProviderClass = StaticDataProvider.class)
    public void testF(double x, double expected) {
        double actual = main.f(x);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }
    @Test(dataProvider = "dataForSteps", dataProviderClass = StaticDataProvider.class)
    public void testSteps(double start, double end, double step, int expected){
        int actual = main.steps(start, end, step);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForFillX", dataProviderClass = StaticDataProvider.class)
    public void testFillX(int index, double expected){
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;
        double[] x = main.fillX(start, end, step);
        assertThat(x[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForFillY", dataProviderClass = StaticDataProvider.class)
    public void testFillY(int index, double expected){
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        assertThat(y[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForFindMaxValue", dataProviderClass = StaticDataProvider.class)
    public void testFindIndexOfMaxValue(int expectedIndex){
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(y));
        int actualIndex = main.findIndexOfMaxValue(y);
//        System.out.println(actualIndex);
        assertThat(actualIndex).isEqualTo(expectedIndex);
    }

    @Test(dataProvider = "dataForFindMinValue", dataProviderClass = StaticDataProvider.class)
    public void testFindIndexOfMinValue(int expectedIndex){
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(y));
        int actualIndex = main.findIndexOfMinValue(y);
//        System.out.println(actualIndex);
        assertThat(actualIndex).isEqualTo(expectedIndex);
    }

    @Test(dataProvider = "dataForCalculateSum", dataProviderClass = StaticDataProvider.class)
    public void testCalculateSum(double expectedSum){
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        double sum = main.calculateSum(y);
        System.out.println(sum);
        assertThat(sum).isCloseTo(expectedSum, Offset.offset(EPS));
    }
    @Test(dataProvider = "CalculateArithmeticMean", dataProviderClass = StaticDataProvider.class)
    public void testCalculateArithmeticMean(double expectedArithmeticMean){
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;
        double[] x = main.fillX(start, end, step);
        double[] y = main.fillY(x);
        double sum = main.calculateSum(y);
        double arithmeticMean = sum / y.length;
//        System.out.println(arithmeticMean);
        assertThat(arithmeticMean).isCloseTo(expectedArithmeticMean, Offset.offset(EPS));
    }
}

