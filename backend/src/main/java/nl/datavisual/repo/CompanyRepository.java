package nl.datavisual.repo;


import nl.datavisual.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> getAllCompanyListByCompanyName(String companyName);
}
