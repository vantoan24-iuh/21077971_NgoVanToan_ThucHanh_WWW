package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.ids.CandidateSkillId;

@Getter
@Setter
@Entity
@Table(name = "candidate_skill")
public class CandidateSkill {
    @EmbeddedId
    private CandidateSkillId id;

    @MapsId("canId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate can;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Column(name = "skill_level", nullable = false)
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;

    public CandidateSkill() {
    }

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "id=" + id +
                ", can=" + can +
                ", moreInfos='" + moreInfos + '\'' +
                ", skillLevel=" + skillLevel +
                '}';
    }
}