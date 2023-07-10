package com.careers.app;

import java.io.File;

public class Employee_ORG_Logo {

    String key;
    File imagefile;

    public Employee_ORG_Logo(String key, File imagefile) {
        this.key = key;
        this.imagefile = imagefile;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public File getImagefile() {
        return imagefile;
    }

    public void setImagefile(File imagefile) {
        this.imagefile = imagefile;
    }
}
