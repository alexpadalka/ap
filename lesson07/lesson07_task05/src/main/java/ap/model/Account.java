package ap.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ap.repo.CurrencyRepo;

public class Account {

  private String firstName;
  private String lastName;
  private Map<Currency, Double> cashes;
  private List<Rate> rates;
  private Currency defaultCurrency;

  public Account() {
    this("", "", new HashMap<>(), new ArrayList<>(), "");
  }

  public Account(
      String firstName,
      String lastName,
      Map<Currency, Double> cashes,
      List<Rate> rates,
      String currency) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.cashes = cashes;
    this.rates = rates;
    this.defaultCurrency = CurrencyRepo.getInstance().getCurrency(currency);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFullName() {
    return getFirstName() + " " + getLastName();
  }

  public Map<Currency, Double> getCashes() {
    return cashes;
  }

  public void updateCash(Currency currency, Double value) {
    cashes.put(currency, value);
  }

  public List<Rate> getRates() {
    return rates;
  }

  public void updateRate(Rate newRate) {
    if (newRate == null) {
      return;
    }
    Rate rate =
        rates.stream()
            .filter(r -> newRate.getFromCurrency().getCode() == r.getFromCurrency().getCode())
            .findFirst()
            .orElse(null);

    if (rate != null) {
      rates.remove(rate);
    }
    rates.add(newRate);
  }

  public Double getCashByCurrency(Currency currency) {
    Double cash = cashes.get(currency);
    if (cash == null) {
      cash = 0.0;
    }
    return cash;
  }

  public Currency getDefaultCurrency() {
    return defaultCurrency;
  }

  public void setDefaultCurrency(Currency defaultCurrency) {
    this.defaultCurrency = defaultCurrency;
  }

  public Rate getRateByCurrency(Currency currency) {
    Rate rate =
        getRates().stream()
            .filter(r -> r.getFromCurrency().getCode() == currency.getCode())
            .findFirst()
            .orElse(null);
    return rate;
  }
}
