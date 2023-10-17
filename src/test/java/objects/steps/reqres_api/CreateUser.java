package objects.steps.reqres_api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.steps.request_respone_api.ResponseAllTests;

import static objects.steps.reqres_api.UpdateJsonObject.getJsonObjectToString;
import static objects.steps.request_respone_api.RequestSpecificationAllTests.requestSpecificationAllTests;
import static org.hamcrest.Matchers.equalTo;
import static util.Config.getConfigValue;


public class CreateUser extends ResponseAllTests {

    @Step("Создание пользователя с именем: \"{nameValue}\", и job: \"{jobValue}\"")
    public static void createUser(String keyUrl, String nameValue, String jobValue,  String endpoint, String method, String statusCode, String pathSchema) {

        String url = getConfigValue(keyUrl);

        RequestSpecification request = requestSpecificationAllTests(url);

        String body = getJsonObjectToString();

        Response response = responseGet(request, body, endpoint, method, statusCode, pathSchema);

        response
                .then()
                .assertThat()
                .body("name", equalTo(nameValue))
                .body("job", equalTo(jobValue));

    }
}
