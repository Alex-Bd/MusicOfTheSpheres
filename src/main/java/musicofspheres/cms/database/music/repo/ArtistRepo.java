package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Artist;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepo   extends Neo4jRepository<Artist, Long> {


    @Query("match (r:Root)-[:Music]->(m:Music) " +
           "create (m)-[:Artist]->(a:Artist {name:{artist}, image:{image}})")
    void createArtist(@Param("artist") String artist,
                      @Param("image") String image);

    @Query("MATCH (artist:Artist {name:{artist}}) " +
            "return artist")
    Artist getArtist(@Param("artist") String artist);

    @Query("MATCH (artist:Artist)-[]-(album:Album {name:{album}}) " +
            "return artist")
    List<Artist> getArtistOfAlbum(@Param("album") String album);

}
