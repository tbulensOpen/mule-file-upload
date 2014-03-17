package org.tbulens.file.upload.util

public class OutputStreamWriterFactory {
def create(def outputStream) {
    new OutputStreamWriter(outputStream)
  }
}