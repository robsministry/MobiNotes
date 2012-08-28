/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.client;

/**
 *
 * @author Robert
 */
public class EntityManager  {
    
//    private Class cl;
    private MobiNotesClient client;
    
    public EntityManager(String clientID, Class c) {  
        
        //TODO
        
        String path = c.getSimpleName().toLowerCase();

        client = ClientFactory.instance().createClient(clientID);
        client.setPath(path);
    }
 
    public void remove(String id) {
        client.remove(id);
    }
  
    public String count() {
        return client.count();
    }
  
    public void edit(Object requestEntity) {
        client.edit(requestEntity);
    }
   
    public void create(Object requestEntity) {
        client.create(requestEntity);
    }
    
    public <T> T findRange(Class<T> responseType, String from, String to) {
        return client.findRange(responseType, from, to);
    }
   
    public <T> T find(Class<T> responseType, String id) {
        return client.find(responseType, id);
    }
 
    public <T> T findAll(Class<T> responseType) {
        return client.findAll(responseType);
    }
    
}
