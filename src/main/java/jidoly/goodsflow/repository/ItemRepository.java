package jidoly.goodsflow.repository;

import jidoly.goodsflow.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {


    boolean existsByInvoiceNo(String invoiceNo);
}
