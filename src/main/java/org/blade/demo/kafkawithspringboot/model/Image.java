package org.blade.demo.kafkawithspringboot.model;

public class Image {

    private final String createDate;
    private final byte[] data;
    private final String name;
    
    public Image(String createDate, String name, byte[] data) {
        this.createDate = createDate;
        this.name = name;
        this.data = data;
    }

    public String getCreateDate() {
        return createDate; 
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }

    //TODO need impl.
    public String getId() {
        return getCreateDate() + getName();  
    }






}