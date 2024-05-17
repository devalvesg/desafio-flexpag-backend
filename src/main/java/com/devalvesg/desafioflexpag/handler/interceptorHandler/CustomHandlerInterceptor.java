package com.devalvesg.desafioflexpag.handler.interceptorHandler;

import com.devalvesg.desafioflexpag.repositories.PaymentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CustomHandlerInterceptor implements HandlerInterceptor {

    private PaymentRepository paymentRepository;
    public CustomHandlerInterceptor (PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        paymentRepository.updateStatusPayment();
        return true;
    }
}
