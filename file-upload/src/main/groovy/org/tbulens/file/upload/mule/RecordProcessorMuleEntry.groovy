package org.tbulens.file.upload.mule

import org.mule.api.MuleEventContext
import org.mule.api.lifecycle.Callable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.tbulens.file.upload.service.RecordProcessorService

@Component
class RecordProcessorMuleEntry implements Callable {

    @Autowired RecordProcessorService recordProcessorService

    Object onCall(MuleEventContext muleEventContext) throws Exception {
        recordProcessorService.process(muleEventContext.getMessageAsString())
    }
}
