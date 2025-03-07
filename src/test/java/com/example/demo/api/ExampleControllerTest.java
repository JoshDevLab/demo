package com.example.demo.api;


import com.example.demo.api.request.ExampleRequestDto;
import com.example.demo.domain.ExampleResult;
import com.example.demo.domain.ExampleService;
import com.example.demo.support.RestDocsTestSupport;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.restdocs.payload.JsonFieldType;

import static com.example.demo.support.RestDocsUtils.requestPreprocessor;
import static com.example.demo.support.RestDocsUtils.responsePreprocessor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;

class ExampleControllerTest extends RestDocsTestSupport {

    private ExampleService exampleService;

    private ExampleController controller;

    @BeforeEach
    public void setUp() {
        exampleService = mock(ExampleService.class);
        controller = new ExampleController(exampleService);
        mockMvc = mockController(controller);
    }

    @Test
    public void exampleGet() {
        when(exampleService.processExample(any())).thenReturn(new ExampleResult("BYE"));

        given().contentType(ContentType.JSON)
                .queryParam("exampleParam", "HELLO_PARAM")
                .get("/get/{exampleValue}", "HELLO_PATH")
                .then()
                .status(HttpStatus.OK)
                .apply(document("exampleGet", requestPreprocessor(), responsePreprocessor(),
                        pathParameters(parameterWithName("exampleValue").description("ExampleValue")),
                        queryParameters(parameterWithName("exampleParam").description("ExampleParam")),
                        responseFields(fieldWithPath("result").type(JsonFieldType.STRING).description("ResultType"),
                                fieldWithPath("data.result").type(JsonFieldType.STRING).description("Result Date"),
                                fieldWithPath("error").type(JsonFieldType.NULL).ignored())));
    }

    @Test
    public void examplePost() {
        when(exampleService.processExample(any())).thenReturn(new ExampleResult("BYE"));

        given().contentType(ContentType.JSON)
                .body(new ExampleRequestDto("HELLO_BODY"))
                .post("/post")
                .then()
                .status(HttpStatus.OK)
                .apply(document("examplePost", requestPreprocessor(), responsePreprocessor(),
                        requestFields(
                                fieldWithPath("data").type(JsonFieldType.STRING).description("ExampleBody Data Field")),
                        responseFields(fieldWithPath("result").type(JsonFieldType.STRING).description("ResultType"),
                                fieldWithPath("data.result").type(JsonFieldType.STRING).description("Result Date"),
                                fieldWithPath("error").type(JsonFieldType.STRING).ignored())));
    }

}