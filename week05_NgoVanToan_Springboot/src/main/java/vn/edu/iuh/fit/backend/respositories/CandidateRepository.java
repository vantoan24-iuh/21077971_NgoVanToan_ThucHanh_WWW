package vn.edu.iuh.fit.backend.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.entities.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    public Candidate findByEmail(String email);
}
