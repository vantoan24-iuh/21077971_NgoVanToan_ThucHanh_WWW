package vn.edu.iuh.fit.backend.services;

import org.springframework.data.domain.Page;
import vn.edu.iuh.fit.backend.entities.Candidate;

import java.util.List;

public interface CandidateServiceImp {
    Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);
    List<Candidate> findAllNoPage();

}
