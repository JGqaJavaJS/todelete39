package api;

import com.jayway.restassured.response.Response;
import dto.AuthResponseDto;
import dto.UserDto;
import static com.jayway.restassured.RestAssured.given;

public class UserNamePasswordApi extends BaseApi {

    Response responseLoginRequest = null;

    private Response loginRequest(UserDto user) {
        return given().body(user)
                .when()
                .post(baseUrl + "/v1/user/login/usernamepassword").thenReturn();
    }

    public int getStatusCodeResponseLoginRequest(UserDto user) {
//        int counter = 5;
//        while(counter > 0 || responseLoginRequest == null) {
//            System.out.println(counter);
//
//            responseLoginRequest = loginRequest(user);
//         //   System.out.println(responseLoginRequest.getStatusCode());
//            counter --;
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        if(responseLoginRequest == null) {
           responseLoginRequest = loginRequest(user);
        }
        return responseLoginRequest.getStatusCode();
   //     return loginRequest(user).getStatusCode();
    }

    public void setResponseLoginRequestNull() {
        responseLoginRequest = null;
    }

    public String getToken(UserDto user) {
        if(responseLoginRequest == null) {
            responseLoginRequest = loginRequest(user);
        }
        return responseLoginRequest.getBody().as(AuthResponseDto.class).getAccessToken();
    }
}
