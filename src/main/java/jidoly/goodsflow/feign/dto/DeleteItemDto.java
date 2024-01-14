package jidoly.goodsflow.feign.dto;

import lombok.Data;

@Data
public class DeleteItemDto {

    private String id;
    private ReasonType reasonType;

    public DeleteItemDto(String serviceId, ReasonType reasonType) {
        this.id = serviceId;
        this.reasonType = reasonType;
    }
}
