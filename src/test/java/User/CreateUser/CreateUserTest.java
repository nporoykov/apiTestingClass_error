package User.CreateUser;


import dto.User;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserService;

import static org.hamcrest.Matchers.*;


public class CreateUserTest {

    UserService userService = new UserService();

    @Test
    public void checkCreateUser() {
        Response response;
        User user;
        String expectedEmail = "Test@mail.ru";
        String actualType;
        String type = "unknown";
        String errorMessageType = "Incorrect userName";
        String expectedType = "unknown";
        Long id = 101L;

      //  UserService userService = new UserService();

        user = User.builder()
                .email(expectedEmail)
                .firstName("FirstName")
                .id(id)
                .lastName("LastName")
                .password("Password")
                .phone("8-920-920-23-23")
                .username("Ivan")
                .userStatus(10L)
                .build();

        response = userService.addUserRequest(user);

        response
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(5000L))
                .body("type", equalTo(expectedType))
                .body("message", comparesEqualTo( id.toString()));
       // id.toString();


    }
}
