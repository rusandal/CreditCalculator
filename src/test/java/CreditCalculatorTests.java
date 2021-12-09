import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCalculatorTests {
    CreditCalculator creditCalculator;
    int sum = 1999999;
    double percent = 12.5;
    int monthCount = 24;

    @BeforeEach
    public void initCalc(){
        creditCalculator = new CreditCalculator();
    }

    @AfterEach
    public void clearCalc(){
        creditCalculator = null;
    }

    @Test
    public void testMonthlyPayment(){
        //double expected = 94614.57;
        BigDecimal expected = new BigDecimal(sum*((percent/12/100)+(percent/12/100)/(Math.pow(1+(percent/12/100), monthCount)-1))).setScale(2, RoundingMode.HALF_UP);

        BigDecimal result = creditCalculator.monthlyPayment(sum, percent, monthCount);

        Assertions.assertEquals(result, expected);

    }

    @Test
    public void testRefundAmount(){
        //double expected = 2270749.66;
        BigDecimal expected = new BigDecimal(monthCount*(sum*((percent/12/100)+(percent/12/100)/(Math.pow((1+percent/12/100), monthCount)-1)))).setScale(2, RoundingMode.HALF_UP);

        BigDecimal result = creditCalculator.refundAmount(sum, percent, monthCount);

        Assertions.assertEquals(result, expected);
    }

    @Test
    public void testOverpayment(){
        //double expected = 270750.66;
        BigDecimal expected = new BigDecimal(sum*((percent/12/100)+(percent/12/100)/(Math.pow(1+(percent/12/100), monthCount)-1))*monthCount-sum).setScale(2, RoundingMode.HALF_UP);

        BigDecimal result = creditCalculator.overpayment(sum, percent, monthCount);

        Assertions.assertEquals(result, expected);
    }
}