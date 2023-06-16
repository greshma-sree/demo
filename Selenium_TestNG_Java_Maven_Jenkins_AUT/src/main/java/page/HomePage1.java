package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage1 {
    WebDriver driver=null;
    public HomePage1(WebDriver driver) {
        this.driver = driver;
    }
    public void setSearchText(String value){
        String Loc="//input[@id='searchbox']";
        WebElement ele=this.driver.findElement(By.xpath(Loc));
        ele.sendKeys(value);
    }
    public void clickSearchButton(){
        String Loc="//input[@id='searchsubmit']";
        WebElement ele=this.driver.findElement(By.xpath(Loc));
        ele.click();
    }
    public String getH1Haeding(){
        String Loc="//section[@id='main']/h1";
        WebElement ele=this.driver.findElement(By.xpath(Loc));
        return ele.getText();
    }
}
