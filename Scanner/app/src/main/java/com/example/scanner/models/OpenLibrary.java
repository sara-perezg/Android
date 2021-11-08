package com.example.scanner.models;

import java.util.List;

public class OpenLibrary {

    public int numFound;
    public int start;
    public boolean numFoundExact;
    public List<Doc> docs;
    public int num_found;
    public String q;
    public Object offset;

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public boolean isNumFoundExact() {
        return numFoundExact;
    }

    public void setNumFoundExact(boolean numFoundExact) {
        this.numFoundExact = numFoundExact;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    public int getNum_found() {
        return num_found;
    }

    public void setNum_found(int num_found) {
        this.num_found = num_found;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Object getOffset() {
        return offset;
    }

    public void setOffset(Object offset) {
        this.offset = offset;
    }
}
