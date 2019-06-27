package purchase.service;

import org.apache.http.HttpException;
import purchase.dto.PurchaseOrderCreateDto;
import purchase.dto.PurchaseOrderDto;

public interface PurchaseOrderService {

    PurchaseOrderDto save(PurchaseOrderCreateDto purchaseOrderCreateDto) throws HttpException;

}
