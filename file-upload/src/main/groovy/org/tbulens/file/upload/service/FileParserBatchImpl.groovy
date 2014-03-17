package org.tbulens.file.upload.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.tbulens.file.upload.client.LineProcessorClient
import org.tbulens.file.upload.client.FileRecord

@Component
class FileParserBatchImpl implements FileParserBatch {

    @Autowired LineProcessorClient lineProcessorClient

    String parse(InputStream inputStream) {
        long lineNumber = 0
        inputStream.eachLine { line ->
            lineNumber += 1
            FileRecord record = new FileRecord(lineNumber: lineNumber, record: line)
            String result = lineProcessorClient.send(record)
        }

     "FileParserBatch is successful."
    }
}
