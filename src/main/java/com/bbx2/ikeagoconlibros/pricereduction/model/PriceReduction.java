package com.bbx2.ikeagoconlibros.pricereduction.model;

import com.bbx2.ikeagoconlibros.item.model.Item;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "item"})
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="idPriceReduction")
public class PriceReduction implements Serializable {

    @Id
    @SequenceGenerator(
            name = "price_reduction_sequence",
            sequenceName = "price_reduction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "price_reduction_sequence"
    )
    Long idPriceReduction;

    @Column
    Double reducedPrice;

    @Column
    Date startDate;

    @Column
    Date endDate;

    @Column
    String Reason;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="priceReduction")
    List<Item> item;

    public PriceReduction(){
    super();

    }
    public PriceReduction(Long idPriceReduction, Double reducedPrice, Date startDate, Date endDate, String reason, List<Item> item) {
        this.idPriceReduction = idPriceReduction;
        this.reducedPrice = reducedPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        Reason = reason;
        this.item = item;
    }
}
