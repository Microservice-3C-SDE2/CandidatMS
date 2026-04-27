package esprit.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatController {
    @Autowired
    private CandidatService candidatService;
    public String hello ="Hello from candidatMs";


    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }
    @GetMapping("/jobs")
    public List<Job> getJobs() {
        return candidatService.getalljobs();
    }
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable("id") int id) {
        return candidatService.getjobbyid(id);
    }
    @GetMapping("/{id}/favorite-jobs")
    public List<Job> getFavoriteJobs(@PathVariable int id) {
        return candidatService.getFavoriteJobs(id);
    }
    @PostMapping("/{id}/favorite-jobs/{jobId}")
    public ResponseEntity<String> saveFavoriteJob(@PathVariable int id, @PathVariable
    int jobId) {
        Job job = candidatService.getjobbyid(jobId);
        if (job != null) {
            candidatService.saveFavoriteJob(id, jobId);
            return ResponseEntity.status(HttpStatus.OK).body("Job saved as favorite successfully.");
        } else {
            // Gérer le cas où le job n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Job not found with ID: " + jobId);
        }
    }
    @GetMapping("/favorites")
    public List<JobDTO> getFavoriteJobs() {
        return candidatService.getFavoriteJobs();
    }

}
