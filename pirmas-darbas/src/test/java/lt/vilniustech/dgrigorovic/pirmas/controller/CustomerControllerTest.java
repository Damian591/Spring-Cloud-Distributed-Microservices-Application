package lt.vilniustech.dgrigorovic.pirmas.controller;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllCustomersTest(){
        ResponseEntity<List> response
                =this.restTemplate.getForEntity("/customers", List.class);
        Assertions.assertEquals(HttpStatusCode.valueOf(200),response.getStatusCode());

        Assertions.assertEquals(3, response.getBody().size());
        HashMap customerMap = (LinkedHashMap)response.getBody().get(0);
        Assertions.assertEquals(1, customerMap.get("id"));
        Assertions.assertEquals("damian",
                customerMap.get("firstName"));
        Assertions.assertEquals("Sebastian",
                customerMap.get("lastName"));
        Assertions.assertEquals("Mr",
                customerMap.get("suffix"));
    }

}