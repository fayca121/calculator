package dz.bououza;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CalculatorResourceTest {

    @Test
    public void testSumEndpoint() {
        given()
                .when().get("/calculator/sum?a=2&b=3")
                .then()
                .statusCode(200)
                .body(is("5"));
    }

}