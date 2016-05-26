package com.quisy.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

/**
 * Created by lampr on 18.05.2016.
 */

@Entity
@Table(name = "Stories")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String text;


    //@JoinColumn(name="ownerId")
    @ManyToOne
    private User owner;

//    @Column(name="ownerId", updatable=false, insertable=false)
//    private Long ownerId;


    public Story(){}

    @JsonCreator
    public Story(@JsonProperty("owner") User owner){
        this.owner = owner;
    }


    // GETTERS AND SETTERS


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Long getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(Long ownerId) {
//        this.ownerId = ownerId;
//    }
}
