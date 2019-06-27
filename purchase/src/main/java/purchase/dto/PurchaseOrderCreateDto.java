package purchase.dto;

import lombok.Getter;
import lombok.Setter;
import purchase.domain.PurchaseOrder;

@Getter
@Setter
public class PurchaseOrderCreateDto {

    private String customerId;

    private double value;

    public PurchaseOrderCreateDto(){}

    public PurchaseOrderCreateDto(PurchaseOrder purchaseOrder){
        this.customerId = purchaseOrder.getCustomerId();
        this.value = purchaseOrder.getValue();
    }

    public PurchaseOrder toModel(){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setCustomerId(this.customerId);
        purchaseOrder.setValue(this.value);
        return purchaseOrder;
    }

}
