package api.Support;

import api.UrlsApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class ApiSupport {

    public static String convertJavaObjectToJson(Object object){

        String json;

        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return json;
    }

    public static String createToken(){
        RequestSpecification request;
        Response response;
        RestAssured.baseURI = UrlsApi.BASE_URL + UrlsApi.AUTH_ENDPOINT;
        request = RestAssured.given().filter(new AllureRestAssured());
        request.header("Content-Type", "application/json");
        request.body("{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}");
        response = request.post();
        Assert.assertEquals(response.getStatusCode(), 200);
        return response.getBody().jsonPath().get("token");
    }

}
