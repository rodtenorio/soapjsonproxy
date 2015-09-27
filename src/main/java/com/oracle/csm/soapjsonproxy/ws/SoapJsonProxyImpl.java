package com.oracle.csm.soapjsonproxy.ws;

import java.io.IOException;

import javax.jws.WebService;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.oracle.csm.soapjsonproxy.model.Pessoa;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@WebService(name = "SoapJsonProxyPortType", serviceName = "SoapJsonProxyService")
public class SoapJsonProxyImpl {

    public String callJson(final Pessoa param) {

        final ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        final Client client = Client.create(clientConfig);
        final WebResource webResource = client
                .resource("http://localhost:7001/jsonwebservice/restful/JsonWebService/doTask");
        final ClientResponse clientResponse = webResource.accept("application/json").type("application/json")
                .post(ClientResponse.class, param);

        final String output = clientResponse.getEntity(String.class);
        System.out.println(output);

        return output;
    }

//    private String convertToJson(final Pessoa p) {
//        final ObjectMapper om = new ObjectMapper();
//        try {
//            return om.writeValueAsString(p);
//        } catch (final JsonGenerationException e) {
//            throw new RuntimeException(e);
//        } catch (final JsonMappingException e) {
//            throw new RuntimeException(e);
//        } catch (final IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
