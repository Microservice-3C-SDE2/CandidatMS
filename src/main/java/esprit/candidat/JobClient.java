package esprit.candidat;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "JobMs")
public interface JobClient {

    @GetMapping("/jobs")
    public List<Job> getJobs();

    @GetMapping("/jobs/{id}")
    public Job getJob(@PathVariable("id") int id);
}
