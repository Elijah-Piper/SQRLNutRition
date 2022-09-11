package com.genspark.SQRLNutRitionAPI.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_table") // USER is a reserved keyword in H2 database (used for integration testing)
public class User {

    @Id
    @Column(name="username")
    private String username;

//    private String password; *** TO BE REVISED UPON SECURITY ENCRYPTION METHOD DETERMINATION ***

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Squirrel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "username_fk", referencedColumnName = "username")
    private List<Squirrel> squirrels;

    private LocalDateTime createdOn;

    public User() {
        this.createdOn = LocalDateTime.now();
        this.squirrels = new ArrayList<Squirrel>();
    }

    public void addSquirrel(Squirrel squirrel) {
        this.squirrels.add(squirrel);
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
