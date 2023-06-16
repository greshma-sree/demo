import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Restassured {
    @Test
    void test1()
    {
        Response response = get("https://regres.in/api/users?page=2");
        System.out.println("Status code "+ response.getStatusCode());
        System.out.println("Response "+ response.getStatusCode());
        System.out.println("Body"+response.getBody().asString());
        System.out.println("Time Taken"+ response.getTime());
        System.out.println("Header"+response.getHeader("content-Type"));
        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode,403);
    }
    @Test
    void test2()
    {
        given().get("https://regres.in/api/users?page=2").then().statusCode(403);
    }


}
