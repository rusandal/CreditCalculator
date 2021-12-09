import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        int sum = 1999999;
        double percent = 12.5;
        int monthCount = 24;

        CreditCalculator creditCalculator = new CreditCalculator(sum, percent,monthCount);
        System.out.println("Ежемесячный платеж"+creditCalculator.monthlyPayment());
        System.out.println("Сумма возврата"+creditCalculator.refundAmount());
        System.out.println("Переплата"+creditCalculator.overpayment());
    }
}
