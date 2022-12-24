public class Main {

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Enter principal: ", 1_000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (years): ", 1, 30);

        var mortgageCalculator = new MortgageCalculator(principal, annualInterest, years);

        var report = new MortgageReport(mortgageCalculator);

        report.printResult();
        report.printPaymentSchedule();
    }






}
