import groovyx.net.http.HTTPBuilder
import org.apache.http.HttpEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost

import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

def http = new HTTPBuilder()
http.request( 'https://mvnrepository.com', GET, TEXT ) { HttpGet req ->
    HttpPost post
    HttpEntity e
    post.setEntity()
    uri.path = '/artifact/commons-codec/commons-codec/1.13'
    headers.'User-Agent' = "Mozilla/5.0 Firefox/3.0.4"
    headers.Accept = 'application/json'
    response.success = { resp, reader ->
        assert resp.statusLine.statusCode == 200
        println "Got response: ${resp.statusLine}"
        println "Content-Type: ${resp.headers.'Content-Type'}"
        println reader.text
    }
    response.'404' = {
        println 'Not found'
    }
}
