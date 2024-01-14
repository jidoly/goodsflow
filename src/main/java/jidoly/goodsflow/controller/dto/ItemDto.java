package jidoly.goodsflow.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jidoly.goodsflow.domain.Transporters;
import lombok.Data;

@Data
public class ItemDto {


    @NotBlank
    private String uniqueId;

    private Transporters transporter;

    //운송장 번호
    @NotBlank
    private String invoiceNo;

    @NotBlank
    //아이템 이름
    private String itemName;
}
