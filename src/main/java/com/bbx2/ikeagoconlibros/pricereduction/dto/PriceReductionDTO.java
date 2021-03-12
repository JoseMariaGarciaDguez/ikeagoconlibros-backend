package com.bbx2.ikeagoconlibros.pricereduction.dto;

import com.bbx2.ikeagoconlibros.item.model.Item;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Data
public class PriceReductionDTO {

    Long idPriceReduction;

    Double reducedPrice;

    Date startDate;

    Date endDate;

    String Reason;

}
