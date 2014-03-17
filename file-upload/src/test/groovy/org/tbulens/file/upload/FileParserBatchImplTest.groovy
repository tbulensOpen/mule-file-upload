package org.tbulens.file.upload

import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.tbulens.file.upload.service.FileParserBatch

class FileParserBatchImplTest {
    FileParserBatch fileParserBatch

    @Before
    void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:contexts/fileParser-applicationContext.xml")
        fileParserBatch = context.getBean("fileParserBatchImpl", FileParserBatch)
    }

    @Ignore
    @Test
    void parse() {
        InputStream inputStream = new ByteArrayInputStream("abccc".bytes)
        String result = fileParserBatch.parse(inputStream)

        assert "FileParserBatch is successful." == result
    }
}
