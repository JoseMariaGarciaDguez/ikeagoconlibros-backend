package com.bbx2.ikeagoconlibros.supplier.dto;

import com.bbx2.ikeagoconlibros.item.model.Item;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class SupplierDTO {


    private Long idSupplier;

    private String name;

    private String country;


}
