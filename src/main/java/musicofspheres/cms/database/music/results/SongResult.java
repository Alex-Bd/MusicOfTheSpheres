package musicofspheres.cms.database.music.results;

import lombok.Data;
import musicofspheres.cms.database.music.enity.Song;
import org.springframework.data.neo4j.annotation.QueryResult;

@Data
@QueryResult
public class SongResult {

    Song song;
}
