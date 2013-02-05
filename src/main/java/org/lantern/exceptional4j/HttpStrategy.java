package org.lantern.exceptional4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public interface HttpStrategy {

    HttpResponse execute(final HttpGet request) throws ClientProtocolException, IOException;
    
    HttpResponse execute(final HttpPost request) throws ClientProtocolException, IOException;

}
