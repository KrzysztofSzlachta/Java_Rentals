package com.szlachta.rentals.services;

import com.szlachta.rentals.dto.ItemRequest;
import com.szlachta.rentals.dto.ItemResponse;
import com.szlachta.rentals.exceptions.NotFoundException;
import com.szlachta.rentals.mappers.ItemMapper;
import com.szlachta.rentals.models.ItemEntity;
import com.szlachta.rentals.repositories.ItemsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            throw new NotFoundException("Przedmiot nie znaleziony");
        }
        return itemMapper.fromEntity(itemEntity);
    }

    public List<ItemResponse> getItems() {
        Iterable<ItemEntity> itemEntities = itemsRepository.findAll();
        List<ItemResponse> itemResponses = new ArrayList<>();
        for (ItemEntity itemEntity : itemEntities) {
            itemResponses.add(itemMapper.fromEntity(itemEntity));
        }
        return itemResponses;
    }

    public void createItem(ItemRequest itemRequest) {
        itemsRepository.save(itemMapper.fromRequest(itemRequest));
    }

    public void updateItem(ItemRequest itemRequest, int id) {
        ItemEntity itemEntity = itemsRepository.findById(id).orElse(null);
        if (itemEntity == null) {
            throw new NotFoundException("Przedmiot nie znaleziony");
        }

        itemEntity.setName(itemRequest.getName());
        itemEntity.setDescription(itemRequest.getDescription());
        itemEntity.setType(itemRequest.getType());
        itemEntity.setAdultRequired(itemRequest.getAdultRequired());

        itemsRepository.save(itemEntity);
    }

    public void deleteItem(int id) {
        ItemEntity itemEntity = itemsRepository.findById(id).orElse(null);
        if (itemEntity == null) {
            throw new NotFoundException("Przedmiot nie znaleziony");
        }
        itemsRepository.delete(itemEntity);
    }
}
