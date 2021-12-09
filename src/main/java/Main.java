import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        int sum = 1999999;
        double percent = 12.5;
        int monthCount = 24;
        System.out.println("Ежемесячны"+new BigDecimal(sum*((percent/12/100)+(percent/12/100)/(Math.pow(1+(percent/12/100), monthCount)-1))).setScale(2, RoundingMode.HALF_UP));
        System.out.println("Сумма возврата"+new BigDecimal(monthCount*(sum*((percent/12/100)+(percent/12/100)/(Math.pow((1+percent/12/100), monthCount)-1)))).setScale(2, RoundingMode.HALF_UP));
        System.out.println("Переплата"+new BigDecimal(sum*((percent/12/100)+(percent/12/100)/(Math.pow(1+(percent/12/100), monthCount)-1))*monthCount-sum).setScale(2, RoundingMode.HALF_UP));
    }
}
