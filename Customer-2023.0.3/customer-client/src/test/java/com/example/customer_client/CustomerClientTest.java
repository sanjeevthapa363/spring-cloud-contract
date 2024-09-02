package com.example.customer_client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.http.HttpHeaders;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootTest(classes = CustomerClientApplication.class)
//@AutoConfigureWireMock(port = 8081)
//@AutoConfigureJson
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.example:customer-service:+:8081")
public class CustomerClientTest {

    @Autowired
    private CustomerClient client;

//    @Autowired
//    private ObjectMapper objectMapper;

    @Test
    public void clientShouldReturnAllCustomers() throws Exception {
//        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/customers"))
//                .willReturn(WireMock.aResponse()
//                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                        .withStatus(200)
//                        .withBody(jsonForCustomers(new Customer(1L, "Jane"), new Customer(2L, "Bob")))));

        Collection<Customer> customers = this.client.getAllCustomers();
        BDDAssertions.then(customers).size().isEqualTo(2);
        BDDAssertions.then(customers.iterator().next().getId()).isEqualTo(1L);
        BDDAssertions.then(customers.iterator().next().getName()).isEqualTo("Jane");
    }

//    private String jsonForCustomers(Customer... customers) throws JsonProcessingException {
//        List<Customer> customerList = Arrays.asList(customers);
//        return this.objectMapper.writeValueAsString(customerList);
//    }

}
