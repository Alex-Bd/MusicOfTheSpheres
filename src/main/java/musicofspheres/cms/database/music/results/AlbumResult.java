package musicofspheres.cms.database.music.results;

import lombok.Data;
import musicofspheres.cms.database.music.enity.Album;
import org.springframework.data.neo4j.annotation.QueryResult;


@QueryResult
@Data
public class AlbumResult {

    Album album;
}
