package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {

    public static void main(String[] args) {
        if(args.length < 2) {
            throw new IllegalArgumentException("Expected at least 2 parameters");
        }
        String[] creditStrings = args[0].split(",");
        String[] debitStrings = args[1].split(",");
        float[] credits = toFloatArray(creditStrings);
        float[] debits = toFloatArray(debitStrings);

        SavingsCalculator savingsCalculator = new SavingsCalculator(credits, debits);
        float netSavings  = savingsCalculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }

    private static float[] toFloatArray(String[] creditStrings) {
        float[] floats = new float[creditStrings.length];
        for(int i = 0; i < creditStrings.length; i++) {
            floats[i] = Utilities.getFloatValue(creditStrings[i]);
        }
        return floats;
    }

    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    public float calculate(){
        return sumOfCredits() - sumOfDebits();
    }

    private float sumOfCredits() {
        float sum = 0f;
        for(float f : credits) {
            sum+= f;
        }
        return sum;
    }

    private float sumOfDebits() {
        float sum = 0f;
        for(float f : debits) {
            sum+= f;
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date){
        YearMonth month = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth  = month.lengthOfMonth() - date.getDayOfMonth();
        return totalDaysInMonth ;
    }
}
