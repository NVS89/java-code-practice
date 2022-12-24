public class MortgageCalculator {
    private final byte MONTHS_IN_YEARS = 12;
    private final byte PERCENT_BASE = 100;

    private int principal;
    private float annualInterest;
    private short years;

    public MortgageCalculator(int principal, float annualInterest, short years) {
        this.setPrincipal(principal);
        this.setAnnualInterest(annualInterest);
        this.setYears(years);
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        double rateBase = Math.pow(1 + monthlyInterest, numberOfPayments);

        return principal * (monthlyInterest * rateBase) / (rateBase - 1);
    }

    public double calculateBalance(short numberPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        double rateBase = Math.pow(1 + monthlyInterest, numberOfPayments);
        double rateBasePaid = Math.pow(1 + monthlyInterest, numberPaymentsMade);

        return principal * (rateBase - rateBasePaid) / (rateBase - 1);
    }

    public double[] getRemainingBalance() {
        double[] balances = new double[getNumberOfPayments()];

        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }

        return balances;
    }

    private void setPrincipal(int principal) {
        this.principal = principal;
    }

    private void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }

    private void setYears(short years) {
        this.years = years;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT_BASE / MONTHS_IN_YEARS;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEARS;
    }
}
