package ua.khshanovskyi.feign;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "taras-service", url = "${taras.service.url}")
public interface NasaFeign {

    @GetMapping(path = "${taras.service.path}")
    @Cacheable("taras-service-redis-cache")
    byte[] getPicture(@RequestParam int sol, @RequestParam(required = false) String camera);
}
