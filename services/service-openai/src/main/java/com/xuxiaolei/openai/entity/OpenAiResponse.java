package com.xuxiaolei.openai.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: xuxiaolei
 * @Description: TODO: OpenAiResponse
 * @CreatTime: 2025/07/24 16:55
 **/
@Data
public class OpenAiResponse {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private int index;
        private OpenAiRequest.Message message;
    }
}
