package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;
//
//    //Scenario 1
//    @Given("Get list user with page {int}")
//    public void getListUserWithPage(int page){
//        reqresAPI.getListUsers(page);
//    }
//
//    @When("Send request get list user")
//    public void sendRequestGetListUser(){
//        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
//    }
//
    @Then("Should return status code {int}")
    public void ShouldReturnStatusCode(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }
//
//    @And("Response body page should be {int}")
//    public void responseBodyPageShouldBe(int page){
//        SerenityRest.then().body("page", equalTo(page));
//    }

    //Scenario 2
//
//    @Given("Post create user with valid json")
//    public void postCreateUserWithValidJson(){
//        File json = new File(Constant.JSON_REQUEST+"/RequestUser.json");
//        reqresAPI.postCreateUser(json);
//    }

//    @When("Send request post create user")
//    public void sendRequestPostCreateUser(){
//        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
//    }

//    @And("Response body name should be {string} and job {string}")
//    public void responseBodyNameShouldBeAndJob(String name, String job){
//        SerenityRest.then()
//                .body("name", equalTo(name))
//                .body("job", equalTo(job));
//    }

    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id){
        File json = new File(Constant.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser(){
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

   }
