package ap.repo;

import java.util.HashMap;
import java.util.Map;

import ap.model.Currency;

public class CurrencyRepo {

  public static CurrencyRepo getInstance() {
    return LazyHolder.INSTANCE;
  }

  private static class LazyHolder {
    private static final CurrencyRepo INSTANCE = new CurrencyRepo();
  }

  private Map<String, Currency> currencies;

  private CurrencyRepo() {
    this(new HashMap<>());
  }

  private CurrencyRepo(Map<String, Currency> currencies) {
    this.currencies = currencies;
  }

  public Currency getCurrency(String code) {
    return currencies.get(code);
  }

  public void addCurrency(String abbreviation, Integer code, String name) {
    addCurrency(new Currency(abbreviation, code, name));
  }

  public void addCurrency(Currency currency) {
    currencies.put(currency.getAbbreviation(), currency);
  }
}
