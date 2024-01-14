package jidoly.goodsflow.service;

import jidoly.goodsflow.controller.dto.ItemDto;
import jidoly.goodsflow.controller.dto.TrackingDto;
import jidoly.goodsflow.domain.Item;
import jidoly.goodsflow.feign.ItemClient;
import jidoly.goodsflow.feign.dto.*;
import jidoly.goodsflow.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemClient itemClient;

    @Transactional
    public Long saveTracking(ItemDto itemDto) {

        if (itemRepository.existsByInvoiceNo(itemDto.getInvoiceNo())) {
            throw new RuntimeException("이미 존재하는 운송장번호입니다.");
        }

        //requestId : "request" + 회원사요청번호(uniqueId)
        TrackingDto trackingDto = new TrackingDto(itemDto);
        String requestId = "request-" + itemDto.getUniqueId();
        trackingDto.setRequestId(requestId);
        //feign 클라이언트 요청으로 goodsFlow OpenApi post 요청
        ApiResponseDto apiResponseDto = itemClient.postTracking(trackingDto);

        log.info("요청완료 : {}", apiResponseDto);


        //요청에 성공한 serviceId를 가져와서 저장
        List<ApiItemDto> items = apiResponseDto.getData().getItems();
        String serviceId = items.stream()
                .filter(ApiItemDto::isSuccess)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("요청에 실패하였습니다."))
                .getData()
                .getServiceId();


        Item item = Item.createItem(serviceId, itemDto.getUniqueId(), itemDto.getTransporter(), itemDto.getInvoiceNo(), itemDto.getItemName());
        itemRepository.save(item);
        Long itemId = item.getId();

        log.info("저장 완료 : {}", itemId);

        return itemId;

    }

    public List<Item> findTracking() {
        return itemRepository.findAll();
    }


    @Transactional
    public void deleteTracking(Long id) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 요청를 찾을수 없습니다. : " + id));
        /** Api 삭제 로직 */
        //Api 스펙에 맞춘 Dto 생성
        DeleteItemDto deleteItemDto = new DeleteItemDto(item.getServiceId(), ReasonType.CHANGE_MIND);
        DeleteDto deleteDto = new DeleteDto(deleteItemDto);
        //feign 삭제 요청
        ApiCancelResponseDto apiCancelResponseDto = itemClient.deleteTracking(deleteDto);
        log.info("삭제 요청 완료 : {}", apiCancelResponseDto);


        /** 데이터 베이스에서 삭제 */
        itemRepository.deleteById(id);
    }
}
