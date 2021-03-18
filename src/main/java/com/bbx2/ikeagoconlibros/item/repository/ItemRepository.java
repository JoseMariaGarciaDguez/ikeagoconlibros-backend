package com.bbx2.ikeagoconlibros.item.repository;

import com.bbx2.ikeagoconlibros.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository
        extends JpaRepository<Item, Long> {

    public Item findByPrice(Long price);
    public Item findByIdItem(Long IdItem);

}
