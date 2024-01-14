package jidoly.goodsflow.feign.dto;

import lombok.Data;

@Data
public class ApiResponseDto {
    private String transactionId;
    private boolean success;
    private ApiDataDto data;
    private String responseDateTime;
}
