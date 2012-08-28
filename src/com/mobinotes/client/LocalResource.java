/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.client;

import com.mobinotes.model.MobiNotesEntity;
import com.mobinotes.model.Record;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Robert
 * An interface for building requests. 
 * The build methods for constructing the request from the built information are left undefined and implementations must define such methods.
 */
//TODO static class or methods
public abstract class LocalResource {
    
    LocalResourceConfig config;
    private FileManager fm;
    String path;

    public LocalResource(String path) {
        this.path = path;
        this.config = new LocalResourceConfig();

        this.fm = new FileManagerImpl();
//        try {
//            
//            Class c = Class.forName(path);
//            o = (T) c.newInstance();
//        } catch (InstantiationException ex) {
//            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    String count() {
        String fileDir = new LocalResourceConfig.Builder(path).baseURI().arg(0).build();
        String capacity = fm.count(fileDir);
        
        return capacity;
    }
    
    void delete(String id) {
        fm.delete(getEntityPath(id));
    }

    void edit(Object requestEntity) {
        MobiNotesEntity entity = (MobiNotesEntity) requestEntity;
        String id = entity.getId();
        fm.save(entity.toString(), getEntityPath(id));
    }

    void create(Object requestEntity) {
        MobiNotesEntity entity = createNewEntity(requestEntity);
        fm.save(entity.toString(), getEntityPath(entity.getId()));
    }

    <T> T get(Class<T> responseType, String id) {
        T entity = null;
        
        String entityPath = getEntityPath(id);

        
        String json = fm.load(getEntityPath(id));
        JSONObject jsonObj;
        try {
            jsonObj = new JSONObject(json);
            entity = createEntity(responseType, jsonObj);

            Record r = (Record) entity;
            
            r.col_3Property();
        } catch (JSONException ex) {
            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }

    <T> T get(Class<T> responseType) {

//        switch(responseType.getSimpleName()) {
//            case "JSONArray": {};
//        }
        String[] keys = getIds();

        return (T) loadToJSON(keys);
    }

    <T> T get(Class<T> responseType, String from, String to) {
        String[] keys = getIds(from, to);
        

        return (T) loadToJSON(keys);
    }

    //TODO exception handling
    String increaseAndSaveCounter(Class c) {

        String key;
        String counter;
        String nextCounter;
        
        counter = getCurrentCounter();

        nextCounter = increaseCounter(counter);
        saveNextCounter(nextCounter);

        return nextCounter;
    }

    String getEntityPath(String id) {
        return new LocalResourceConfig.Builder(path, id)
                .baseURI().arg(0).slash().arg(1)
                .build();
    }

    private String[] getIds() {

        String[] allEntities = null;
        String dir = new LocalResourceConfig.Builder(path).
                baseURI().
                arg(0).
                build();
        allEntities = fm.loadAll(dir);

        return allEntities;
    }
    
    private String[] getIds(String from, String to) {
        String[] allEntities = null;
        String dir = new LocalResourceConfig.Builder(path).
                baseURI().
                arg(0).
                build();
        
        allEntities = fm.loadRange(dir, from, to);
        
        return allEntities;
       
    }
    
    private String increaseCounter(String counter) {
        int number = Integer.valueOf(counter);
        ++number;

        return Integer.toString(number);
    }
    
    private <T> T createEntity(Class<T> responseType, JSONObject o) {
        
        T entity = null;
        try {
            entity = responseType.newInstance();
            Method fromJson = responseType.getMethod("fromJSON", JSONObject.class);
            fromJson.invoke(entity, o);
        } 
        catch (IllegalArgumentException ex) {
            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (InvocationTargetException ex) {
            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (NoSuchMethodException ex) {
            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SecurityException ex) {
            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) {
            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) {
            Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return entity;
    }

    private MobiNotesEntity createNewEntity(Object requestEntity) {
        MobiNotesEntity entity = (MobiNotesEntity) requestEntity;
        String newId = increaseAndSaveCounter(entity.getClass());
        entity.setId(newId);
        return entity;
    }    
    
    
    abstract String getCurrentCounter();
    abstract Properties getSequenceProperties();
    abstract void saveNextCounter(String nextCounter);

    private JSONArray loadToJSON(String[] keys) {
        JSONArray jsonArray = new JSONArray();
         try {  
                for (int i=0; i<keys.length; i++) {

                String key = keys[i];
                    System.out.println("Key " + key);
                String json = fm.load(getEntityPath(key));
                jsonArray.put(new JSONObject(json));
                }
            } catch (JSONException ex) {
                Logger.getLogger(LocalResource.class.getName()).log(Level.SEVERE, null, ex);
            }
         return jsonArray;

        }
    
}
