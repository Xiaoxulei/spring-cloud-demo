package com.xuxiaolei.openai.feign;

import com.xuxiaolei.openai.config.OpenAiFeignConfig;
import com.xuxiaolei.openai.entity.OpenAiRequest;
import com.xuxiaolei.openai.entity.OpenAiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
* @Author: xuxiaolei
* @Description: TODO: OpenAiFeignClient
* @CreatTime: 2025/07/24 16:58
**/
@FeignClient(
        name = "openai",
        url = "https://api.openai.com",
        configuration = OpenAiFeignConfig.class
)
public interface OpenAiFeignClient {
    @PostMapping("/v1/chat/completions")
    OpenAiResponse chat(@RequestBody OpenAiRequest request);
}
