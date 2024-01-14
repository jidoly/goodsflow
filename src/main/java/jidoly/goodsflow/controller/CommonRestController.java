package jidoly.goodsflow.controller;

import jidoly.goodsflow.repository.ItemRepository;
import jidoly.goodsflow.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommonRestController {

    private final ItemService itemService;

    @DeleteMapping("/rest/cancel/{id}")
    public ResponseEntity<String> deleteTracking(@PathVariable Long id) {

        itemService.deleteTracking(id);
        return ResponseEntity.ok("Resource deleted successfully");
    }
}
