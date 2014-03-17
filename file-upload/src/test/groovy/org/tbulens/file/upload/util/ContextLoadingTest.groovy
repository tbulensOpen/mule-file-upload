package org.tbulens.file.upload.util

import org.junit.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.tbulens.file.upload.service.FileParserBatch
import org.tbulens.file.upload.client.LineProcessorClient

class ContextLoadingTest {

    @Test
    void load() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:contexts/fileParser-applicationContext.xml")
        assert context.getBean("lineProcessorClient", LineProcessorClient)
        assert context.getBean("fileParserBatchImpl", FileParserBatch)
    }

}
