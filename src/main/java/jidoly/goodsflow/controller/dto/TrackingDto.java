package jidoly.goodsflow.controller.dto;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jidoly.goodsflow.domain.Transporters;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TrackingDto {

    private String requestId;
    private List<ItemDto> items;

    public TrackingDto(ItemDto itemDto) {
        this.items = new ArrayList<>();
        this.items.add(itemDto);
    }
}
