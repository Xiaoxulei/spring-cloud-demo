package com.xuxiaolei.openai.controller;

import com.xuxiaolei.openai.entity.OpenAiRequest;
import com.xuxiaolei.openai.entity.OpenAiResponse;
import com.xuxiaolei.openai.feign.OpenAiFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xuxiaolei
 * @Description: TODO: ChatController
 * @CreatTime: 2025/07/24 16:59
 **/
@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final OpenAiFeignClient openAiFeignClient;
    @GetMapping("/ask")
    public String ask(@RequestParam String prompt) {
        OpenAiRequest request = new OpenAiRequest();
        request.setModel("gpt-4o");
        request.setMessages(List.of(
                new OpenAiRequest.Message("user", prompt)
        ));

        OpenAiResponse response = openAiFeignClient.chat(request);
        return response.getChoices().get(0).getMessage().getContent();
    }
}
