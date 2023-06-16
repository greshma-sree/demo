import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.HomePage1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

public class Demo {
    WebDriver driver=null;
    @BeforeMethod
    public void setUp() throws IOException, ParseException {
        String ChromeDriverPath="C:\\software\\selenium\\chromedriver_win32\\chromedriver.exe";
        String loginDataPath="src/main/resources/LoginData.json";
        driver= new ChromeDriver();
        System.getProperty("webdriver.chrome.driver",ChromeDriverPath);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        System.out.println(driver.getTitle());
        FileReader fr =new FileReader(loginDataPath);
        JSONParser parser=new JSONParser();
        Object obj =parser.parse(fr);
        JSONObject jsonObject=(JSONObject)obj;
        String url = (String)jsonObject.get("url");
        System.out.println(url);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void search() throws IOException, ParseException, InterruptedException {

        String LoginDataPath = "src/main/resources/SearchData1.json";
        FileReader fr =new FileReader(LoginDataPath);
        JSONParser parser=new JSONParser();
        Object obj =parser.parse(fr);
        JSONObject jsonObject=(JSONObject)obj;
        JSONObject tc=(JSONObject) jsonObject.get("tc01");
        String searchText= (String) tc.get("searchText");
        System.out.println(searchText);
        String expectedmsg="Computers found";
        HomePage1 hp=new HomePage1(driver);
        hp.setSearchText(searchText);
        hp.clickSearchButton();
        Thread.sleep(5000);
        String actualMessage=hp.getH1Haeding();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actualMessage).contains(expectedmsg);
        String[] arrMessage=actualMessage.split(" ");
        int numberofComputers=parseInt(arrMessage[0]);
        softly.assertThat(numberofComputers).isGreaterThanOrEqualTo(1);
        assertThat(numberofComputers).isGreaterThanOrEqualTo(100);
    }
    @Test
    public void search1() throws IOException, ParseException, InterruptedException {

        String LoginDataPath = "src/main/resources/SearchData.json";
        FileReader fr =new FileReader(LoginDataPath);
        JSONParser parser=new JSONParser();
        Object obj =parser.parse(fr);
        JSONObject jsonObject=(JSONObject)obj;
        JSONObject tc=(JSONObject) jsonObject.get("tc02");
        String searchText= (String) tc.get("searchText");
        System.out.println(searchText);
        String expectedmsg="Computers found";
        HomePage1 hp=new HomePage1(driver);
        hp.setSearchText(searchText);
        hp.clickSearchButton();
        Thread.sleep(5000);
        String actualMessage=hp.getH1Haeding();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actualMessage).contains(expectedmsg);
        String[] arrMessage=actualMessage.split(" ");
        int numberofComputers=parseInt(arrMessage[0]);
        assertThat(numberofComputers).isGreaterThanOrEqualTo(100);
    }
}
