package com.xuxiaolei.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuxiaolei.common.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 * @Author: xuxiaolei
 * @Description: TODO: MyBlockException
 * @CreatTime: 2025/07/24 09:38
 **/
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    private final ObjectMapper objectMapper;

    public MyBlockExceptionHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       String s, BlockException e) throws Exception {
        httpServletResponse.setStatus(429); //too many request
        httpServletResponse.setContentType("application/json;charset=UTF-8");//内容类型
        PrintWriter writer = httpServletResponse.getWriter();

        R error = R.error(500, s + "被sentinel限制了" + e.getClass(), null);
        String json = objectMapper.writeValueAsString(error);
        writer.write(json);
        writer.flush();
        writer.close();

    }
}
