package ap.service;

import ap.model.Currency;
import ap.repo.CurrencyRepo;

public class CurrencyService {

  public static CurrencyService getInstance() {
    return LazyHolder.INSTANCE;
  }

  private static class LazyHolder {
    private static final CurrencyService INSTANCE = new CurrencyService();
  }

  private CurrencyRepo currencyRepo;

  private CurrencyService() {
    this(CurrencyRepo.getInstance());
  }

  private CurrencyService(CurrencyRepo currencyRepo) {
    this.currencyRepo = currencyRepo;
  }

  public Currency getCurrency(String code) {
    return currencyRepo.getCurrency(code);
  }
}
