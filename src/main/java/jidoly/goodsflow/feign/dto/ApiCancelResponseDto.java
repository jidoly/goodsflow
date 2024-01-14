package jidoly.goodsflow.feign.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiCancelResponseDto {
    private String transactionId;
    private boolean success;
    private List<ApiItemDto> data;
    private ApiErrorDto error;
    private String responseDateTime;
}
