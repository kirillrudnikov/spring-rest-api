//package com.society.backend;
//
//import com.society.backend.controller.RestApiController;
//import com.society.backend.model.User;
//import com.society.backend.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(RestApiController.class)
//class RestApiControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @Test
//    void fetchAllUsersTest() {
//
//        String url = "/api/users";
//
//    }
//
//    @Test
//    void fetchUserTest() throws Exception {
//
//        User user = User.builder()
//                .id(1L)
//                .firstname("Test")
//                .lastname("Testov")
//                .username("test.ik")
//                .email("api.test@society.com")
//                .build();
//
//        User user1 = User.builder()
//                .id(2L)
//                .firstname("Kirill")
//                .lastname("Rudnikov")
//                .username("flainsky")
//                .email("kirillrudnikov811@gmail.com")
//                .build();
//
//        User user2 = User.builder()
//                .id(3L)
//                .firstname("Test")
//                .lastname("Testov")
//                .username("test.ik")
//                .email("api.test@gmail.com")
//                .build();
//
//        String url = "/api/user/get/{id}";
//
//        when(userService.fetchUser(any(Long.class))).thenReturn(user);
//
//        // Execute
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/user/get/3")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(TestUtils.objectToJson(user))).andReturn();
//
//        // Verify Response Status Code
//        int status = result.getResponse().getStatus();
//        assertEquals(status, HttpStatus.OK.value(), "OK");
//
//        // verify that service method was called once
//        verify(userService).fetchUser(any(Long.class));
//
//        // Verify result User
//        User resultUser = TestUtils.jsonToObject(result.getResponse().getContentAsString(), User.class);
//        assertNotNull(resultUser);
//        assertEquals(user.getId(), resultUser.getId());
//        assertEquals(user.getFirstname(), resultUser.getFirstname());
//        assertEquals(user.getLastname(), resultUser.getLastname());
//        assertEquals(user.getUsername(), resultUser.getUsername());
//        assertEquals(user.getEmail(), resultUser.getEmail());
//    }
//
//    @Test
//    public void saveUserTest() throws Exception {
//
//        User user = User.builder()
//                .id(1L)
//                .firstname("Test")
//                .lastname("Testov")
//                .username("test.ik")
//                .email("api.test@society.com")
//                .build();
//
//        User user1 = User.builder()
//                .id(2L)
//                .firstname("Kirill")
//                .lastname("Rudnikov")
//                .username("flainsky")
//                .email("kirillrudnikov811@gmail.com")
//                .build();
//
//        User user2 = User.builder()
//                .id(3L)
//                .firstname("Test")
//                .lastname("Testov")
//                .username("test.ik")
//                .email("api.test@gmail.com")
//                .build();
//
//        String url = "/api/user/save";
//
//        when(userService.saveUser(any(User.class))).thenReturn(user1);
//
//        // Execute
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(TestUtils.objectToJson(user1))).andReturn();
//
//        // Verify Response Status Code
//        int status = result.getResponse().getStatus();
//        assertEquals(status, HttpStatus.CREATED.value(), "Created");
//
//        // verify that service method was called once
//        verify(userService).saveUser(any(User.class));
//
//        // Verify result User
//        User resultUser = TestUtils.jsonToObject(result.getResponse().getContentAsString(), User.class);
//        assertNotNull(resultUser);
//        assertEquals(user1.getId(), resultUser.getId());
//        assertEquals(user1.getFirstname(), resultUser.getFirstname());
//        assertEquals(user1.getLastname(), resultUser.getLastname());
//        assertEquals(user1.getUsername(), resultUser.getUsername());
//        assertEquals(user1.getEmail(), resultUser.getEmail());
//    }
//}