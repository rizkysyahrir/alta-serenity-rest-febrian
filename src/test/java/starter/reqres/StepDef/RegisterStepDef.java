package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Register user with valid json")
    public void registerUserWithValidJson(){
        File json = new File(Constant.JSON_REQUEST+"/RegisUser.json");
        reqresAPI.postRegisUser(json);
    }

    @When("Send request post register user")
    public void sendRequestRegisterUser(){
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("Response body id should be {int} and token {string}")
    public void responseBodyIdShouldBeAndToken(int id, String token){
        SerenityRest.then()
                .body(ReqresResponses.ID_REG,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @Then("Validate json schema register user")
    public void validateJsonSchemaRegisUser(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/RegisUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    //create user
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/RequestUser.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post create user with invalid json")
    public void postCreateUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/InvalidRequestUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @And("Validate json schema create user")
    public void validateJsonSchemaCreateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/CreateUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Register user with invalid json")
    public void registerUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/RegisterUnsuccess.json");
        reqresAPI.postRegisUser(json);
    }

    @And("Validate json schema failed register user")
    public void validateJsonSchemaFailedRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterUnsuccessSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
