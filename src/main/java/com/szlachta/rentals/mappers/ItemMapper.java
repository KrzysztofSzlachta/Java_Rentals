package com.szlachta.rentals.mappers;

import com.szlachta.rentals.dto.ItemRequest;
import com.szlachta.rentals.dto.ItemResponse;
import com.szlachta.rentals.models.ItemEntity;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public ItemResponse fromEntity(ItemEntity itemEntity) {
        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setId(itemEntity.getId());
        itemResponse.setName(itemEntity.getName());
        itemResponse.setDescription(itemEntity.getDescription());
        itemResponse.setAdultRequired(itemEntity.getAdultRequired());

        return itemResponse;
    }

    public ItemEntity fromRequest(ItemRequest itemRequest) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setName(itemRequest.getName());
        itemEntity.setDescription(itemRequest.getDescription());
        itemEntity.setType(itemRequest.getType());
        itemEntity.setAdultRequired(itemRequest.getAdultRequired());

        return itemEntity;
    }
}
