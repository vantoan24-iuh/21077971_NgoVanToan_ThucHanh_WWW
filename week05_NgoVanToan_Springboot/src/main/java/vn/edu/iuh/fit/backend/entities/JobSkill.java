package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.ids.JobSkillId;

@Getter
@Setter
@Entity
@Table(name = "job_skill")
public class JobSkill {
    @EmbeddedId
    private JobSkillId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Column(name = "skill_level", nullable = false)
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;

    public JobSkill() {
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "id=" + id +
                ", job=" + job +
                ", moreInfos='" + moreInfos + '\'' +
                ", skillLevel=" + skillLevel +
                '}';
    }
}