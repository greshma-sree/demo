import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Valid_Invalid_User_Parameterization {
    WebDriver driver = null;
    @DataProvider(name="data-set")
    public static Object[][] DataSet() {
        Object[][] obj = {
                {"valid", "standard_user", "secret_sauce"},
                {"Invalid", "locked_out_user", "secret_sauce"},
                {"valid", "problem_user", "secret_sauce"},
                {"valid", "performance_glitch_user", "secret_sauce"},
                {"Invalid", "Problem_out_user", "Greshma@1234"}
        };
        return obj;
    }

    @BeforeMethod
    public void setUp() {
        //System.out.println("\n\n \t Iam inside setUp method");
        String ChromeDriverPath="C:\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
        driver=new ChromeDriver();
        System.getProperty("webdriver.chrome.driver",ChromeDriverPath);
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

    @Test(dataProvider = "data-set")
    public void search(String type, String username, String password) {
        System.out.println("type=" + type + " " + "username= " + username + " " + "password=" + password);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
       // WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(3));
        if (type.equals("valid")) {
            System.out.println("login successfully");
        } else {
            System.out.println("Invalid login");
        }


    }
}
