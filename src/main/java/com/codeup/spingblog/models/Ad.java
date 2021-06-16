package com.codeup.spingblog.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //All ads have a ad.title
    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToOne
    private User owner;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
    private List<AdImage> images;


    public Ad() {
    }

    public Ad(long id, String title, String description, User user, List<AdImage> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public Ad(String title, String description, User owner, List<AdImage> images) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AdImage> getImages() {
        return images;
    }

    public void setImages(List<AdImage> images) {
        this.images = images;
    }

    public static User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
