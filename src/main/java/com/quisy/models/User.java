package com.quisy.models;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by lampr on 17.05.2016.
 */
@Entity
@Table(name = "Users")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String email;

    private String name;

    private String surname;

    @NotNull
    private String nickName;


    private byte[] avatar;

    @Length.List({
            @Length(min = 5, message = "The field must be at least 5 characters"),
            @Length(max = 50, message = "The field must be less than 50 characters")
    })
    @NotNull
    @JsonIgnore
    private String password;

    @NotNull
    @ManyToOne
    private Role role;

    @OneToMany (mappedBy = "owner")
    private List<Story> stories;


    public User(){}

    @JsonCreator
    public User(@JsonProperty("role") Role role)
    {
        this.role = role;
    }

    //GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
