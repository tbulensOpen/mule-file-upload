package org.tbulens.file.upload.util

import org.springframework.stereotype.Component

@Component
public class SimplePost extends AbstractPost{

  private def outputStreamWriterFactory

  SimplePost(){
    outputStreamWriterFactory = new OutputStreamWriterFactory()
  }

  public setContentType(Object connection) {
  }

  public void writeConnection(connection, queryString) {
    def writer = outputStreamWriterFactory.create(connection.outputStream)

    if (queryString.toString()) {
      writer.write(queryString.toString())
    }
    else {
      writer.write()
    }

    writer.flush()
    writer.close()
  }

}