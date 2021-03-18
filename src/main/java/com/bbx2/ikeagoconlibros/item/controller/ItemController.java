package com.bbx2.ikeagoconlibros.item.controller;

import com.bbx2.ikeagoconlibros.item.dto.ItemDTO;
import com.bbx2.ikeagoconlibros.item.dto.SimpleItemDTO;
import com.bbx2.ikeagoconlibros.item.enums.ItemStateEnum;
import com.bbx2.ikeagoconlibros.item.model.Item;
import com.bbx2.ikeagoconlibros.item.repository.ItemRepository;
import com.bbx2.ikeagoconlibros.item.service.ItemService;
import com.bbx2.ikeagoconlibros.pricereduction.model.PriceReduction;
import com.bbx2.ikeagoconlibros.supplier.model.Supplier;

import org.apache.catalina.connector.Response;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path="api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;


    @GetMapping("/items")
    public ResponseEntity<List<SimpleItemDTO>>  getItems() throws Exception {
        return  new ResponseEntity<List<SimpleItemDTO>>(itemService.getItems(), HttpStatus.OK);

    }

    @GetMapping("/item")
    public ResponseEntity<ItemDTO> getItem(@RequestParam Long id){
        return new ResponseEntity<ItemDTO>(itemService.getItemById(id), HttpStatus.OK);
    }


    @PostMapping( path = "item/save")
        public void saveItem(@RequestBody ItemDTO itemDTO){
        itemService.save(itemDTO);

    }


    @GetMapping("/item/allitems")
    public ResponseEntity<List<ItemDTO>>  getAllItems() throws Exception {
        return  new ResponseEntity<List<ItemDTO>>(itemService.getAllItems(), HttpStatus.OK);

    }

    @DeleteMapping("item/delete")
    public void deleteItem(@RequestParam Long id){
        itemService.deleteById(id);
    }
}
