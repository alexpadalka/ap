package com.epam.jmp.lesson01_lambdas.task06;

public class A {

  public static final String VALUE_STRING = "String value";
  public static final String VALUE_INTEGER = "Integer value";
  public static final String VALUE_DOUBLE = "Double value";
  public static final String VALUE_BOOLEAN = "Boolean value";

  private int i;
  private double d;
  private String s;
  private boolean b;

  public int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  public double getD() {
    return d;
  }

  public void setD(double d) {
    this.d = d;
  }

  public String getS() {
    return s;
  }

  public void setS(String s) {
    this.s = s;
  }

  public boolean isB() {
    return b;
  }

  public void setB(boolean b) {
    this.b = b;
  }

  @Override
  public String toString() {
    return "[i=" + i + ", d=" + d + ", b=" + b + ", s=" + s + "]";
  }
}
