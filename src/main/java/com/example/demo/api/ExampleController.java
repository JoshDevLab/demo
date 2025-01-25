package com.example.demo.api;

import com.example.demo.api.request.ExampleRequestDto;
import com.example.demo.api.response.ExampleResponseDto;
import com.example.demo.domain.ExampleData;
import com.example.demo.domain.ExampleResult;
import com.example.demo.domain.ExampleService;
import com.example.demo.support.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {

    private final ExampleService exampleExampleService;

    public ExampleController(ExampleService exampleExampleService) {
        this.exampleExampleService = exampleExampleService;
    }

    @GetMapping("/get/{exampleValue}")
    public ApiResponse<ExampleResponseDto> exampleGet(@PathVariable String exampleValue, @RequestParam String exampleParam) {
        ExampleResult result = exampleExampleService.processExample(new ExampleData(exampleValue, exampleParam));
        return ApiResponse.success(new ExampleResponseDto(result.data()));
    }

    @PostMapping("/post")
    public ApiResponse<ExampleResponseDto> examplePost(@RequestBody ExampleRequestDto request) {
        ExampleResult result = exampleExampleService.processExample(request.toExampleData());
        return ApiResponse.success(new ExampleResponseDto(result.data()));
    }

}
