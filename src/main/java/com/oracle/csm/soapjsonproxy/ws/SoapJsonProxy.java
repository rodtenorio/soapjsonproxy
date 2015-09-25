package com.oracle.csm.soapjsonproxy.ws;

public interface SoapJsonProxy<T, Y> {

    T callJson(Y param);
}
