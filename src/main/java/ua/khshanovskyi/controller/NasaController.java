package ua.khshanovskyi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ua.khshanovskyi.feign.NasaFeign;

@RestController
@RequestMapping("mars/pictures")
@RequiredArgsConstructor
public class NasaController {

    private final NasaFeign nasaFeign;

    @GetMapping(path = "/largest", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getLargestPicture(@RequestParam int sol, @RequestParam(required = false) String camera) {
        return nasaFeign.getPicture(sol, camera);
    }
}
