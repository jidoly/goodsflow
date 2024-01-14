package jidoly.goodsflow.feign.dto;

import lombok.Data;

@Data
public class ApiItemDto {
    private int idx;
    private boolean success;
    private ApiItemDataDto data;
    private ApiErrorDto error;
}
