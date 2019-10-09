package ap;

import ap.task02.Salary;

public class Utility {

  public static Salary getSalary() {
    return getSalary(Salary.DEFAULT_SALARY_AMOUNT);
  }

  public static Salary getSalary(int amount) {
    return new Salary(amount);
  }
}
