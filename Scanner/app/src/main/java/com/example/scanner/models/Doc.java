package com.example.scanner.models;

import java.util.List;

public class Doc {
    String key;
    String work;
    List<String> seed;
    String title;
    String title_suggest;
    Boolean has_fulltext;
    Integer edition_count;
    List<String> edition_key;
    List<String> publish_date;
    List<String> publish_year;
    List<String> first_publish_year;
    List<String> isbn;
    String last_modified_i;
    Integer ebook_count_i;
    String cover_edition_key;
    Integer cover_i;
    List<String> publisher;
    List<String> publisher_facet;
    Long _version_;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public List<String> getSeed() {
        return seed;
    }

    public void setSeed(List<String> seed) {
        this.seed = seed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_suggest() {
        return title_suggest;
    }

    public void setTitle_suggest(String title_suggest) {
        this.title_suggest = title_suggest;
    }

    public Boolean getHas_fulltext() {
        return has_fulltext;
    }

    public void setHas_fulltext(Boolean has_fulltext) {
        this.has_fulltext = has_fulltext;
    }

    public Integer getEdition_count() {
        return edition_count;
    }

    public void setEdition_count(Integer edition_count) {
        this.edition_count = edition_count;
    }

    public List<String> getEdition_key() {
        return edition_key;
    }

    public void setEdition_key(List<String> edition_key) {
        this.edition_key = edition_key;
    }

    public List<String> getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(List<String> publish_date) {
        this.publish_date = publish_date;
    }

    public List<String> getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(List<String> publish_year) {
        this.publish_year = publish_year;
    }

    public List<String> getFirst_publish_year() {
        return first_publish_year;
    }

    public void setFirst_publish_year(List<String> first_publish_year) {
        this.first_publish_year = first_publish_year;
    }

    public List<String> getIsbn() {
        return isbn;
    }

    public void setIsbn(List<String> isbn) {
        this.isbn = isbn;
    }

    public String getLast_modified_i() {
        return last_modified_i;
    }

    public void setLast_modified_i(String last_modified_i) {
        this.last_modified_i = last_modified_i;
    }

    public Integer getEbook_count_i() {
        return ebook_count_i;
    }

    public void setEbook_count_i(Integer ebook_count_i) {
        this.ebook_count_i = ebook_count_i;
    }

    public String getCover_edition_key() {
        return cover_edition_key;
    }

    public void setCover_edition_key(String cover_edition_key) {
        this.cover_edition_key = cover_edition_key;
    }

    public Integer getCover_i() {
        return cover_i;
    }

    public void setCover_i(Integer cover_i) {
        this.cover_i = cover_i;
    }

    public List<String> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<String> publisher) {
        this.publisher = publisher;
    }

    public List<String> getPublisher_facet() {
        return publisher_facet;
    }

    public void setPublisher_facet(List<String> publisher_facet) {
        this.publisher_facet = publisher_facet;
    }

    public Long get_version_() {
        return _version_;
    }

    public void set_version_(Long _version_) {
        this._version_ = _version_;
    }
}
