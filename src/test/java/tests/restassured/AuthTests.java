package tests.restassured;

import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest{

    @Test
    public void PositiveLoginStatusCode() {
        Assert.assertEquals(userNamePassword.getStatusCodeResponseLoginRequest(user), 200);
    }
}
