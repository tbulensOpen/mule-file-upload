package org.tbulens.file.upload.util

class QueryString {
  Map params = [:]


  QueryString() {
    params = [:]
  }

  QueryString(params) {
    this.params = params
  }

  void add(String name, Object value) {
    params.put(name, value)
  }

  String toString() {
    def list = []
    params.each {name, value ->
      list << "$name=" + URLEncoder.encode(value.toString())
    }
    return list.join("&")
  }

  boolean equals(Object obj) {
    if(!(obj instanceof QueryString)) {
      return false
    }

    return params.equals(obj.params);
  }

  int hashCode() {
    return params.hashCode();
  }

}
