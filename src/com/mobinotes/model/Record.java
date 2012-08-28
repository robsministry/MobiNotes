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
public class Record implements MobiNotesEntity{

    private StringProperty id;
    private StringProperty col_1;
    private StringProperty col_2;
    private StringProperty col_3;
    private StringProperty col_4;
    private StringProperty setid;
    
    public Record() {
        
    }
    
    public StringProperty idProperty() {
        if(id == null) {
            id = new SimpleStringProperty();
        }
        return id;
    }
    @Override
    public void setId(String value) {
        idProperty().set(value);
    }
    @Override
    public String getId() {
        if(id == null) {
            return null;
        }
        return id.get();
    }
    
    public StringProperty col_1Property() {
        if(col_1 == null) {
            col_1 = new SimpleStringProperty();
        }
        return col_1;
    }
    public void setCol_1(String value) {
        col_1Property().set(value);
    }  
    public String getCol_1() {
        if(col_1 == null) {
            return null;
        } else {
            return col_1.get();            
        }
    }
    
    public StringProperty col_2Property() {
        if(col_2 == null) {
            col_2 = new SimpleStringProperty();
        }
        return col_2;
    }
    public void setCol_2(String value) {
        col_2Property().set(value);
    }  
    public String getCol_2() {
        if(col_2 == null) {
            return null;
        } else {
            return col_2.get();            
        }

    }
    
    public StringProperty col_3Property() {
        if(col_3 == null) {
            col_3 = new SimpleStringProperty();
        }
        return col_3;
    }
    public void setCol_3(String value) {
        col_3Property().set(value);
    }  
    public String getCol_3() {
        if(col_3 == null) {
            return null;
        } else {
            return col_3.get();            
        }
    }
    
    public StringProperty col_4Property() {
        if(col_4 == null) {
            col_4 = new SimpleStringProperty();
        }
        return col_4;
    }
    public void setCol_4(String value) {
        col_4Property().set(value);
    }  
    public String getCol_4() {
        if(col_4 == null) {
            return null;
        } else {
            return col_4.get();
        }
    }
    
    public StringProperty setidProperty() {
        if(setid == null) {
            setid = new SimpleStringProperty();
        }
        return setid;
    }
    public void setSetid(String value) {
        setidProperty().set(value);
    }
    public String getSetid() {
        if(setid == null) {
            return null;
        }
        else {
            return setid.get();
        }
    }
    
    @Override
    public JSONObject toJSON() {
        JSONObject jsonnote = new JSONObject();
        try {
            if(getSetid() != null) {
                jsonnote.put(KEY_SETID, getSetid());
            }
            if(getCol_1() != null) {
                jsonnote.put(KEY_COL1, getCol_1());
            }
            if(getCol_2() != null) {
                jsonnote.put(KEY_COL2, getCol_2());
            }
            if(getCol_3() != null) {
                jsonnote.put(KEY_COL3, getCol_3());
            }
            if(getCol_4() != null) {
                jsonnote.put(KEY_COL4, getCol_4());
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
                 if(jsono.has(KEY_ID)) { setId(Integer.toString(jsono.getInt(KEY_ID)));} 
                 if(jsono.has(KEY_SETID)) { setSetid(Integer.toString(jsono.getInt(KEY_SETID)));} 
                 if (jsono.has(KEY_COL1)) {setCol_1(jsono.getString(KEY_COL1));}
                 if (jsono.has(KEY_COL2)) {setCol_2(jsono.getString(KEY_COL2));}
                 if (jsono.has(KEY_COL3)) {setCol_3(jsono.getString(KEY_COL3));}
                 if (jsono.has(KEY_COL4)) {setCol_4(jsono.getString(KEY_COL4));}                 
            } catch (JSONException ex) {
                Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
       @Override
    public String toString() {
        return toJSON().toString();
    }
}
