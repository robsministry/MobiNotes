/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobinotes.client;


/**
 *
 * @author Robert
 */
public class LocalResourceConfig {

    private static final String BASE_URI = "src/localdb/";
    private static final String EXT = ".mn";
    private static final String SEQUENCE_PROPERTIES = "src/sequences.properties";


    public static class Builder {
        
        private String[] args;
        
        private StringBuilder sb;
        
        public Builder(String... args) {
            this.args = args;
            sb = new StringBuilder();
        }
        
        public Builder baseURI() {
            sb.append(BASE_URI);
            return this;
        }
        
        public Builder ext() {
            sb.append(EXT);
            
            return this;           
        }
        
        public Builder arg(int index) {
            sb.append(args[index]);
            
            return this;
            
            
        }
        
        public String build() {
            
            String result = sb.toString();
            sb = new StringBuilder();
            return result;
        }

        public Builder slash() {
            sb.append("/");
            
            return this;
        }
        
    }

    public String getSequenceProperties() {
        return SEQUENCE_PROPERTIES;
    }

}
