package purchase.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import purchase.domain.PurchaseOrder;

public interface PurchaseOrderRepository extends MongoRepository<PurchaseOrder, String> {
}
