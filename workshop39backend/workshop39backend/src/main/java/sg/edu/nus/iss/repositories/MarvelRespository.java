package sg.edu.nus.iss.repositories;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class MarvelRespository {

    private static String marvelUrl = "https://gateway.marvel.com:443/v1/public/characters";

    
    private static String marvelAPI = "b5d7734b1a89b586ce8356c71d982d47";

    public List<String> getName (String name, int limit, int offset) throws IOException {
        String getMarvelUrl = UriComponentsBuilder.fromUriString(marvelUrl)
            .queryParam("ts", 1)
            .queryParam("nameStartsWith", name)
            .queryParam("limit", limit)
            .queryParam("offset", offset)
            .queryParam("apikey", marvelAPI)
            //md5 hash
            .queryParam("hash", "c5850daa28b32b501997f0a61dd4eabc")
            .toUriString();

        // RequestEntity<String> req = RequestEntity.post(getMarvelUrl)
        // .contentType(MediaType.APPLICATION_JSON)
        // .accept(MediaType.APPLICATION_JSON)
        // .body(name.toJSONString())

            RestTemplate template = new RestTemplate();
            ResponseEntity<String> res = template.getForEntity(getMarvelUrl,String.class);
        


    
}}
