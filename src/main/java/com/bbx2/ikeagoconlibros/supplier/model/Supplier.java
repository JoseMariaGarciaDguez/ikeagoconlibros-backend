package com.bbx2.ikeagoconlibros.supplier.model;

import com.bbx2.ikeagoconlibros.item.model.Item;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.springframework.core.serializer.Serializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="idSupplier")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "items"})
public class Supplier implements Serializable {

    @Id
    @SequenceGenerator(
            name = "supplier_sequence",
            sequenceName = "supplier_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "supplier_sequence"
    )

    public Long idSupplier;

    @Column
    public String name;

    @Column
    public String country;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "supplier")

    List<Item> items;

    public Supplier(Long idSupplier, String name, String country, List<Item> items) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.country = country;
        this.items = items;
    }
    public Supplier(){

    }
}
