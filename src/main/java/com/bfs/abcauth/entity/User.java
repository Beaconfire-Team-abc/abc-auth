package com.bfs.abcauth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "user")
public class User implements Serializable {

    public User( String email, String password){
        this.userName = email;
        this.email = email;
        this.password = password;
        this.createDate = new Timestamp(System.currentTimeMillis());
        this.modificationDate = new Timestamp(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "modification_date")
    private Timestamp modificationDate;

//    @JsonIgnore
//    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
//    private Set<UserRole> userRoles = new HashSet<>();

    @Transient
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", createDate=" + createDate +
                ", modificationDate=" + modificationDate +
                '}';
    }
}
