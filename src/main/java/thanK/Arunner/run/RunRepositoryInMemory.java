/**
 * 
 */
/*
 * package thanK.Arunner.run;
 * 
 * import java.time.LocalDateTime; import java.time.temporal.ChronoUnit; import
 * java.util.ArrayList; import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * import jakarta.annotation.PostConstruct;
 * 
 *//**
    * @author JONATHAN
    *//*
       * @Repository public class RunRepositoryInMemory {
       * 
       * private List<Run> runs = new ArrayList<>();
       * 
       * List<Run> findAll() { return runs; }
       * 
       * // initialization, // populating data to list before calling it
       * 
       * @PostConstruct private void init() { runs.add(new Run(1,
       * "Monday Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(30,
       * ChronoUnit.MINUTES), 4, Location.INDOOR));
       * 
       * runs.add(new Run(2, "Wensday Evening Run", LocalDateTime.now(),
       * LocalDateTime.now().plus(60, ChronoUnit.MINUTES), 7, Location.INDOOR)); }
       * 
       * 
       * instead of returning Run, lets return Optional of Run Optional in java is
       * container object which may or not contain anon null value
       * 
       * Optional<Run> findById(Integer id) { return runs.stream().filter(run ->
       * run.id() == id).findFirst(); }
       * 
       * // creation void createRun(Run run) { runs.add(run); }
       * 
       * // update void updateRun(Run run, Integer id) { Optional<Run> existingruns =
       * findById(id); if (existingruns.isPresent()) {
       * runs.set(runs.indexOf(existingruns.get()), run); } }
       * 
       * // delete void delete(Integer id) { runs.removeIf(run ->
       * run.id().equals(id)); } }
       */