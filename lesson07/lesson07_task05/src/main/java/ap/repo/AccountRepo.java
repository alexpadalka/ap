package ap.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ap.model.Account;

public class AccountRepo {

  public static AccountRepo getInstance() {
    return LazyHolder.INSTANCE;
  }

  private static class LazyHolder {
    private static final AccountRepo INSTANCE = new AccountRepo();
  }

  private Map<String, Account> accountMap;

  private AccountRepo() {
    this(new HashMap<>());
  }

  private AccountRepo(Map<String, Account> accountMap) {
    this.accountMap = accountMap;
  }

  public Account getAccount(String name) {
    return accountMap.get(name);
  }

  public void addAccount(Account account) {
    accountMap.put(account.getFullName(), account);
  }

  public List<Account> getAccounts() {
    return Collections.unmodifiableList(new ArrayList<>(accountMap.values()));
  }
}
