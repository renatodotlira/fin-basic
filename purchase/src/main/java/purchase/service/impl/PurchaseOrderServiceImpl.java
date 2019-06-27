package purchase.service.impl;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import purchase.dao.CustomerClient;
import purchase.dto.PurchaseOrderCreateDto;
import purchase.dto.PurchaseOrderDto;
import purchase.repository.PurchaseOrderRepository;
import purchase.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    PurchaseOrderRepository repository;

    @Autowired
    CustomerClient customer;

    @Override
    public PurchaseOrderDto save(PurchaseOrderCreateDto purchaseOrderCreateDto) throws HttpException {
        double amount = customer.getAmount(purchaseOrderCreateDto.getCustomerId());
        if(purchaseOrderCreateDto.getValue() > amount)
            throw new HttpException("Saldo insuficiente!");

        customer.debitAccount(purchaseOrderCreateDto.getValue(), purchaseOrderCreateDto.getCustomerId());
        return repository.save(purchaseOrderCreateDto.toModel()).toDto();
    }
}
