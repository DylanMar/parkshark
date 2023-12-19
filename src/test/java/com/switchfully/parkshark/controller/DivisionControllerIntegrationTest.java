package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.DivisionDto;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@Sql("/data.sql")
class DivisionControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Test
    void whenAdminLogin_whenGetAllMembers_thenGetAllMembers() {
        // GIVEN
        String email = "admin@parkshark.com";
        String password = "admin";

        //WHEN
        List<DivisionDto> actual =
                RestAssured
                        .given()
                        .contentType(JSON)
                        .header("email", email)
                        .header("password", password)
                        .when()
                        .port(port)
                        .get("/division")
                        .then()
                        .assertThat()
//                        .statusCode(HttpStatus.OK.value())
                        .extract()
                        .body()
                        .jsonPath()
                        .getList(".", DivisionDto.class);
        //THEN
        assertThat(actual).isNotEmpty();
    }
}