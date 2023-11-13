package tests.restassured;

import dto.AddNewCarDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class DeleteCarTests extends BaseTest{

    // SN-022207560

    @Test
    public void deleteCarTest() {
        String serNumber = "AS-" + RandomUtils.generateStringDigits(11);
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
       // Assert.assertEquals(carsApi.getStatusCodeCreateNewCar(addNewCar, token), 200);
        Assert.assertEquals(carsApi.getStatusCodeDeleteOneCarBySerNum(serNumber, token), 200);
    }
}
