package org.poseidon.action.demo.httpInvoke;

import org.apache.commons.httpclient.NameValuePair;
import org.poseidon.util.HttpClientUtil;

public class TestMain {
	public static void main(String[] args) throws Exception{
    	NameValuePair[] data = {new NameValuePair("method", "test")}; 

    	HttpClientUtil.sendPost("http://127.0.0.1/poseidon/testAction.do", data, 6000);
    }
}