package com.example.emrullah.githubrepoviewer.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExampleModel {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("owner")
    @Expose
    public Owner owner;
    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
    @SerializedName("language")
    @Expose
    public Object language;
    @SerializedName("languages_url")
    @Expose
    public String languagesUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Object getLanguage() {
        return language;
    }

    public void setLanguage(Object language) {
        this.language = language;
    }

    public String getLanguagesUrl() {
        return languagesUrl;
    }

    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

