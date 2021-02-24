import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    static WebElement enterBtn;
    static WebElement signUpRef;
    static WebElement zipCodeFld;
    static WebElement contunieBtn;
    static WebElement nameBtn;
    static WebElement lastNameBtn;
    static WebElement emailBtn;
    static WebElement passwordBtn;
    static WebElement confirmPasswordBtn;
    static WebElement register;
    static WebElement creationMessage;

    static String success = "Account is created!";

    public static void main (String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\chromdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.sharelane.com/");


        enterBtn = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[20]/td/p/a/b"));
        clickEnterBtn();

        signUpRef = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[4]/a"));
        clickSignUpLink();

        enterZipCode(driver);

        setUpMainPage(driver);
        enterMainData();

        Thread.sleep(8000);

        creationMessage = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td/span"));
        Assert.assertTrue(checkThatConfirmationMessageAppears());

        tearDown(driver);
    }

    public static void enterZipCode(WebDriver driver) {
        zipCodeFld = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input"));
        contunieBtn = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input"));

        sendKeysZipCodeFld("11111");
        clickContinueBtn();
    }

    public static void enterMainData() {
        enterName("ssss");
        enterLastName("wwww");
        enterEmail("eeee@example.com");
        enterPassword("1111");
        enterConfirmPassword("1111");
        clickRegisterBtn();
    }

    public static boolean checkThatConfirmationMessageAppears() {
        String textConfirmationMessage = getTextConfirmationMessage();
        boolean equals = success.equals(textConfirmationMessage);
        return equals;
    }

    private static void setUpMainPage(WebDriver driver) {
        nameBtn = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input"));
        lastNameBtn = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/input"));
        emailBtn = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input"));
        passwordBtn = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input"));
        confirmPasswordBtn = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/input"));
        register = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input"));
    }

    public static void tearDown(WebDriver driver) throws Exception {
        driver.quit();
    }

    public static void clickSignUpLink() {
        signUpRef.click();
    }
    public static void clickEnterBtn() {
        enterBtn.click();
    }
    public static void sendKeysZipCodeFld(String k) {
        zipCodeFld.sendKeys(k);
    }
    public static  void clickContinueBtn() {
        contunieBtn.click();
    }
    public static void enterName(String k) {
        nameBtn.sendKeys(k);
    }
    public static void enterLastName(String k) {
        lastNameBtn.sendKeys(k);
    }
    public static void enterEmail(String k) {
        emailBtn.sendKeys(k);
    }
    public static void enterPassword(String k) {
        passwordBtn.sendKeys(k);
    }
    public static void enterConfirmPassword(String k) {
        confirmPasswordBtn.sendKeys(k);
    }
    public static void clickRegisterBtn() {
        register.click();
    }
    public static String getTextConfirmationMessage() {
        return creationMessage.getText();
    }
}
