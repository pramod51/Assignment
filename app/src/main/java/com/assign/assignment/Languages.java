package com.assign.assignment;

public class Languages {
    String name,nativeName;

    public Languages(String name, String nativeName) {
        this.name = name;
        this.nativeName = nativeName;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
