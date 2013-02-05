package org.lantern.exceptional4j;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;

public interface HttpStrategy {

    HttpResponse execute(final HttpUriRequest request) throws ClientProtocolException, IOException;

}
