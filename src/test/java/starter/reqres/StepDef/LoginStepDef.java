package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login user with valid json")
    public void loginUserWithValidJson(){
        File json = new File(Constant.JSON_REQUEST+"/LoginUser.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestLoginUser(){
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token){
        SerenityRest.then()
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String error){
        SerenityRest.then()
                .body(ReqresResponses.ERROR, CoreMatchers.equalTo(error));
    }

    @And("Validate json schema login user")
    public void validateJsonSchemaLoginUser(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/LoginSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post login user with invalid json")
    public void loginUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/InvalidLoginUser.json");
        reqresAPI.postLoginUser(json);
    }

    @And("Validate json schema invalid login user")
    public void validateJsonSchemaFailedLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginSchemaUnsuccess.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post login user without pass invalid json")
    public void loginUserWoPassInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/InvalidLoginWoPass.json");
        reqresAPI.postLoginUser(json);
    }

    @And("Validate json schema login unsuccessfully")
    public void validateJsonSchemaUnsuccessLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginUnsuccesSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Then("Should return status code bad request {int}")
    public void ShouldReturnStatusCode(int badRequest){
        SerenityRest.then().statusCode(badRequest);
    }

}
