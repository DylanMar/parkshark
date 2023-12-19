package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.MemberDto;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static io.restassured.http.ContentType.JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@Sql("/data.sql")
public class MemberControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Test
    void givenEmailAndPassword_whenGetAllMembers_thenGetAllMembers(){
        //GIVEN
        String email = "admin@parkshark.com";
        String password = "admin";

        //WHEN
        List<MemberDto> actual =
                RestAssured
                        .given()
                        .contentType(JSON)
                        .header("email", email)
                        .header("password", password)
                        .when()
                        .port(port)
                        .get("/members")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract()
                        .body()
                        .jsonPath()
                        .getList(".", MemberDto.class);
        //THEN
        Assertions.assertThat(actual).hasSize(0);
    }
}
