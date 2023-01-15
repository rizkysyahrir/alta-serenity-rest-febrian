package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.Utils.Constant;

import java.io.File;

public class ReqresAPI {

    public static String LOGIN_USER = Constant.BASE_URL + "/api/login";//URL Post login

    public static String GET_LIST_USERS = Constant.BASE_URL + "/api/users?page={page}";//URL Get list users

    public static String GET_SINGLE_USER = Constant.BASE_URL + "/api/users/{id}";//URL Get single

    public static String POST_CREATE_USER = Constant.BASE_URL + "/api/users";//URL Post create users

    public static String REGISTER_USER = Constant.BASE_URL + "/api/register";//URL Register users

    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/api/users/{id}";//URL Put update users

    public static String PATCH_UPDATE_USER = Constant.BASE_URL + "/api/users/{id}";//URL Patch update users

    public static String DELETE_USER = Constant.BASE_URL + "/api/users/{id}";//URL Delete users

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get single user")
    public void getSingleUserId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get list user")
    public void getListUsers(String page) {
        SerenityRest.given()
                .pathParam("page", page)
                .get(GET_LIST_USERS);
    }

    @Step("Post create user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user")
    public void postRegisUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login user")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id", id);
    }
}
