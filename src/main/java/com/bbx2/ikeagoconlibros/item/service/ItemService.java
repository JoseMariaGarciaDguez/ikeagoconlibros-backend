package com.bbx2.ikeagoconlibros.item.service;

import com.bbx2.ikeagoconlibros.item.dto.ItemDTO;
import com.bbx2.ikeagoconlibros.item.dto.SimpleItemDTO;
import com.bbx2.ikeagoconlibros.item.model.Item;

import java.util.List;

public interface ItemService {
    public List<SimpleItemDTO> getItems();
    public ItemDTO getItemById(Long id);
    public void save(ItemDTO itemDTO);
    public void deleteById(Long id);
    public List<ItemDTO> getAllItems();
}
