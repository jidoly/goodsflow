package jidoly.goodsflow.controller;

import jidoly.goodsflow.controller.dto.ItemDto;
import jidoly.goodsflow.controller.dto.TrackingDto;
import jidoly.goodsflow.domain.Item;
import jidoly.goodsflow.domain.Transporters;
import jidoly.goodsflow.repository.ItemRepository;
import jidoly.goodsflow.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final ItemService itemService;
    private final ItemRepository itemRepository;

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/tracking")
    public String tracking(@ModelAttribute("itemDto") ItemDto itemDto, Model model) {


        Transporters[] transporters = Transporters.values();

        model.addAttribute("transporters", transporters);
        return "tracking";
    }


    @PostMapping("/tracking")
    public String postTracking(@Validated @ModelAttribute("itemDto") ItemDto itemDto,
                                 BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            // 유효성 검증 오류 처리
            return "tracking";
        }
        itemService.saveTracking(itemDto);

        return "redirect:/main";
    }

    @GetMapping("/trackings")
    public String trackings(Model model) {

        List<Item> trackings = itemService.findTracking();

        model.addAttribute("trackings", trackings);

        return "trackings";
    }



}
