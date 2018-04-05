package nl.datavisual.api;

import nl.datavisual.dto.CompanyDTO;
import nl.datavisual.service.CompanyService;
import nl.datavisual.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class CompanyController {
    Logger log = LoggerFactory.getLogger(CompanyController.class);

    private UserService userService;
    private CompanyService companyService;

    public CompanyController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping(path = "/allcompanies")
    public List<CompanyDTO> getAllCompanies() {

        log.debug("Get all companies");
        return companyService.getAllCompanies();
    }

}