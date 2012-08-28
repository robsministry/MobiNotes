/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.model;

import jsonentity.KeyInterface;
import org.json.JSONAble;

/**
 *
 * @author Robert
 */
public interface MobiNotesEntity extends JSONAble, KeyInterface {
    
    void setId(String id);
    
    String getId();
}
