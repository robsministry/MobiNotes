/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:RecordFacadeREST [record]<br>
 * USAGE:
 * <pre>
 *        RecordClient client = new RecordClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Robert
 */
public class MobiNotesRemoteClient implements MobiNotesClient {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/MobiNotes/mobiws";

    static {
        ClientFactory.instance().registerClient("remote", new MobiNotesRemoteClient());
    }

    public MobiNotesRemoteClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
    }

    @Override
    public void remove(String id) throws UniformInterfaceException {
        webResource.path(java.text.MessageFormat.format("{0}", new Object[]{id})).delete();
    }

    @Override
    public String count() throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("count");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

//    public <T> T findAll_XML(Class<T> responseType) throws UniformInterfaceException {
//        WebResource resource = webResource;
//        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
//    }
    @Override
    public <T> T findAll(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;

        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

//    public void edit_XML(Object requestEntity) throws UniformInterfaceException {
//        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
//    }
    @Override
    public void edit(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(requestEntity);
    }

//    public void create_XML(Object requestEntity) throws UniformInterfaceException {
//        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).post(requestEntity);
//    }
    @Override
    public void create(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(requestEntity);
    }

//    public <T> T findRange_XML(Class<T> responseType, String from, String to) throws UniformInterfaceException {
//        WebResource resource = webResource;
//        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
//        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
//    }
    @Override
    public <T> T findRange(Class<T> responseType, String from, String to) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

//    public <T> T find_XML(Class<T> responseType, String id) throws UniformInterfaceException {
//        WebResource resource = webResource;
//        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
//        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
//    }
    @Override
    public <T> T find(Class<T> responseType, String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.destroy();
    }

    @Override
    public MobiNotesClient createClient() {
        return new MobiNotesRemoteClient();
    }


    @Override
    public void setPath(String path) {
        if(path == null) {
            webResource = client.resource(BASE_URI);
        } else {
            webResource = client.resource(BASE_URI).path(path);
        }
    }
}
