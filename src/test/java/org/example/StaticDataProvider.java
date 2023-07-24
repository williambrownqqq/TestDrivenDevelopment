package org.example;
import org.testng.annotations.DataProvider;
public class StaticDataProvider {
    @DataProvider(name = "dataForFunction")
    public static Object[][] createDataForFunction(){
        return new Object[][]{
                {0.5, 1.0},
                {2.0, -0.240462},
                {1.0, 0.0},
                {1.1, -0.057662}
        };
    }

    @DataProvider(name = "dataForSteps")
    public static Object[][] createDataForSteps(){
        return new Object[][]{
                {0.0, 10.0, 0.1, 101},
                {0.0, 3.0, 0.004, 751}
        };
    }

    @DataProvider(name = "dataForFillX")
    public Object[][] dataForFillX() {
        return new Object[][]{
                {175, 0.7},
                {350, 1.4},
                {750, 3.0}
        };
    }
    @DataProvider(name = "dataForFillY")
    public Object[][] dataForFillY() {
        return new Object[][]{
                {175, 1.0},
                {350, -0.329742},
                {750, 0.214242}
        };
    }

    @DataProvider(name = "dataForFindMaxValue")
    public Object[][] dataForFindMaxValue() {
        return new Object[][]{
                {0}
        };
    }

    @DataProvider(name = "dataForFindMinValue")
    public Object[][] dataForFindMinValue() {
        return new Object[][]{
                {362}
        };
    }

    @DataProvider(name = "dataForCalculateSum")
    public Object[][] dataForCalculateSum() {
        return new Object[][]{
                {118.943654}
        };
    }

    @DataProvider
    public Object[][] CalculateArithmeticMean() {
        return new Object[][]{
                {0.158380}
        };
    }
}
