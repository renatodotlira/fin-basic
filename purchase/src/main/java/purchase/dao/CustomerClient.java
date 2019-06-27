package purchase.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import purchase.domain.Word;

@FeignClient("CUSTOMER")
public interface CustomerClient {

	@GetMapping("customer/getAmount/?customerId={customerId}")
	double getAmount(@PathVariable("customerId") String customerId);

	@PostMapping("account/debitAccount/?amount={amount}&customerId={customerId}")
	void debitAccount(@PathVariable("amount") double amount,
			@PathVariable("customerId") String customerId);
	
}
