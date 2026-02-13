package com.anaptecs.jeaf.junit.genericbuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import com.anaptecs.jeaf.accounting.impl.pojo.Account;
import com.anaptecs.jeaf.accounting.impl.pojo.Customer;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.tools.api.file.FileTools;
import com.anaptecs.jeaf.tools.api.performance.PerformanceTools;
import com.anaptecs.jeaf.tools.api.performance.Stopwatch;
import com.anaptecs.jeaf.tools.api.performance.TimePrecision;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JSONPerformanceTest {
  static final PerformanceTools performanceTools = PerformanceTools.getPerformanceTools();

  static final int runs = 1000;

  static final int warmUpRuns = runs / 5;

  @Test
  @Order(0)
  void warmUp( ) throws IOException {
    String lFileContent = FileTools.getFileTools().getFileContentAsString("./src/test/resources/Customer.json");
    this.executeTest(lFileContent, warmUpRuns);
    ;
  }

  @Test
  @Order(1)
  @Disabled
  void testWritePerformance( ) {
    Stopwatch lStopwatch;

    // Test set(...) only
    lStopwatch = performanceTools.createStopwatch("set(...) only", TimePrecision.NANOS);
    lStopwatch.start();
    // String lJSON = JSONTools.getJSONTools().writeObjectsToString(this.createCustomer(runs), Customer.class);
    // System.out.println(lJSON);
    lStopwatch.stopAndTrace(runs);
  }

  @Test
  @Order(2)
  void testReadPerformance( ) throws IOException {
    Stopwatch lStopwatch;
    String lFileContent = FileTools.getFileTools().getFileContentAsString("./src/test/resources/Customer.json");

    // Test combination of set(...) and addTo(...)
    lStopwatch = performanceTools.createStopwatch("Read Customer", TimePrecision.NANOS);
    lStopwatch.start();
    this.executeTest(lFileContent, runs);
    lStopwatch.stopAndTrace(runs);
  }

  private void executeTest(String lFileContent, int pRuns) {
    for (int i = 0; i < pRuns; i++) {
      JSONTools.getJSONTools().readToCollection(lFileContent, List.class, Customer.class);
    }
  }

  private List<Customer> createCustomer(int pCount) {
    List<Customer> lCustomers = new ArrayList<>(pCount);
    for (int i = 0; i < pCount; i++) {
      Customer lCustomer = Customer.builder()
          .setFirstName("Donald " + i)
          .setName("Duck")
          .setEmail("donald.duck" + i + "@entenhausen.de")
          .setTags("4711;0815")
          .addToAccounts(
              Account.builder()
                  .setCurrency(Currency.getInstance("CHF"))
                  .setIban(1000 + i)
                  .build())
          .build();
      lCustomers.add(lCustomer);
    }
    return lCustomers;
  }
}
