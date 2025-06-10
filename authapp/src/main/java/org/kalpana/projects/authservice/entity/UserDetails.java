package org.kalpana.projects.authservice.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude ={"name","contacts", "addresses"} )
@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userdetails_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private String email;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private List<Address> addresses;

}
