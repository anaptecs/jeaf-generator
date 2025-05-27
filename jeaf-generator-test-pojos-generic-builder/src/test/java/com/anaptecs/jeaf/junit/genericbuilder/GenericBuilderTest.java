package com.anaptecs.jeaf.junit.genericbuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import com.anaptecs.jeaf.accounting.impl.pojo.Account;
import com.anaptecs.jeaf.accounting.impl.pojo.Booking;
import com.anaptecs.jeaf.accounting.impl.pojo.Booking.BookingBuilder;
import com.anaptecs.jeaf.accounting.impl.pojo.Customer;
import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import org.junit.jupiter.api.Test;

public class GenericBuilderTest {

  @Test
  void testGenericBuilderSerializationUsage( ) {
    Parent lParent = Parent.builder()
        .setPropertyA("A")
        .build();

    JSONTools lTools = JSON.getJSONTools();
    String lJSON = lTools.writeObjectToString(lParent);
    assertEquals("{\"propertyA\":\"A\"}", lJSON);

    Parent lReadParent = lTools.read(lJSON, Parent.class);
    assertEquals(lParent.getPropertyA(), lReadParent.getPropertyA());

    Child lChild = Child.builder()
        .setPropertyA("A*")
        .setPropertyB(4711)
        .build();

    lJSON = lTools.writeObjectToString(lChild);
    assertEquals("{\"propertyA\":\"A*\",\"propertyB\":4711}", lJSON);

    Child lReadChild = lTools.read(lJSON, Child.class);
    assertEquals(lChild.getPropertyA(), lReadChild.getPropertyA());
    assertEquals(lChild.getPropertyB(), lReadChild.getPropertyB());
  }

  @Test
  void testGeneratedGenericBuilder( ) {
    JSONTools lTools = JSON.getJSONTools();
    String lJSON;

    Currency lCurrency = Currency.getInstance(Locale.GERMANY);

    Account lAccountDonald = Account.builder()
        .setCurrency(lCurrency)
        .setIban(123456)
        .build();

    Customer lDonald = Customer.builder()
        .setEmail("donald@entenhausen.de")
        .setFirstName("Donald")
        .setName("Duck")
        .addToAccounts(lAccountDonald)
        .build();

    lJSON = lTools.writeObjectToString(lDonald);
    System.out.println(lJSON);
    assertEquals(
        "{\"objectType\":\"Customer\",\"name\":\"Duck\",\"firstName\":\"Donald\",\"email\":\"donald@entenhausen.de\",\"accounts\":[{\"iban\":123456,\"currency\":\"EUR\"}]}",
        lJSON);

    Customer lReadCustomer = lTools.read(lJSON, Customer.class);
    assertEquals(lDonald, lReadCustomer);

    lJSON = lTools.writeObjectToString(lAccountDonald);
    System.out.println(lJSON);
    assertEquals("{\"iban\":123456,\"currency\":\"EUR\"}", lJSON);

    Account lAccountDaisy = Account.builder()
        .setCurrency(lCurrency)
        .setIban(47110815)
        .build();

    Customer lDaisy = Customer.builder()
        .setEmail("daisy@entenhausen.de")
        .setFirstName("Daisy")
        .setName("Duck")
        .addToAccounts(lAccountDaisy)
        .build();

    BookingBuilder<?, ?> lBookingBuilder = Booking.builder();
    Booking lBooking = Booking.builder()
        .setAmount(BigDecimal.TEN)
        .setCurrency(lCurrency)
        // .setExecutionTimestamp(DateTools.getDateTools().newCalendar(1748336358480L))
        .setSourceAccount(lAccountDonald)
        .setTargetAccount(lAccountDaisy)
        .build();
    lJSON = lTools.writeObjectToString(lBooking);
    System.out.println(lJSON);
    assertEquals(
        "{\"sourceAccount\":{\"iban\":123456,\"currency\":\"EUR\"},\"targetAccount\":{\"iban\":47110815,\"currency\":\"EUR\"},\"amount\":10,\"currency\":\"EUR\"}",
        lJSON);
    Booking lReadBooking = lTools.read(lJSON, Booking.class);
    assertEquals(lBooking, lReadBooking);

  }
}
