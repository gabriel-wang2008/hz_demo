package com.example.demo.viewObject;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserViewObject implements IViewObject{

    private String id;

    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String NON_NULL;
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    private String NON_ABSENT;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String NON_EMPTY;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int NON_DEFAULT;
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String USE_DEFAULTS;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNON_NULL() {
        return NON_NULL;
    }

    public void setNON_NULL(String NON_NULL) {
        this.NON_NULL = NON_NULL;
    }

    public String getNON_ABSENT() {
        return NON_ABSENT;
    }

    public void setNON_ABSENT(String NON_ABSENT) {
        this.NON_ABSENT = NON_ABSENT;
    }

    public String getNON_EMPTY() {
        return NON_EMPTY;
    }

    public void setNON_EMPTY(String NON_EMPTY) {
        this.NON_EMPTY = NON_EMPTY;
    }

    public int getNON_DEFAULT() {
        return NON_DEFAULT;
    }

    public void setNON_DEFAULT(int NON_DEFAULT) {
        this.NON_DEFAULT = NON_DEFAULT;
    }

    public String getUSE_DEFAULTS() {
        return USE_DEFAULTS;
    }

    public void setUSE_DEFAULTS(String USE_DEFAULTS) {
        this.USE_DEFAULTS = USE_DEFAULTS;
    }
}
