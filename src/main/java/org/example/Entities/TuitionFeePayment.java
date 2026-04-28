package org.example.Entities;

public class TuitionFeePayment {
    private double totalTuition;
    private double balancePaid;
    private double remainingBalance;

    public TuitionFeePayment() {
        this(0.0);
    }

    public TuitionFeePayment(double totalTuition) {
        this.totalTuition = totalTuition;
        this.balancePaid = 0.0;
        this.remainingBalance = totalTuition;
    }

    public double getTotalTuition() { return totalTuition; }
    public void setTotalTuition(double totalTuition) { this.totalTuition = totalTuition; }

    public double getBalancePaid() { return balancePaid; }
    public void setBalancePaid(double balancePaid) { this.balancePaid = balancePaid; }

    public double getRemainingBalance() { return remainingBalance; }
    public void setRemainingBalance(double remainingBalance) { this.remainingBalance = remainingBalance; }

    @Override
    public String toString() {
        return "\n" +
                "  ┌─────── FINANCIAL SUMMARY ────────┐\n" +
                "    Total Tuition : ₱" + String.format("%.2f", totalTuition) + "\n" +
                "    Amount Paid   : ₱" + String.format("%.2f", balancePaid) + "\n" +
                "    Current Bal.  : ₱" + String.format("%.2f", remainingBalance) + "\n" +
                "  └──────────────────────────────────┘";
    }
}