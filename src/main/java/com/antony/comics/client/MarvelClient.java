package com.antony.comics.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "marvel", url = "https://gateway.marvel.com:443/v1/public")
public interface MarvelClient {

    @GetMapping(value = "/comics/{id}")
    public String buscarComics(@PathVariable("id") Integer id,
                                     @RequestParam(name = "ts") String ts,
                                     @RequestParam(name = "apikey") String apikey,
                                     @RequestParam(name = "hash") String hash);
}
