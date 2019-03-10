

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.BeforeClass;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class calcTest {
  private static WebDriver driver;
  private static String url = "https://web2.0calc.com/";
  private static CalcPageObject calcPageObject;

  @BeforeClass
  public static void beforeTest() {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--no-sandbox");
    driver = new ChromeDriver();

    driver.navigate().to(url);

    calcPageObject = new CalcPageObject(driver);
    calcPageObject.click_accept_cookies();
  }
  @AfterClass
  public static void afterTest() {
    driver.quit();
  }

  @Test
  public void calcAdd() {

    calcPageObject.doClear();
    calcPageObject.get2().click();
    calcPageObject.getPlus().click();
    calcPageObject.get3().click();
    String rslt = calcPageObject.getResults("5");
    assertEquals("2+3=","5",rslt);

  }

  @Test
  public void calcMinus() {
    calcPageObject.doClear();
    calcPageObject.get1().click();
    calcPageObject.get0().click();
    calcPageObject.getMinus().click();
    calcPageObject.get8().click();
    String rslt = calcPageObject.getResults("2");
    assertEquals("10-8=2","2",rslt);

  }

  @Test
  public void calcMult() {
    calcPageObject.doClear();
    calcPageObject.getBtnParanL().click();
    calcPageObject.get1().click();
    calcPageObject.get0().click();
    calcPageObject.getMinus().click();
    calcPageObject.get2().click();
    calcPageObject.getBtnParanR().click();
    calcPageObject.getMult().click();
    calcPageObject.get2().click();
    String rslt = calcPageObject.getResults("16");
    assertNotEquals("(10-2)*2!=20","20");

  }

  @Test
  public void calcSin(){
    calcPageObject.doClear();
    calcPageObject.getBtnSin().click();
    calcPageObject.get3().click();
    calcPageObject.get0().click();
    calcPageObject.getBtnParanR().click();
    String rslt = calcPageObject.getResults("0.5");
    assertEquals("Sin(30)=0.5","0.5",rslt);
  }


  @Test
  public void checkHistory(){
    assertEquals("History items: ",4, calcPageObject.getHistory().size());
  }

}
