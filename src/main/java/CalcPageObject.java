import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalcPageObject {
  private final WebDriver driver;
  private static final By acceptButton = By.className("btn-info");
  private static final By BtnClear = By.id("BtnClear");
  private static final By Btn0 = By.id("Btn0");
  private static final By Btn1 = By.id("Btn1");
  private static final By Btn2 = By.id("Btn2");
  private static final By Btn3 = By.id("Btn3");
  private static final By Btn4 = By.id("Btn4");
  private static final By Btn5 = By.id("Btn5");
  private static final By Btn6 = By.id("Btn6");
  private static final By Btn7 = By.id("Btn7");
  private static final By Btn8 = By.id("Btn8");
  private static final By Btn9 = By.id("Btn9");
  private static final By BtnParanL = By.id("BtnParanL");
  private static final By BtnParanR = By.id("BtnParanR");
  private static final By BtnPlus = By.id("BtnPlus");
  private static final By BtnMinus = By.id("BtnMinus");
  private static final By BtnCalc = By.id("BtnCalc");
  private static final By BtnMult = By.id("BtnMult");
  private static final By BtnSin = By.id("BtnSin");
  private static final By Input = By.id("input");

  private static final By localHistory = By.xpath("//*[@id='histframe']");

  public List<WebElement> getHistory(){
    return driver.findElement(localHistory).findElements(By.tagName("li"));
  }
  public CalcPageObject(WebDriver driver){
    this.driver = driver;
  }

  public void doClear(){
   driver.findElement(BtnClear).click();
  }
  public WebElement getBtnParanL(){
    return driver.findElement(BtnParanL);
  }
  public WebElement getBtnParanR(){
    return driver.findElement(BtnParanR);
  }
  public WebElement getBtnSin(){
    return driver.findElement(BtnSin);
  }
  public WebElement get0(){
    return driver.findElement(Btn0);
  }
  public WebElement get1(){
    return driver.findElement(Btn1);
  }
  public WebElement get2(){
    return driver.findElement(Btn2);
  }
  public WebElement get3(){
    return driver.findElement(Btn3);
  }
  public WebElement get4(){
    return driver.findElement(Btn3);
  }
  public WebElement get5(){
    return driver.findElement(Btn3);
  }
  public WebElement get6(){
    return driver.findElement(Btn3);
  }
  public WebElement get7(){
    return driver.findElement(Btn3);
  }
  public WebElement get8(){
    return driver.findElement(Btn8);
  }
  public WebElement get9(){
    return driver.findElement(Btn3);
  }
  public WebElement getPlus(){
    return driver.findElement(BtnPlus);
  }
  public WebElement getMult(){
    return driver.findElement(BtnMult);
  }
  public WebElement getMinus(){
    return driver.findElement(BtnMinus);
  }
  public String getResults(String expected){
    driver.findElement(BtnCalc).click();
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.attributeContains(By.id("input"),"value", expected));
    return driver.findElement(Input).getAttribute("value");
  }
  public void click_accept_cookies() {
    WebElement acceptButtonElement = driver.findElement(acceptButton);
    acceptButtonElement.click();
  }

}
