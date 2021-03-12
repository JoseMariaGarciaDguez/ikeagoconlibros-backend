package com.bbx2.ikeagoconlibros.item.configuration;


import com.bbx2.ikeagoconlibros.item.enums.ItemStateEnum;
import com.bbx2.ikeagoconlibros.item.model.Item;
import com.bbx2.ikeagoconlibros.item.repository.ItemRepository;
import com.bbx2.ikeagoconlibros.pricereduction.model.PriceReduction;
import com.bbx2.ikeagoconlibros.supplier.model.Supplier;
import org.apache.tomcat.jni.Time;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class ItemConfiguration {
    CommandLineRunner commandLineRunner(ItemRepository itemRepository) {

        return null;
    }


}
