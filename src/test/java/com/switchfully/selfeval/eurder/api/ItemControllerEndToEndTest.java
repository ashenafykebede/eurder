package com.switchfully.selfeval.eurder.api;

import com.switchfully.selfeval.eurder.api.dto.item.CreateItemDTO;
import com.switchfully.selfeval.eurder.api.dto.item.ItemDTO;
import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import com.switchfully.selfeval.eurder.service.item.ItemMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerEndToEndTest {
    @LocalServerPort
    private int randomPort;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemMapper itemMapper;

    @Test
    void whenAnItemExistsInTheRepository_thenICanGetTheItemById() {
        Item newItem = new Item("LG TV","4K TV",499.99,25);
        itemRepository.save(newItem);
        Item item = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .port(randomPort)
                .get("/items/"+newItem.getItemId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(Item.class);
        Assertions.assertEquals(newItem,item);
    }

    @Test
    void whenAnItemDoesNotExistInDatabase_thenGetItemByIdReturns404() {
        RestAssured
                //given
                .given()
                .contentType(ContentType.JSON)
                //when
                .when()
                .port(randomPort)
                .get("/items/2")
                //then
                .then()
                .assertThat()
                .statusCode(HttpStatus.NOT_FOUND.value());

    }
    @Test
    void whenIPostAnItem_thenTheItemDatabaseContainsThisItem() {
        CreateItemDTO newItemDTO = new CreateItemDTO("T-shirt","Nice gray t-shirt",25.99,50);
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(newItemDTO)
                .log().all()
                .when()
                .port(randomPort)
                .post("/admin/items")
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value());

        Assertions.assertTrue(itemRepository.getAllItems().contains(itemMapper.toDomain(newItemDTO)));
    }
}