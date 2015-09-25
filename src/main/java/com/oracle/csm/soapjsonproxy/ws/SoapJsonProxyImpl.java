package com.oracle.csm.soapjsonproxy.ws;

import java.io.IOException;

import javax.jws.WebService;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.oracle.csm.soapjsonproxy.model.Pessoa;

@WebService(name = "SoapJsonProxyPortType", serviceName = "SoapJsonProxyService")
public class SoapJsonProxyImpl {

    public String callJson(final Pessoa param) {
        return convertToJson(param);
    }

    private String convertToJson(final Pessoa p) {
        final ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(p);
        } catch (final JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (final JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
