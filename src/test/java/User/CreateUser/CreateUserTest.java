package User.CreateUser;


import dto.User;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserService;

import static org.hamcrest.Matchers.*;



public class CreateUserTest {

    @Test
    public void checkCreateUser() {
        UserService userService = new UserService();
        Response response;
        User user;

        String expectedEmail = "1111@mail.ru";
        String actualType;
        String type = "unknown";
        String errorMessageType = "Incorrect userName";
        String expectedType = "unknown";
        Long id = 101L;

      //  UserService userService = new UserService();

        user = User.builder()
                .email(expectedEmail)
                .firstName("1111")
                .id(id)
                .lastName("1111")
                .password("1111")
                .phone("1111-1111-1111")
                .username("1111")
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


    @Test
    public void checkCreateUser2() {
        UserService userService = new UserService();
        Response response1;
        User user1;

        String expectedEmail = "2222@mail.ru";
        String actualType;
        String type = "unknown";
        String errorMessageType = "Incorrect userName";
        String expectedType = "unknown";
        Long id = 101L;

        //  UserService userService = new UserService();

        user1 = User.builder()
                .email(expectedEmail)
                .firstName("2222")
                .id(id)
                .lastName("2222")
                .password("2222")
                .phone("2222-2222-2222")
                .username("2222")
                .userStatus(10L)
                .build();

        response1 = userService.addUserRequest(user1);

        response1
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(5000L))
                .body("type", equalTo(expectedType))
                .body("message", comparesEqualTo( id.toString()));
        // id.toString();


    }

}
