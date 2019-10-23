package ap.service;

import java.math.BigDecimal;

import ap.model.Account;
import ap.model.Currency;
import ap.model.Rate;
import ap.repo.AccountRepo;
import ap.repo.CurrencyRepo;

public class AccountService {

  public static AccountService getInstance() {
    return LazyHolder.INSTANCE;
  }

  private static class LazyHolder {
    private static final AccountService INSTANCE = new AccountService();
  }

  private AccountRepo accountRepo;
  private CurrencyRepo currencyRepo;

  private AccountService() {
    this(AccountRepo.getInstance(), CurrencyRepo.getInstance());
  }

  private AccountService(AccountRepo accountRepo, CurrencyRepo currencyRepo) {
    this.accountRepo = accountRepo;
    this.currencyRepo = currencyRepo;
  }

  public Account getAccount(String fullName) {
    return accountRepo.getAccount(fullName);
  }

  public void changeRateToAccount(Account account, Currency fromCurrency, Currency toCurrency, Double rate) {
    account.updateRate(new Rate(fromCurrency, toCurrency, rate));
  }

  public void changeCashToAccount(Account account, Currency fromCurrency, Currency toCurrency, Double value) {
    BigDecimal cashFrom = BigDecimal.valueOf(account.getCashByCurrency(fromCurrency));
    BigDecimal cashTo = BigDecimal.valueOf(account.getCashByCurrency(toCurrency));

    account.updateCash(toCurrency, 0.0);
  }


}
