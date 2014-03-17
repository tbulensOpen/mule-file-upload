package org.tbulens.file.upload.service

import org.springframework.stereotype.Component

@Component
class RecordProcessorService {

    String process(String jsonData) {
        println "***********************************************"
        println "* " + jsonData
        println "***********************************************"
    }
}
