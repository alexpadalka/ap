package ap.main;

import ap.service.AccountService;
import ap.util.FileUtil;

public class Executor {

  public static void main(String[] args) {
    FileUtil.loadCurrencies();
    FileUtil.loadAccounts();

    AccountService accountService = AccountService.getInstance();
//    accountService.addRateToAccount("Test Account");

    FileUtil.saveAccounts();
  }
}
