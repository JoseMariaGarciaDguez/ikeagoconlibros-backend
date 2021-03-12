package com.bbx2.ikeagoconlibros.item.service;

import com.bbx2.ikeagoconlibros.item.dto.ItemDTO;
import com.bbx2.ikeagoconlibros.item.model.Item;

import java.util.List;

public interface ItemService {
    public List<ItemDTO> getItems();
    public ItemDTO getItemById(Long id);
    public void save(ItemDTO itemDTO);
}
