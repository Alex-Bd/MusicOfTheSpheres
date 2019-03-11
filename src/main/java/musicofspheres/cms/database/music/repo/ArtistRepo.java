package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Artist;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepo extends Neo4jRepository<Artist, Long> {


    @Query("MATCH (r:Root)-[:module]->(m:Music) " +
            "MERGE (m)-[:artist]->(a:Artist {name:{artist}, image:{image}})" +
            "RETURN exists( (m)-[]-(a) )")
    boolean createArtist(@Param("artist") String artist,
                         @Param("image") String image);

    @Query("MATCH (r:Root)-[:module]->(m:Music) " +
            "MERGE (m)-[:artist]->(a:Artist {name:{artist}})" +
            "RETURN exists( (m)-[]-(a) )")
    boolean createArtist(@Param("artist") String artist);


    @Query("MATCH (artist:Artist {name:{artist}}) " +
            "RETURN artist")
    Artist getArtist(@Param("artist") String artist);

    @Query("MATCH (artist:Artist)-[]-(album:Album {name:{album}}) " +
            "RETURN artist")
    List<Artist> getArtistOfAlbum(@Param("album") String album);

}
