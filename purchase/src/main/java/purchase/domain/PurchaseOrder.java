package purchase.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import purchase.dto.PurchaseOrderDto;

import java.util.UUID;

@Getter
@Setter
@Document(collection = "purchase")
public class PurchaseOrder {

    @Id
    private String id = UUID.randomUUID().toString();

    private String customerId;

    private double value;

    public PurchaseOrder(){}

    public PurchaseOrderDto toDto(){
        return new PurchaseOrderDto(this);
    }


}
