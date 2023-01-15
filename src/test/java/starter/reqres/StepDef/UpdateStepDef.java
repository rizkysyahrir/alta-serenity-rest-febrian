package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("PUT update user with valid json with id {int}")
    public void updateUserWithValidJsonWithId(int id){
        File json = new File(Constant.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request PUT update user")
    public void sendRequestUpdateUser(){
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job){
        SerenityRest.then()
                .body("name", equalTo(name))
                .body("job", equalTo(job));
    }

    //Scenario 2
    @Given("PATCH update user with valid json with id {int}")
    public void patchUpdateUserWithValidJsonWithId(int id){
        File json = new File(Constant.JSON_REQUEST+"/PatchUpdateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request PATCH update user")
    public void sendRequestPatchUpdateUser(){
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

}
