/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.client;

/**
 *
 * @author Robert
 */
interface FileManager {



    boolean save(String json, String file_url);
    boolean edit(String newJson, String file_url);
    boolean delete(String file_url);
    
    String load(String file_url);
    
    String[] loadAll(String file_dir);
    
    String[] loadRange(String file_dir, String from, String to);
    
    String count(String file_dir);
}
