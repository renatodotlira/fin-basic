package purchase.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import purchase.domain.PurchaseOrder;

import java.util.UUID;

@Getter
@Setter
public class PurchaseOrderDto {


    private String id;

    private String customerId;

    private double value;

    public PurchaseOrderDto(){}

    public PurchaseOrderDto(PurchaseOrder purchaseOrder){
        this.id = purchaseOrder.getId();
        this.customerId = purchaseOrder.getCustomerId();
        this.value = purchaseOrder.getValue();
    }

}
