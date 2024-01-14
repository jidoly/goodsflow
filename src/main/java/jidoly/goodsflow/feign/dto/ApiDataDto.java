package jidoly.goodsflow.feign.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiDataDto {
    private int totalCnt;
    private int successCnt;
    private int failCnt;
    private List<ApiItemDto> items;
}
