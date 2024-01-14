package jidoly.goodsflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "jidoly.goodsflow")
public class GoodsflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsflowApplication.class, args);
	}

}
