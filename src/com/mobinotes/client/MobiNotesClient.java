package com.mobinotes.client;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Jersey REST client generated for REST resource:RecordFacadeREST [record]<br>
 *  USAGE:
 * <pre>
 *        RecordClient client = new RecordClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Robert
 */
public interface MobiNotesClient {
    
    
    public MobiNotesClient createClient();
    
    public void setPath(String path);

    public void remove(String id);

    public String count();
   
    public void edit(Object requestEntity);

    public void create(Object requestEntity);

    public <T> T findRange(Class<T> responseType, String from, String to);

    public <T> T find(Class<T> responseType, String id);
    
    public <T> T findAll(Class<T> responseType);
    
    
}
