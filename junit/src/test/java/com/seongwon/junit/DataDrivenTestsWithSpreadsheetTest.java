paTimesBckage com.seongwon.junit;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DataDrivenTestsWithSpreadsheetTest{
    private double a;
    private double b;
    private double aTimesB;

    @Parameters
    public static Collection spreadsheetData() throws IOException{
        InputStream spreadsheet = new FileInputStream("src/test/resources/aTimesB.xls");
        return new SpreadsheetData(spreadsheet).getData();
    }
    public DataDrivenTestsWithSpreadsheetTest(double a, double b, double aTimesB){
        this.a = a;
        this.b = b;
        this.aTimesB = aTimesB;
    }
    @Test
    public void shouldCalculateATimesB(){
        double calculatedValue = a * b;
        assertEquals(calculatedValue, aTimesB, 0.001);
    }
}