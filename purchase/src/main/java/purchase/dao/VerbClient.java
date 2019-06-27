package purchase.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import purchase.domain.Word;

@FeignClient("VERB")
public interface VerbClient {

	@GetMapping("/")
	Word getWord();
	
}
