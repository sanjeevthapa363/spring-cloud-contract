package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
public class MathController {
 
    @Autowired
    private RestTemplate restTemplate;
 
    @GetMapping("/calculate")
    public String checkOddAndEven(@RequestParam("number1") Integer number1, @RequestParam("number2") Integer number2) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
 
        ResponseEntity<String> responseEntity = restTemplate.exchange(
          "http://localhost:8090/validate?number1=" + number1 + "&number2=" + number2,
          HttpMethod.GET,
          new HttpEntity<>(httpHeaders),
          String.class);
 
        return responseEntity.getBody();
    }

    @GetMapping("/double")
    public String checkDouble(@RequestParam("number") Integer number) {
        return restTemplate.getForObject("http://localhost:8090/double?number=" + number, String.class);
    }

    @GetMapping("/add")
    public String add(@RequestParam("value1") Integer value1, @RequestParam("value2") Integer value2) {
        return restTemplate.getForObject("http://localhost:8090/add?value1="+value1+"&"+"value2="+value2, String.class);
    }
}