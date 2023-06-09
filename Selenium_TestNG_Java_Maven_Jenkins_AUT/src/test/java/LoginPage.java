import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver = null;
    @DataProvider(name = "data-set")
    public static Object[][] searchCriteria() {
        return new Object[][] {{"Valid","standard_user","secret_sauce"},{"Invalid","Greshma","12234"}};
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
        //System.out.println("Iam in tearDown method");
        Thread.sleep(10000);
        driver.quit();
    }

    @Test(dataProvider = "data-set")
    public void search(String type,String username, String password) {
        System.out.println("type=" + type +" "+"username= " + username + " " + "password=" + password);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        if (type.equals("valid")) {
            System.out.println("login successfully");
        }
        else
        {
            System.out.println("Invalid login");
        }
    }
}
