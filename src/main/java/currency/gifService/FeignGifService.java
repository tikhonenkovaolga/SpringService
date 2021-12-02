package currency.gifService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gifService", url = "api.giphy.com/v1/gifs/")
public interface FeignGifService {
    @GetMapping("/random/{api_key, tag}")
    ResponseEntity<?> getGif(@RequestParam("api_key") String apiKey, @RequestParam("tag") String tag);
}
