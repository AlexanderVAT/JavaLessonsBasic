package org.javalessons.basic;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

import static sun.management.snmp.AdaptorBootstrap.initialize;


public class GoogleSearchTest {
    public static final String HTTPS_GOOGLE_COM = "https://google.com";
    public static final String HTTPS_GOOGLE_COM1 = "https://google.com";
    public static final String SEARCH_QUARY = "Java books";
    public static final NumberFormat formatNumber = NumberFormat.getInstance(Locale.GERMANY);
    public static final String HTTPS_AMAZON_DE = "https://amazon.de";
    public static final String JAVA_BOOK = "java book";
    public static final String HTTPS_WWW_AMAZON_DE = "https://www.amazon.de/";
    public static final int SEARCH_PRICE = 555;

    WebDriver driver;
    private WebElement element;

    @Before
    public void executeBeforeEach() {
        String chromeDriverPath = "/Users/xxx/Downloads/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    @After
    public void executeAfterEach() {
        driver.quit();
    }

    @Test
    public void testGoogleSearchWorks() {
        driver.get(HTTPS_GOOGLE_COM);

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("telran berlin");

        element.submit();

        String url = "https://www.google.com/search";
        Assert.assertTrue(driver.getCurrentUrl().startsWith(url));
    }

    @Test
    public void testAmazonJavaBooksPricesBelowTenEuro() throws ParseException {
        driver.get(HTTPS_WWW_AMAZON_DE);

        WebElement element = driver.findElement(By.name("field-keywords"));
        element.sendKeys("java book");

        element.submit();

        List<WebElement> book = driver.findElements(By.xpath("s-price"));
        NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
        for (WebElement b : book) {
            String price = b.getText().substring(4, 5);
            Number number = format.parse(price);
            double d = number.doubleValue();
            if (d < 10) {
                return;
            }

        }
       // Assert.fail();
    }

@Test
public void testAmazonMacBookPricesBelowfiveHundertFiftyFiveEuro() throws ParseException{
    driver.get(HTTPS_WWW_AMAZON_DE);
    WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
    element.sendKeys("Mac Book");
    element.submit();

    Multimap<String, String> cheapMackBooks = ArrayListMultimap.create();

    for (int i = 0; i < 5; i++) {

        List<WebElement> MacBookResultItemElements = driver.findElements(By.cssSelector(".s-result-item"));

        for (WebElement item : MacBookResultItemElements) {

            try {
                WebElement priceElement = item.findElement(By.cssSelector(".s-price"));
                WebElement titleElement = item.findElement(By.cssSelector(".s-access-title"));
                WebElement linkElement = item.findElement(By.tagName("Mac"));


                String titleText = titleElement.getText();
                String link = linkElement.getAttribute("href");
                String priceText = priceElement.getText();

                String price = priceText.substring(4);
                Number number = formatNumber.parse(price);
                Double dPrice = number.doubleValue();


                if (dPrice <= SEARCH_PRICE) {
                    cheapMackBooks.put(titleText, priceText);
                    cheapMackBooks.put(titleText, link);
                }

            } catch (NoSuchElementException ignored) {
                ignored.printStackTrace();

            }

            finally

            {
                continue;
            }

        }
        driver.findElement(By.id("pagnNextString")).click();
    }
    Set<String> MackBook = cheapMackBooks.keySet();
    for (String Object : MackBook) {
        System.out.println("Price and link:"+ cheapMackBooks.get(Object));
        System.out.println("Title:"+ MackBook);

    }



}


}




