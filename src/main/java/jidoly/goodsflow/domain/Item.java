package jidoly.goodsflow.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String  serviceId;
    private String uniqueId;

    //택배사
    @Enumerated(EnumType.STRING)
    private Transporters transporter;
    //운송장 번호
    private String invoiceNo;
    //아이템 이름
    private String itemName;

    private Item(String serviceId, String uniqueId, Transporters transporter, String invoiceNo, String itemName) {
        this.serviceId = serviceId;
        this.uniqueId = uniqueId;
        this.transporter = transporter;
        this.invoiceNo = invoiceNo;
        this.itemName = itemName;
    }

    /**
     * 생성 메소드
     */
    public static Item createItem(String serviceId,String  uniqueId, Transporters transporter, String invoiceNo, String itemName) {
        return new Item(serviceId,uniqueId, transporter, invoiceNo, itemName);
    }

}
