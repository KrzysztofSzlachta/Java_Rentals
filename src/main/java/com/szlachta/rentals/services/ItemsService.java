package com.szlachta.rentals.services;

import com.szlachta.rentals.dto.ItemRequest;
import com.szlachta.rentals.dto.ItemResponse;
import com.szlachta.rentals.exceptions.NotFoundException;
import com.szlachta.rentals.mappers.ItemMapper;
import com.szlachta.rentals.models.ItemEntity;
import com.szlachta.rentals.repositories.ItemsRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    private final ItemsRepository itemsRepository;
    private final ItemMapper itemMapper;

    public ItemsService(ItemsRepository itemsRepository, ItemMapper itemMapper) {
        this.itemsRepository = itemsRepository;
        this.itemMapper = itemMapper;
    }

    public ItemResponse getItemById(int id) {
        ItemEntity itemEntity = itemsRepository.findById(id).orElse(null);
        if (itemEntity == null) {
            throw new NotFoundException("Item not found");
        }
        return itemMapper.fromEntity(itemEntity);
    }

    public void createItem(ItemRequest itemRequest) {
        System.out.println("Test");
    }

    public void updateItem(ItemRequest itemRequest, int id) {
        System.out.println("Test");
    }

    public void deleteItem(int id) {
        System.out.println("Test");
    }
}
