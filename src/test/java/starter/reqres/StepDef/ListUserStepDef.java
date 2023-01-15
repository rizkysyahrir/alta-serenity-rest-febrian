package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with page {int}")
    public void getListUserWithPage(int page){
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser(){
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page){
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate json schema list user")
    public void validateJsonSchemaListUser(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/ListUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list user with invalid page {string}")
    public void getListUserWithPage(String page) {
        reqresAPI.getListUsers(page);
    }


    //Scenario2

    @Given("Get single user with id {int}")
    public void getSingleUserWithId(int id){
        reqresAPI.getSingleUserId(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser(){
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id){
        SerenityRest.then().body(ReqresResponses.ID_REG, equalTo(id));
    }

    @And("Validate json schema single user not found")
    public void validateJsonSchemaSingleUserNf(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/SingleUserNFSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 3
    @And("Validate json schema single user")
    public void validateJsonSchemaSingleUser(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/SingleUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
