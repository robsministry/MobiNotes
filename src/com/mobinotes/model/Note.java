/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Robert
 */
public final class Note implements MobiNotesEntity {

    private StringProperty name;
    private StringProperty id;
    private StringProperty cathegory;
//    private Date creationDate;
    private StringProperty status;

    public Note() {
    }    
    
    public String getName() {
        if(name == null) {
            return null;
        } else {
            return name.get();
        }

    }

    public void setName(String aName) {
        this.nameProperty().set(aName);
    }
    
    public StringProperty nameProperty() {
        if(name == null) {
            name = new SimpleStringProperty();
        }
        return name;
    }
    
    public StringProperty idProperty() {
        if(id == null) {
            id = new SimpleStringProperty();
        }
        return id;
    }

    public void setId(String value) {
        idProperty().set(value);
    }
    
    public String getId() {
        if(id == null) {
            return null;
        }
        return id.get();
    }
    
    public String getCathegory() {
        if(cathegory == null) {
            return null;
        } else {
            return cathegory.get();         
        }

    }

    public void setCathegory(String value) {
        cathegoryProperty().set(value);
    }
    
    public StringProperty cathegoryProperty() {
        if(cathegory == null) {
            cathegory = new SimpleStringProperty();
        }
        return cathegory;
    }

    
    public String getStatus() {
        if(status == null) {
            return null;
        }
        else {
            return status.get();
        }
    }

    public void setStatus(String value) {
        statusProperty().set(value);
    }
    
    public StringProperty statusProperty() {
        if(status == null) {
            status = new SimpleStringProperty();
        }
        return status;
    }


    @Override
    public JSONObject toJSON() {
        JSONObject jsonnote = new JSONObject();
        try {
            if(getName() != null) {
                jsonnote.put(KEY_NAME, getName());
            }
            if(getStatus() != null) {
                jsonnote.put(KEY_STATUS, getStatus());
            }
            if(getCathegory() != null) {
                jsonnote.put(KEY_CATHEGORY, getCathegory());
            }
            if(getId() != null) {
                jsonnote.put(KEY_ID, Integer.valueOf(getId()));
            }
        } catch (JSONException ex) {
            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jsonnote;
    }

    @Override
    public void fromJSON(JSONObject jsono) {
            
            try {
                 if(jsono.has(KEY_ID)) {
                       setId(Integer.toString(jsono.getInt(KEY_ID)));
                 } if (jsono.has(KEY_NAME)) {
                     setName(jsono.getString(KEY_NAME));
                 } if (jsono.has(KEY_STATUS)) {
                     setStatus(jsono.getString(KEY_STATUS));
                 } if (jsono.has(KEY_CATHEGORY)) {
                     setCathegory(jsono.getString(KEY_CATHEGORY));
                 }
            } catch (JSONException ex) {
                Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public String toString() {
        System.out.println(" TO STRING !!!!!!!!!!!!!!!!");
        return toJSON().toString();
    }
    
        
}
