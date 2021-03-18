package com.bbx2.ikeagoconlibros.item.dto;

import com.bbx2.ikeagoconlibros.item.enums.ItemStateEnum;
import com.bbx2.ikeagoconlibros.pricereduction.dto.PriceReductionDTO;
import com.bbx2.ikeagoconlibros.pricereduction.model.PriceReduction;
import com.bbx2.ikeagoconlibros.supplier.dto.SupplierDTO;
import com.bbx2.ikeagoconlibros.supplier.model.Supplier;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class SimpleItemDTO {
    Long idItem;

    String itemCode;

    String description;

    Date creationDate;

    String createdBy;

    Double price;

    ItemStateEnum state;

}