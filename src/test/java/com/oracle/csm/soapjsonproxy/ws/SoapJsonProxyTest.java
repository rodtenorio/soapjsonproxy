package com.oracle.csm.soapjsonproxy.ws;

import com.oracle.csm.soapjsonproxy.model.Pessoa;

public class SoapJsonProxyTest {

    public static void main(final String[] args) {
        final SoapJsonProxyImpl soapJsonProxyImpl = new SoapJsonProxyImpl();
        final Pessoa p = new Pessoa();
        p.setId(1L);
        p.setNome("Rodrigo Tenorio");
        p.setCpf("000.000.000-00");
        System.out.println(soapJsonProxyImpl.callJson(p));
    }
}
