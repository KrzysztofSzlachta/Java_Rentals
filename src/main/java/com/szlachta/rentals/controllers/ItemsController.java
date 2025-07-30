package com.szlachta.rentals.controllers;


import com.szlachta.rentals.dto.ItemRequest;
import com.szlachta.rentals.dto.ItemResponse;
import com.szlachta.rentals.services.ItemsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemsController {
    private final ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/{id}")
    public ItemResponse getItemById(@PathVariable int id) {
        return itemsService.getItemById(id);
    }

    @PostMapping
    public void createItem(@RequestBody ItemRequest itemRequest) {
        itemsService.createItem(itemRequest);
    }
}
