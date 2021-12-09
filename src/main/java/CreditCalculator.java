import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCalculator {
    private int sum;
    private double percent;
    private int monthCount;

    public CreditCalculator(int sum, double percent, int monthCount) {
        this.sum=sum;
        this.percent=percent;
        this.monthCount=monthCount;
    }

    public BigDecimal monthlyPayment(){
        return new BigDecimal(sum*((percent/12/100)+(percent/12/100)/(Math.pow(1+(percent/12/100), monthCount)-1))).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal refundAmount(){
        return new BigDecimal(monthCount*(sum*((percent/12/100)+(percent/12/100)/(Math.pow((1+percent/12/100), monthCount)-1)))).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal overpayment(){
        return new BigDecimal(sum*((percent/12/100)+(percent/12/100)/(Math.pow(1+(percent/12/100), monthCount)-1))*monthCount-sum).setScale(2, RoundingMode.HALF_UP);
    }
}
