import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;
public class CreateUser_Parameterization {

    WebDriver driver = null;

    @DataProvider(name = "data-set")
    public static Object[][] DataSet() {
        Object[][] obj = {
                {"asr7780749210@gmail.com", "", "Renu@1234"},
                {"milkah@gmail.com", "", "Radha@1234"},
                {"greshmasrikandapu@gmail.com", "", "Greshma@789"}
        };
        return obj;
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        String ChromeDriverPath="C:\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
        driver=new ChromeDriver();
        System.getProperty("webdriver.chrome.driver",ChromeDriverPath);
        driver.get("https://login.mailchimp.com/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        Thread.sleep(2000);

        String signUpUrl = "https://login.mailchimp.com/signup/";
        driver.get(signUpUrl);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        System.out.println("created new account successfully");
    }

    @Test(dataProvider = "data-set")
    public void search(String email, String username, String password) {
        // WebDriver driver = null;
        driver.findElement(xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(xpath("//input[@id='new_username']")).sendKeys(username);
        driver.findElement(xpath("//input[@id='new_password']")).sendKeys(password);

        driver.findElement(By.xpath("//*[@id='create-account-enabled']")).click();
    }
}