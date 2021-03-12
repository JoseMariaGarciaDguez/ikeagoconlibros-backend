package com.bbx2.ikeagoconlibros.item.model;

import com.bbx2.ikeagoconlibros.item.enums.ItemStateEnum;
import com.bbx2.ikeagoconlibros.pricereduction.model.PriceReduction;
import com.bbx2.ikeagoconlibros.supplier.model.Supplier;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="idItem")
public class Item implements Serializable {

     @Id
             @SequenceGenerator(
                     name = "item_sequence",
                     sequenceName = "item_sequence",
                     allocationSize = 1
             )
             @GeneratedValue(
                     strategy = GenerationType.SEQUENCE,
                     generator = "item_sequence"
             )
     Long idItem;

     @Column(unique = true)
     String itemCode;

     @Column
     String description;

     @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinTable(
             name = "item_supplier",
             joinColumns = @JoinColumn(name = "item_id"),
             inverseJoinColumns = @JoinColumn(name = "supplier_id"))
     Set<Supplier> supplier;

     @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinTable(
             name = "item_price_reduction",
             joinColumns = @JoinColumn(name = "item_id"),
             inverseJoinColumns = @JoinColumn(name = "price_reduction_id"))
     List<PriceReduction> priceReduction;

     @Column
     Date creationDate;

     @Column
     String createdBy;

     @Column
     Double price;

     @Column
     @Enumerated(EnumType.STRING)
     ItemStateEnum state;



     public Item(){
       //Empty constructor :D
     }

     public Item(String itemCode, String description){
          this.itemCode = itemCode;
          this.description = description;
          this.state = ItemStateEnum.ACTIVE;
          this.creationDate = new Date(System.currentTimeMillis());
     }
     public Item(Long idItem, String description, Set<Supplier> supplier, List<PriceReduction> priceReduction, Date creationDate, String createdBy, Double price, ItemStateEnum state) {
          this.idItem = idItem;
          this.description = description;
          this.supplier = supplier;
          this.priceReduction = priceReduction;
          this.creationDate = creationDate;
          this.createdBy = createdBy;
          this.price = price;
          this.state = state;
     }
}
