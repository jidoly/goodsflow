package jidoly.goodsflow.feign;

import jidoly.goodsflow.GoodsFlowApiConfig;
import jidoly.goodsflow.controller.dto.TrackingDto;
import jidoly.goodsflow.feign.dto.ApiCancelResponseDto;
import jidoly.goodsflow.feign.dto.ApiItemDto;
import jidoly.goodsflow.feign.dto.ApiResponseDto;
import jidoly.goodsflow.feign.dto.DeleteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "item", url="${base-url}", configuration = GoodsFlowApiConfig.class)
public interface ItemClient {

    @PostMapping("${tracking-post}")
    ApiResponseDto postTracking(@RequestBody TrackingDto trackingDto);

    @DeleteMapping("${tracking-delete}")
    ApiCancelResponseDto deleteTracking(@RequestBody DeleteDto deleteDto);

}
