package util;

public final class FinancialUtils {

    private FinancialUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Calculates compound interest.
     *
     * @param principal The principal amount.
     * @param annualInterestRate The annual interest rate (in percentage).
     * @param timesCompounded The number of times interest is compounded per year.
     * @param years The number of years the money is invested or borrowed for.
     * @return The amount of money accumulated after n years, including interest.
     */
    public static double calculateCompoundInterest(double principal, double annualInterestRate, int timesCompounded, int years) {
        double rate = annualInterestRate / 100;
        return principal * Math.pow(1 + rate / timesCompounded, timesCompounded * years);
    }

    /**
     * Predicts the future value of an investment based on compound interest.
     *
     * @param principal The principal amount.
     * @param annualInterestRate The annual interest rate (in percentage).
     * @param timesCompounded The number of times interest is compounded per year.
     * @param years The number of years the money is invested.
     * @return The predicted future value of the investment.
     */
    public static double predictFutureValue(double principal, double annualInterestRate, int timesCompounded, int years) {
        return calculateCompoundInterest(principal, annualInterestRate, timesCompounded, years);
    }

    /**
     * Calculates the monthly payment for a loan.
     *
     * @param loanAmount The total amount of the loan.
     * @param annualInterestRate The annual interest rate (in percentage).
     * @param numberOfPayments The total number of monthly payments.
     * @return The monthly payment amount.
     */
    public static double calculateMonthlyLoanPayment(double loanAmount, double annualInterestRate, int numberOfPayments) {
        double monthlyRate = annualInterestRate / 100 / 12;
        return loanAmount * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments)) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
    }

    /**
     * Calculates the total cost of a loan.
     *
     * @param monthlyPayment The monthly payment amount.
     * @param numberOfPayments The total number of monthly payments.
     * @return The total cost of the loan.
     */
    public static double calculateTotalLoanCost(double monthlyPayment, int numberOfPayments) {
        return monthlyPayment * numberOfPayments;
    }

    /**
     * Rounds a double value to two decimal places.
     *
     * @param value The value to round.
     * @return The rounded value.
     */
    public static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
