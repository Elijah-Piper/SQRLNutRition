package com.genspark.SQRLNutRitionAPI.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

    @Id
    @Column(name="username")
    private String username;

//    private String password; *** TO BE REVISED UPON SECURITY ENCRYPTION METHOD DETERMINATION ***

    @OneToMany(mappedBy = "user")
    private List<Squirrel> squirrels;

    private LocalDateTime createdOn;

    public User(String username, List<Squirrel> squirrels) {
        this.username = username;
        this.squirrels = squirrels;
        this.createdOn = LocalDateTime.now();
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Squirrel> getSquirrels() {
        return squirrels;
    }

    public void setSquirrels(List<Squirrel> squirrels) {
        this.squirrels = squirrels;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", squirrels=" + squirrels +
                ", createdOn=" + createdOn +
                '}';
    }
}
