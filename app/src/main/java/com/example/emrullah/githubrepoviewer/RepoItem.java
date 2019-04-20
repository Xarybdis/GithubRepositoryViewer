package com.example.emrullah.githubrepoviewer;

import com.squareup.picasso.RequestCreator;

public class RepoItem {
    private String _ImageResource;
    private String _RepoText;
    private String _LanguageText;
    private String _repoHtmlUrl;

    public RepoItem(String imageResource, String repoText, String languageText,String repoHtml){
        _ImageResource=imageResource;
        _RepoText=repoText;
        _LanguageText=languageText;
        _repoHtmlUrl=repoHtml;
    }

    public String get_ImageResource() {
        return _ImageResource;
    }

    public void set_ImageResource(String _ImageResource) {
        this._ImageResource = _ImageResource;
    }

    public String get_RepoText() {
        return _RepoText;
    }

    public void set_RepoText(String _RepoText) {
        this._RepoText = _RepoText;
    }

    public String get_LanguageText() {
        return _LanguageText;
    }

    public void set_LanguageText(String _LanguageText) {
        this._LanguageText = _LanguageText;
    }

    public String get_repoHtmlUrl() {
        return _repoHtmlUrl;
    }
}
