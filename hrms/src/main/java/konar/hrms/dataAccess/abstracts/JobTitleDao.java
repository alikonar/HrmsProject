package konar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import konar.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{

}
