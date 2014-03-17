package org.tbulens.file.upload.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class HttpRequester {
    String requestUrl = "http://localhost:8085"
    @Autowired SimplePost simplePost

    String send(String requestedServiceName, Map<String, Object> data) {
        String fullUrl = requestUrl + "/" + requestedServiceName
        simplePost.makeRequest(fullUrl, data)
    }
}
