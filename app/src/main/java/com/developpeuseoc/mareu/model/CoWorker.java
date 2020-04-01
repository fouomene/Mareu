package com.developpeuseoc.mareu.model;

public class CoWorker {

    private String avatarUrl;
    private String name;
    private String email;

    public CoWorker(String avatarUrl, String name, String email) {
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
