package com.society.backend.entity;

import com.society.backend.entity.enumerated.UserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Enumerated
    private UserRole role = UserRole.USER;

    private Boolean isActive = true;

    public User(String firstname, String lastname, String username, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }

}