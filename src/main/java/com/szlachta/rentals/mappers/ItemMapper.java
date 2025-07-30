package com.szlachta.rentals.mappers;

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
}
