package musicofspheres.cms.database.music.results;

import lombok.Data;
import musicofspheres.cms.database.music.enity.Artist;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@QueryResult
@Data
public class AllMusicResult {

    List<Artist> artists;

}
