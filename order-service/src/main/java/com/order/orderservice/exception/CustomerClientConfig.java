package com.order.orderservice.exception;


import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ProblemDetail;

import java.io.IOException;

@Configuration
public class CustomerClientConfig {

    @Bean
    public ErrorDecoder errorDecoder(){

        return (methodKey, response) -> {
            try{
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.findAndRegisterModules();
                String body = Util.toString(response.body().asReader());
                System.out.println(body);
                CustomProblemDetail error = objectMapper.readValue(body,CustomProblemDetail.class);
                System.out.println("Status = " + response.status());
                System.out.println("ErrorCode = " + error.getErrorCode());
                System.out.println("Detail = " + error.getDetail());
                if(response.body()==null){
                    return new RuntimeException("No response body");
                }


                if(response.status()==404&&"CUSTOMER_NOT_FOUND".equals(error.getErrorCode())){
                    Long customerId = ((Number) error.getCustomerId()).longValue();
                    return new CustomerNotFoundException(error.getDetail(), customerId);
                }
                return new RuntimeException("Unhandled error : "+error.getDetail());
            }
            catch (IOException e){
                return new RuntimeException("Error decoding error response",e);
            }
        };
    }
}
