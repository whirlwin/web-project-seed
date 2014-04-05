package com.whirlwin.example.mvc

import org.apache.log4j.Logger
import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class ExampleHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = Logger.getLogger(ExampleHandlerInterceptor.class)

    @Override
    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info "Method intercepted: " + handler
        true
    }
}
