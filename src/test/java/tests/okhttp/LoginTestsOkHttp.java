package tests.okhttp;

import com.google.gson.Gson;
import dto.AuthResponseDto;
import dto.UserDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestsOkHttp {

    public static final MediaType JSON = MediaType.get("application/json");
    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();
    String baseUrl = "https://ilcarro-backend.herokuapp.com";

    @Test
    public void login() {
        UserDto user = UserDto.builder()
                .username("testqa20@gmail.com")
                .password("123456Aa$")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(user), JSON);

        Request request = new Request.Builder()
                .url(baseUrl + "/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();
        Response response;
        try {
            response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(response == null) {
            Assert.fail("got null response");
        } else if (response.isSuccessful()) {
            String responseJson;
            try {
                responseJson = response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            AuthResponseDto authResponseDto = gson.fromJson(responseJson, AuthResponseDto.class);
            System.out.println(authResponseDto.getAccessToken());
            System.out.println(response.code());
            System.out.println(response.message());
            Assert.assertEquals(response.code(), 200, "response code not 200");
        } else {
            System.out.println(response.code());
            Assert.fail("response not successfully");
        }
    }
}
