package musicofspheres.cms.database.music.results;


import lombok.Data;
import musicofspheres.cms.database.music.enity.Artist;
import org.springframework.data.neo4j.annotation.QueryResult;


@QueryResult
@Data
public class ArtistResult {

    Artist artist;

    public ArtistResult(Artist artist) {
        this.artist = artist;
    }
}
