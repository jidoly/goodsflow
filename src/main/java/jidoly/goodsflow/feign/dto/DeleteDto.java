package jidoly.goodsflow.feign.dto;

import jidoly.goodsflow.controller.dto.ItemDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DeleteDto {
    private List<DeleteItemDto> items;

    public DeleteDto(DeleteItemDto deleteItemDto) {
        this.items = new ArrayList<>();
        this.items.add(deleteItemDto);
    }
}
