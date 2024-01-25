package com.simbirsoft.user.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "${performer-app-name}", url = "${performer-url}")
public interface PerformerClient {
    @GetMapping("/performer/hi")
    String performerHello();
}
