package com.simbirsoft.user.controller;

import com.simbirsoft.user.feignclient.PerformerClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
@Tag(name = "Hi from performer", description = "Get hi")
public class PerformerController {
    private final PerformerClient performerClient;

    @Operation(summary = "Get hi from performer")
    @GetMapping
    public String helloFromPerformer() {
        return performerClient.performerHello();
    }
}
