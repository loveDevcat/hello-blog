package com.example.helloblog.domain;

import javax.persistence.*;

@Table(name = "blog")
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String btitle;
    private String btime;
    private String bcontext;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer uid) {
        this.id = uid;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public String getBcontext() {
        return bcontext;
    }

    public void setBcontext(String bcontext) {
        this.bcontext = bcontext;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descrition) {
        this.description = descrition;
    }
}
