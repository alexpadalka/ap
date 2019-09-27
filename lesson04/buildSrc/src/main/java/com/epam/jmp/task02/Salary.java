package com.epam.jmp.task02;

public class Salary {

  public static final int DEFAULT_SALARY_AMOUNT = 100;

  private int amount;

  public Salary() {
    this(DEFAULT_SALARY_AMOUNT);
  }

  public Salary(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
