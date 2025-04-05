package lt.vilniustech.dgrigorovic.pirmas.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllOrderTest() {
        ResponseEntity<List> response = this.restTemplate.getForEntity("/orders", List.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(2, response.getBody().size());

        /*HashMap<String, Object> customerMap = (HashMap<String, Object>) response.getBody().get(0);
        Assertions.assertEquals(1, customerMap.get("id"));
        Assertions.assertEquals("2025-02-25", customerMap.get("orderDate"));
        Assertions.assertEquals("10.25", customerMap.get("totalAmount"));*/
    }
}