package musicofspheres.cms.database.music.results;


import lombok.Data;
import lombok.NoArgsConstructor;
import musicofspheres.cms.database.music.enity.Artist;
import org.springframework.data.neo4j.annotation.QueryResult;


@QueryResult
@Data
@NoArgsConstructor
public class ArtistResult {

Long id;
    String name;


/*
    Artist artist;

    public ArtistResult(Artist artist) {
        this.artist = artist;
    }*/
}
