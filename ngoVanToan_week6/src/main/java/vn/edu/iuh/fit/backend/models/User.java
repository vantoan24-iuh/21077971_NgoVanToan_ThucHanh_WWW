package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "getAllUser", query = "select u from User u"),
        @NamedQuery(name = "getUserById", query = "select u from User u where u.id = :id"),
        @NamedQuery(name = "updateUser", query = "update User u set u.firstName = :firstName, u.middleName = :middleName, u.lastName = :lastName, u.mobile = :mobile, u.email = :email, u.passwordHash = :passwordHash, u.registeredAt = :registeredAt, u.lastLogin = :lastLogin, u.intro = :intro, u.profile = :profile where u.id = :id"),
        @NamedQuery(name = "deleteUser", query = "delete from User u where u.id = :id")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstName", length = 50)
    private String firstName;

    @Column(name = "middleName", length = 50)
    private String middleName;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column(name = "mobile", length = 15)
    private String mobile;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "passwordHash", nullable = false, length = 32)
    private String passwordHash;

    @Column(name = "registeredAt", nullable = false)
    private Instant registeredAt;

    @Column(name = "lastLogin")
    private Instant lastLogin;

    @Lob
    @Column(name = "intro")
    private String intro;

    @Lob
    @Column(name = "profile")
    private String profile;
}