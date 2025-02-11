/**
 * 
 */
package thanK.Arunner.run;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import thanK.Arunner.app.ArunnerApplication;

/**
 * @author JONATHAN
 */
@Repository
public class RunRepository {

    private static final Logger log = LoggerFactory.getLogger(ArunnerApplication.class);

    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
	this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
	return jdbcClient.sql("Select * from run").query(Run.class).list();
    }

    public Optional<Run> findById(Integer id) {
	return jdbcClient.sql("select id,title,started_On,completed_On,miles,location FROM run WHERE id= :id")
		.param("id", id).query(Run.class).optional();
    }

    public void createRun(Run run) {
	var updated = jdbcClient
		.sql("INSERT INTO Run(id,title,started_On,completed_On,miles,location)VALUES(?,?,?,?,?,?)")
		.params(List.of(run.id(), run.title(), run.startedOn(), run.completedOn(), run.miles(),
			run.location().toString()))
		.update();

	Assert.state(updated == 1, "Failed To Create Run" + run.title());
    }

    public void updateRun(Run run, Integer id) {
	var updated = jdbcClient
		.sql("UPDATE run set title=?,started_On=?,completed_On=?,miles=?,location=? WHERE id =?")
		.params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(),
			id))
		.update();

	Assert.state(updated == 1, "Failed To Update Run" + run.title());
    }

    public void delete(Integer id) {
	var updated = jdbcClient.sql("DELETE FROM run WHERE id = :id").param("id", id).update();
	Assert.state(updated == 1, "Failed To Delete Run" + id);
    }

    public int count() {
	return jdbcClient.sql("SELECT * FROM run").query().listOfRows().size();
    }

    public void saveAll(List<Run> runs) {
	runs.stream().forEach(this::createRun);
    }

    public List<Run> findByLocation(String location) {
	return jdbcClient.sql("SELECT * FROM run WHERE location =:location").param("location", location)
		.query(Run.class).list();
    }
}
