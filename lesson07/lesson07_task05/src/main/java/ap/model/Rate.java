package ap.model;

public class Rate {

  private Currency fromCurrency;
  private Currency toCurrency;
  private Double rate;

  public Rate(Currency fromCurrency, Currency toCurrency, Double rate) {
    this.fromCurrency = fromCurrency;
    this.toCurrency = toCurrency;
    this.rate = rate;
  }

  public Currency getFromCurrency() {
    return fromCurrency;
  }

  public Currency getToCurrency() {
    return toCurrency;
  }

  public Double getRate() {
    return rate;
  }
}
