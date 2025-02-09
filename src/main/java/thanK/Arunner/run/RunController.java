package thanK.Arunner.run;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

/*
 * class annotated with @RestController because
 * it responds to requests and returns responses
 * */
@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    private RunController(RunRepository runRepo) {
	this.runRepository = runRepo;
    }

    @GetMapping("/list")
    List<Run> findAll() {
	return runRepository.findAll();
    }

    @GetMapping("/{id}") // dynamic variables in the paths
    // @PathVariable picks whatever is in the path and assign it to this method
    Run findById(@PathVariable Integer id) {
	Optional<Run> run = runRepository.findById(id);

	if (run.isEmpty()) {
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}
	return run.get();
    }

    // Post method

    @ResponseStatus(HttpStatus.CREATED) // notifies that something is created

    @PostMapping("/new") // run is to come from request body eg JSON object
    // @RequestBody lets spring know the argument is coming from request body
    void createRun(@Valid @RequestBody Run run) {
	runRepository.createRun(run);
    }

    // put

    @ResponseStatus(HttpStatus.NO_CONTENT)

    @PutMapping("/{id}")
    void upDateRun(@Valid @RequestBody Run run, @PathVariable Integer id) {
	runRepository.updateRun(run, id);
    }

    // delete

    @ResponseStatus(HttpStatus.NO_CONTENT)

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
	runRepository.delete(id);
    }

}
