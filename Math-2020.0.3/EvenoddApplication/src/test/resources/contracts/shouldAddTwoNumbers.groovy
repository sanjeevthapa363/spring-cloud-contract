package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "add two number"
    request {
        method GET()
        url("/add") {
            queryParameters {
                parameter("value1", "2")
                parameter("value2", "5")
            }
        }
    }
    response {
        body("7")
        status 200
    }
}