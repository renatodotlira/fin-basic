package purchase.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import purchase.dto.PurchaseOrderCreateDto;
import purchase.dto.PurchaseOrderDto;
import purchase.service.PurchaseOrderService;

@RestController
@RequestMapping("purchaseOrder")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService service;

    @PostMapping("save/")
    @ApiOperation("Salva uma nova compra")
    public PurchaseOrderDto save(@RequestBody PurchaseOrderCreateDto customerDto) throws HttpException {
        return service.save(customerDto);
    }

}
