package org.tbulens.file.upload.client

import groovy.json.JsonBuilder
import org.springframework.stereotype.Component

@Component
class JsonRecordBuilder {

    String convert(FileRecord record) {
        new JsonBuilder(record: record).toPrettyString()
    }
}
