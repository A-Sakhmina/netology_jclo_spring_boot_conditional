package ru.netology.sakhmina.springbootapplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Container
    private final GenericContainer<?> devApp = new GenericContainer<>("devapp:latest").withExposedPorts(8080);
    @Container
    private final GenericContainer<?> proApp = new GenericContainer<>("prodapp:latest").withExposedPorts(8081);

    @Autowired
    TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        devApp.start();
        proApp.start();
    }

    @Test
    void devContextLoads() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devApp.getMappedPort(8080) + "/profile", String.class);
        System.out.println(forEntity.getBody());
        Assertions.assertEquals("Current profile is dev", forEntity.getBody());
    }

    @Test
    void proContextLoads() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + proApp.getMappedPort(8081) + "/profile", String.class);
        System.out.println(forEntity.getBody());
        Assertions.assertEquals("Current profile is production", forEntity.getBody());
    }

}