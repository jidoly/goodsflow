package jidoly.goodsflow.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;

public class ItemApiInterceptor implements RequestInterceptor {


    @Value("${api-key}")
    private String apikey;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", apikey);
    }
}
