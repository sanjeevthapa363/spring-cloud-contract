package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return double of a given number"
    request {
        method GET()
        url("/double") {
            queryParameters {
                parameter("number", "2")
            }
        }
    }
    response {
        body("4")
        status 200
    }
}