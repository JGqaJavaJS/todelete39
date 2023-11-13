package tests.restassured;

import dto.AddNewCarDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class AddCarTests extends BaseTest {

    // {
    //  "serialNumber": "1234578983",
    //  "manufacture": "opel",
    //  "model": "corsa",
    //  "year": 1990,
    //  "fuel": "Petrol",
    //  "seats": 2,
    //  "carClass": "1",
    //  "pricePerDay": 7,
    //  "about": "abc",
    //  "city": "Tel Aviv"
    //}
String serNumber = RandomUtils.generateStringDigits(11);
    AddNewCarDto addNewCar = AddNewCarDto.builder()
            .serialNumber(serNumber)
            .manufacture("qa39")
            .model("corsa")
            .year(1990)
            .fuel("Petrol")
            .seats(2)
            .carClass("ads")
            .pricePerDay(9)
            .about("fff")
            .city("Tel Aviv")
            .build();

    @Test
    public void statusCodeAddNewCar() {
        Assert.assertEquals(carsApi.getStatusCodeCreateNewCar(addNewCar, token), 200);
    }



//    @Test
//    public void experimentTest() {
//        UserDto user1 = UserDto.builder()
//                .username("testqa20@gmail.com")
//                .password("123456Aa$")
//                .build();
//        String token1 = userNamePassword.getToken(user1);
//
//        // then todo test with especial user
//    }
}
