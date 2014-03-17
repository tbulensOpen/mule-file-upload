package org.tbulens.file.upload.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.tbulens.file.upload.util.HttpRequester

@Component
class LineProcessorClient {
    static String LINE_RECORD_MULE_KEY = "recordRequester"

    @Autowired HttpRequester httpRequester
    @Autowired JsonRecordBuilder jsonRecordBuilder

    String send(FileRecord fileRecord) {
        println fileRecord.lineNumber + " - " + fileRecord.record

        httpRequester.send(LINE_RECORD_MULE_KEY, ["fileRecord": jsonRecordBuilder.convert(fileRecord)])
    }
}
