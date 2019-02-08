package musicofspheres.cms.database.music.results;


import lombok.Data;
import musicofspheres.cms.database.music.enity.Album;
import musicofspheres.cms.database.music.enity.Artist;
import musicofspheres.cms.database.music.enity.Song;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@QueryResult
@Data
public class ArtistResult {

    Artist artist;

}
