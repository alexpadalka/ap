package ap.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ap.model.Account;
import ap.model.Currency;
import ap.model.Rate;
import ap.repo.AccountRepo;
import ap.repo.CurrencyRepo;

public class FileUtil {

  private static Logger logger = Logger.getLogger("Logger");

  public static void loadAccounts() {
    Path resourceDirectory = Paths.get("src", "main", "resources", "txt", "accounts");
    String absolutePath = resourceDirectory.toFile().getAbsolutePath();

    List<Account> accounts = new ArrayList<>();
    try (Stream<Path> paths = Files.walk(Paths.get(absolutePath))) {
      paths
          .filter(Files::isRegularFile)
          .map(Path::toFile)
          .forEach(f -> accounts.add(getAccountFromFile(f)));
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.getMessage());
    }

    AccountRepo accountRepo = AccountRepo.getInstance();
    accounts.forEach(accountRepo::addAccount);
  }

  public static void saveAccounts() {
    Path resourceDirectory = Paths.get("src", "main", "resources", "txt", "accounts");
    String absolutePath = resourceDirectory.toFile().getAbsolutePath();
    List<Account> accounts = AccountRepo.getInstance().getAccounts();
    accounts.forEach(account -> saveAccount(account, absolutePath));
  }

  public static void saveAccount(Account account, String absolutePath) {
    String fileName = Arrays.stream(account.getFullName().split(" ")).collect(Collectors.joining());

    try {
      String path = absolutePath + "\\" + fileName + ".txt";
      PrintWriter writer = new PrintWriter(path, "UTF-8");
      writer.println(account.getFullName());

      Map<Currency, Double> cashes = account.getCashes();
      List<Rate> rates = account.getRates();

      rates.forEach(rate -> {
        Currency fromCurrency = rate.getFromCurrency();
        Currency toCurrency = rate.getToCurrency();
        Double value = cashes.get(fromCurrency);
        Double r = rate.getRate();
        String s = fromCurrency.getAbbreviation() + " " + value + " " + toCurrency.getAbbreviation() + " " + r;
        writer.println(s);
      });

      writer.close();
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Error parse file " + fileName);
      logger.log(Level.SEVERE, e.getMessage());
    }
  }

  public static Account getAccountFromFile(File file) {
    Account account = null;
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
      String[] name = randomAccessFile.readLine().split(" ");
      String defCurr = randomAccessFile.readLine();
      String str;
      Map<Currency, Double> cashes = new HashMap<>();
      List<Rate> rates = new ArrayList<>();
      CurrencyRepo currencyRepo = CurrencyRepo.getInstance();
      while ((str = randomAccessFile.readLine()) != null) {
        String[] split = str.split(" ");
        Currency fromCurrency = currencyRepo.getCurrency(split[0]);
        cashes.put(fromCurrency, Double.parseDouble(split[1]));
        Currency toCurrency = currencyRepo.getCurrency(split[2]);
        rates.add(new Rate(fromCurrency, toCurrency, Double.parseDouble(split[3])));
      }
      account = new Account(name[0], name[1], cashes, rates, defCurr);
    } catch (IOException | NumberFormatException e) {
      logger.log(Level.SEVERE, "Error parse file " + file.getName());
      logger.log(Level.SEVERE, e.getMessage());
    } finally {
      return account;
    }
  }

  public static void loadCurrencies() {
    Path resourceDirectory = Paths.get("src", "main", "resources", "txt");
    String absolutePath = resourceDirectory.toFile().getAbsolutePath() + "\\currencies.txt";
//    logger.info("Start load currencies from " + absolutePath);
    CurrencyRepo currencyRepo = CurrencyRepo.getInstance();
    try (RandomAccessFile randomAccessFile = new RandomAccessFile(absolutePath, "r")) {
      String str;
      while ((str = randomAccessFile.readLine()) != null) {
        String[] split = str.split("-");
        currencyRepo.addCurrency(split[0], Integer.parseInt(split[1]), split[2]);
      }
//      logger.info("Finish load currencies from " + absolutePath);
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Error parse file currencies.txt");
      logger.log(Level.SEVERE, e.getMessage());
    }
  }
}
