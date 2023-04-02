package com.switchfully.selfeval.eurder.api.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminController.class)
class AdminControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ItemRepository itemRepository;
    @Test
    void givenAValidInput_thenTheControllerListensToThePostHttpRequest_andReturnsStatusIsCreated_201() throws Exception {
        Item item = new Item("Samsung A54", "new GSM", 599.99, 35);
        mockMvc.perform(post("/admin/items")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(item))) //if you provide null instead of item, test fails
                .andExpect(status().isCreated());
    }

}