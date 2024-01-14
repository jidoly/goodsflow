package jidoly.goodsflow;

import jidoly.goodsflow.feign.ItemApiInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoodsFlowApiConfig {

    @Bean
    public ItemApiInterceptor itemApiInterceptor() {
        return new ItemApiInterceptor();
    }
}
