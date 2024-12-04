package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "toDate")
    private LocalDate toDate;

    @Column(name = "fromDate")
    private LocalDate fromDate;

    @Column(name = "companyName", length = 50)
    private String companyName;

    @Column(name = "workDescription", length = 50)
    private String workDescription;

    @Column(name = "role", length = 50)
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "can_id")
    private Candidate can;

    public Experience() {
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", toDate=" + toDate +
                ", fromDate=" + fromDate +
                ", companyName='" + companyName + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", role='" + role + '\'' +
                ", can=" + can +
                '}';
    }
}