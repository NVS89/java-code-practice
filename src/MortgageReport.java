import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private final NumberFormat currency;
    private MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.setCalculator(mortgageCalculator);
        currency = NumberFormat.getCurrencyInstance(Locale.US);
    }

    public void setCalculator(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
    }

    public void printResult() {
        double mortgage = mortgageCalculator.calculateMortgage();

        String mortgageFormatted = currency.format(mortgage);

        System.out.println("========");
        System.out.println("mortgage".toUpperCase());
        System.out.println("========");
        System.out.printf("Monthly Payments: %s%n", mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("payment schedule".toUpperCase());
        System.out.println("================");

        for (double balance : mortgageCalculator.getRemainingBalance()) {
            System.out.println(currency.format(balance));
        }
    }

}
