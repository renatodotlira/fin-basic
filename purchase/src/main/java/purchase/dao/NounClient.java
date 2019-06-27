package purchase.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import purchase.domain.Word;

@FeignClient("NOUN")
public interface NounClient {

	@GetMapping("/")
	Word getWord();
	
}
