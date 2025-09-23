package com.anaptecs.jeaf.junit.genericbuilder;

import java.util.HashSet;
import java.util.Set;

import com.anaptecs.jeaf.accounting.impl.pojo.Account;
import com.anaptecs.jeaf.accounting.impl.pojo.Customer;
import com.anaptecs.jeaf.tools.api.performance.PerformanceTools;
import com.anaptecs.jeaf.tools.api.performance.Stopwatch;
import com.anaptecs.jeaf.tools.api.performance.TimePrecision;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PerformanceTest {
  static final PerformanceTools performanceTools = PerformanceTools.getPerformanceTools();

  static final int runs = 50000000;

  static final int warmUpRuns = runs / 5;

  @Test
  @Order(0)
  void warmUp( ) {
    this.internalMixturePerformanceTest(warmUpRuns);
  }

  @Test
  @Order(1)
  void setOnlyPerformanceTest( ) {
    Stopwatch lStopwatch;

    // Test set(...) only
    lStopwatch = performanceTools.createStopwatch("set(...) only", TimePrecision.NANOS);
    lStopwatch.start();
    this.internalSetOnlyPerformanceTest(runs);
    lStopwatch.stopAndTrace(runs);
  }

  @Test
  @Order(2)
  void mixturePerformanceTest( ) {
    Stopwatch lStopwatch;

    // Test combination of set(...) and addTo(...)
    lStopwatch = performanceTools.createStopwatch("set(...) and addTo(...)", TimePrecision.NANOS);
    lStopwatch.start();
    this.internalMixturePerformanceTest(runs);
    lStopwatch.stopAndTrace(runs);
  }

  @Test
  @Order(3)
  void addToOnlyPerformanceTest( ) {
    Stopwatch lStopwatch;

    // Test addTo(...) only
    lStopwatch = performanceTools.createStopwatch("addTo(...) only", TimePrecision.NANOS);
    lStopwatch.start();
    internalAddToOnlyPerformanceTest(runs);
    lStopwatch.stopAndTrace(runs);
  }

  private void internalSetOnlyPerformanceTest(int pRuns) {
    for (int i = 0; i < pRuns; i++) {
      Set<Account> lAccounts = new HashSet<>();
      for (int j = 0; j < 12; j++) {
        lAccounts.add(Account.builder().build());
      }
      Customer.builder()
          .setAccounts(lAccounts)
          .build();
    }
  }

  private void internalMixturePerformanceTest(int pRuns) {
    for (int i = 0; i < pRuns; i++) {
      Set<Account> lAccounts = new HashSet<>();
      for (int j = 0; j < 10; j++) {
        lAccounts.add(Account.builder().build());
      }
      Customer.builder()
          .setAccounts(lAccounts)
          .addToAccounts(
              Account.builder().build(),
              Account.builder().build())
          .build();
    }
  }

  private void internalAddToOnlyPerformanceTest(int pRuns) {
    for (int i = 0; i < pRuns; i++) {
      Set<Account> lAccounts = new HashSet<>();
      var lBuilder = Customer.builder();
      lBuilder.setAccounts(lAccounts);

      for (int j = 0; j < 10; j++) {
        lBuilder.addToAccounts(Account.builder().build());
      }

      lBuilder.build();
    }
  }
}
