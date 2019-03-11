package musicofspheres.cms.database.init;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitRepo extends Neo4jRepository<Void,Long> {

    @Query("MERGE (n:Root {id:0})" +
           "return n.id")
    int createRoot();

    @Query("MATCH (n:Root)" +
           "MERGE (n)-[:module]-(m:Music {id:1})" +
           "return exists((n)-[]-(m))")
    boolean createMusic();

}
