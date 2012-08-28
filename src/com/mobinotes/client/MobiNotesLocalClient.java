/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.client;

import com.sun.jersey.api.client.Client;

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
public class MobiNotesLocalClient implements MobiNotesClient {

    /*
     * bridge 
     */
    private LocalResource localResource;

    static {
        ClientFactory.instance().registerClient("local", new MobiNotesLocalClient());
    }

    public MobiNotesLocalClient() {
        
    }

    @Override
    public void setPath(String path) {
        localResource = new LocalResourceImpl(path);
    }

    @Override
    public void remove(String id) {
        localResource.delete(id);
    }

    @Override
    public String count() {

        return localResource.count();
    }

//    public <T> T findAll_XML(Class<T> responseType) throws UniformInterfaceException {
//        WebResource resource = webResource;
//        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
//    }
    @Override
    public <T> T findAll(Class<T> responseType) {

        
        return localResource.get(responseType);
    }

//    public void edit_XML(Object requestEntity) throws UniformInterfaceException {
//        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
//    }
    @Override
    public void edit(Object requestEntity) {
        localResource.edit(requestEntity);
    }

//    public void create_XML(Object requestEntity) throws UniformInterfaceException {
//        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).post(requestEntity);
//    }
    @Override
    public void create(Object requestEntity) {
        localResource.create(requestEntity);
    }

//    public <T> T findRange_XML(Class<T> responseType, String from, String to) throws UniformInterfaceException {
//        WebResource resource = webResource;
//        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
//        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
//    }
    @Override
    public <T> T findRange(Class<T> responseType, String from, String to) {

        return (T) localResource.get(responseType, from, to);
    }

//    public <T> T find_XML(Class<T> responseType, String id) throws UniformInterfaceException {
//        WebResource resource = webResource;
//        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
//        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
//    }
    @Override
    public <T> T find(Class<T> responseType, String id) {
        return (T) localResource.get(responseType, id);
    }

    @Override
    public MobiNotesClient createClient() {
        return new MobiNotesLocalClient();
    }
}
