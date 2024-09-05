package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResault;
import kodlamaio.hrms.core.utilities.results.Resault;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAll")
    public DataResault<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @PostMapping("/add")
    public Resault add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @PostMapping("/disable/{jobAdvertisementId}")
    public Resault disableJobAdvertisement(@PathVariable int jobAdvertisementId) {
        return this.jobAdvertisementService.setJobAdvertisementStatusFalse(jobAdvertisementId);
    }

    @GetMapping("/getActiveAdvertisements")
    public DataResault<List<JobAdvertisement>> getActiveAdvertisements() {
        return this.jobAdvertisementService.findByStatusTrue();
    }

    @GetMapping("/getActiveAdvertisementsByCompanyName/{companyName}")
    public DataResault<List<JobAdvertisement>> getActiveAdvertisementsByCompanyName(@PathVariable String companyName) {
        return this.jobAdvertisementService.findByEmployerCompanyNameIsAndStatusTrue(companyName);
    }

    @GetMapping("/getActiveAdvertisementsOrderByStartDate")
    public DataResault<List<JobAdvertisement>> getActiveAdvertisementsOrderByStartDate() {
        return this.jobAdvertisementService.findByStatusTrueOrderByApplicationStart();
    }
}
