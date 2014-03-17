package org.tbulens.file.upload.util

public abstract class AbstractPost  {
  public static final int  DEFAULT_TIME_OUT = 300000

  int connectionTimeOut = DEFAULT_TIME_OUT
  int readTimeOut = DEFAULT_TIME_OUT

  String makeRequest(String urlString, Map<String, Object> queryString) {
    return makeRequest(urlString, new QueryString(queryString))
  }

  String makeRequest(String urlString, QueryString queryString) {
    def connection = createConnection(urlString)
    writeConnection(connection, queryString)
    return handleResponse(connection, urlString, queryString)
  }

  String makeRequest(String urlString) {
    def connection = createConnection(urlString)
    return handleResponse(connection, urlString)
  }


  protected def createConnection(String urlString) {
    def url = new URL(urlString)
    def connection = url.openConnection()
    configureConnection(connection)
    connection
  }

  void configureConnection(def connection) {
    connection.setConnectTimeout(connectionTimeOut)
    connection.setReadTimeout(readTimeOut)
    connection.requestMethod = "POST"
    setContentType(connection)
    connection.doOutput = true
  }

  abstract def setContentType(connection);

  abstract void writeConnection(connection, queryString);

  void setTimeOut(int timeOut) {
    this.connectionTimeOut = timeOut
    this.readTimeOut = timeOut
  }


  private String handleResponse(def connection, String urlString) {
    handleResponse(connection, urlString, new QueryString());
  }


  private String handleResponse(def connection, String urlString, QueryString queryString) {

    connection.connect()
    def code = connection.responseCode
    if (code != 200) {
      throw new RuntimeException("Unable to call:" + " $urlString, Response Code was $code");
    }
    else {
      return connection.content.text
    }
  }
}