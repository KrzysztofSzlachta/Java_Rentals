package com.szlachta.rentals.controllers;


import com.szlachta.rentals.dto.ItemRequest;
import com.szlachta.rentals.dto.ItemResponse;
import com.szlachta.rentals.services.ItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<ItemResponse> getAllItems() {
        return itemsService.getItems();
    }

    @PostMapping
    public void createItem(@RequestBody ItemRequest itemRequest) {
        itemsService.createItem(itemRequest);
    }

    @PutMapping("/{id}")
    public void updateItem(@RequestBody ItemRequest itemRequest, @PathVariable int id) {
        itemsService.updateItem(itemRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        itemsService.deleteItem(id);
    }
}
