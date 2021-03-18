package com.bbx2.ikeagoconlibros.item.service;


import ch.qos.logback.classic.net.SimpleSocketServer;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.bbx2.ikeagoconlibros.item.dto.ItemDTO;
import com.bbx2.ikeagoconlibros.item.dto.SimpleItemDTO;
import com.bbx2.ikeagoconlibros.item.enums.ItemStateEnum;
import com.bbx2.ikeagoconlibros.item.model.Item;
import com.bbx2.ikeagoconlibros.item.repository.ItemRepository;
import com.bbx2.ikeagoconlibros.supplier.model.Supplier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository  itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SimpleItemDTO> getItems() {

        List<SimpleItemDTO> result = new ArrayList<>();
        itemRepository.findAll().forEach( item -> {
            result.add(modelMapper.map(item,SimpleItemDTO.class));
                }
        );
        return result;
    }

    @Override
    public ItemDTO getItemById(Long id) {
        System.err.println("papa "+ id);
        return modelMapper.map(itemRepository.findByIdItem(id), ItemDTO.class);
    }

    @Override
    public void save(ItemDTO itemDTO) {
        if (itemDTO.getState() == null){
            itemDTO.setState(ItemStateEnum.ACTIVE);
        }
        if (itemDTO.getCreationDate() == null){
            itemDTO.setCreationDate(new Date(System.currentTimeMillis()));
        }
        itemRepository.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public void deleteById(Long id) {
        itemRepository.delete(itemRepository.findByIdItem(id));
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemDTO> result = new ArrayList<>();
        itemRepository.findAll().forEach( item -> {
                    result.add(modelMapper.map(item,ItemDTO.class));
                }
        );
        return result;
    }
}
