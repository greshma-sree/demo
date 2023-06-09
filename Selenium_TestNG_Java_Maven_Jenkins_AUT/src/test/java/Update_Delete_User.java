import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class Update_Delete_User {

    public static void main(String[] args) throws InterruptedException {
        String ChromeDriverPath="C:\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
        WebDriver driver=new ChromeDriver();
        System.getProperty("webdriver.chrome.driver",ChromeDriverPath);
        driver.get("https://computer-database.gatling.io/");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);


        String locator_addcomputerbutton = "//a[@id='add']";     //xpath of that button

        WebElement eleAddComputerButton = driver.findElement(By.xpath(locator_addcomputerbutton)); //finding that button
        eleAddComputerButton.click();  //perform clicking
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("demo1");
        driver.findElement(By.xpath("//input[@id='introduced']")).sendKeys("2023-05-22");
        driver.findElement(By.xpath("//input[@id='discontinued']")).sendKeys("2024-01-26");
        driver.findElement(By.xpath("//input[@value='Create this computer']")).click();
        Thread.sleep(5000);
        System.out.println("Computer created successfully");
        driver.get("http://computer-database.gatling.io/computers/381");
        driver.findElement(By.xpath("//input[@value=\"Delete this computer\"]")).click();
        Thread.sleep(1000);
        System.out.println("deleted the computer successfully");
        driver.quit();


    }
}