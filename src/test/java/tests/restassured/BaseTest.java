package tests.restassured;

import api.CarsApi;
import api.UserNamePasswordApi;
import dto.UserDto;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    String token = "";
    UserNamePasswordApi userNamePassword = new UserNamePasswordApi();
    CarsApi carsApi  = new CarsApi();

    UserDto user = UserDto.builder()
            .username("testqa20@gmail.com")
            .password("123456Aa$")
            .build();

    @BeforeSuite(alwaysRun = true)
    public void getToken() {
        token = userNamePassword.getToken(user);
        System.out.println(token);
    }
}
