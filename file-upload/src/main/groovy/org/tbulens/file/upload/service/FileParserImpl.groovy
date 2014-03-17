package org.tbulens.file.upload.service

import javax.jws.WebService

@WebService(serviceName="fileParser", portName ="fileParserPort", endpointInterface = "org.tbulens.file.upload.service.FileParser")
class FileParserImpl implements FileParser {

    String parse(Map<String, Object> fileName) {

        fileName.get("fileName") + " has been successfully processed."
    }
}
