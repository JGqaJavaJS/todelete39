package api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import dto.AddNewCarDto;

import static com.jayway.restassured.RestAssured.given;

public class CarsApi extends BaseApi{

    Response responseCreateNewCar = null;
    Response responseDeleteOneCarBySerNum = null;

    private Response addNewCarRequest(AddNewCarDto addNewCarDto, String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(addNewCarDto)
                .when()
                .post(baseUrl + "/v1/cars").thenReturn();
    }

    private Response deleteOneCarBySerNum(String serNum, String token) {
        responseDeleteOneCarBySerNum =
                given()  /// add link url
                        .header("Authorization", token)
                        .when()
                        .delete(baseUrl + "/v1/cars/" + serNum).thenReturn();
        return responseDeleteOneCarBySerNum;
    }

    public int getStatusCodeDeleteOneCarBySerNum(String serNum, String token) {
        if(responseDeleteOneCarBySerNum == null) {
            responseDeleteOneCarBySerNum = deleteOneCarBySerNum(serNum, token);
        }
        return responseDeleteOneCarBySerNum.getStatusCode();
    }

    public void setStatusCodeDeleteOneCarBySerNum() {
        responseDeleteOneCarBySerNum = null;
    }

    public int getStatusCodeCreateNewCar(AddNewCarDto addNewCarDto, String token) {
        if(responseCreateNewCar == null) {
            responseCreateNewCar = addNewCarRequest(addNewCarDto, token);
        }
           return responseCreateNewCar.getStatusCode();
    }

    public void setResponseCreateNewCarNull() {
        responseCreateNewCar = null;
    }
}
