/**
 * 
 */
package thanK.Arunner.run;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import thanK.Arunner.app.ArunnerApplication;

/**
 * reads from json file
 * 
 * @author JONATHAN
 */
@Component
public class RunJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ArunnerApplication.class);
    private final RunRepository runRepository;
    private final ObjectMapper objectMapper;

    private RunJsonDataLoader(RunRepository runRepo, ObjectMapper objectMapper) {
	this.runRepository = runRepo;
	this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
	if (runRepository.count() == 0) {
	    try (InputStream inputstream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
		Runs allruns = objectMapper.readValue(inputstream, Runs.class);
		log.info("Reading {} runs from json data and saving to inmemory collection.", allruns.runs().size());
		runRepository.saveAll(allruns.runs());
	    } catch (IOException e) {
		throw new RuntimeException("Failed to resd JSON data", e);
	    }

	} else {
	    log.info("No loading runs from JSON because collection.");
	}
    }

}
