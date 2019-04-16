package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Artist;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepo extends Neo4jRepository<Artist, Long> {


    @Query("MATCH (m:Music)-[:artist]->(artist:Artist) " +
           "WHERE artist.name = {artist}" +
           "RETURN exists((m)-[]->(artist)) ")
    Optional<Boolean> checkArtist(@Param("artist") String artist);


    @Query( "MATCH (r:Root)-[:module]->(m:Music) " +
            "MERGE (m)-[:artist]->(artist:Artist {id:{id}, name:{name}})" +
            "RETURN exists((m)-[]->(artist))")
    Optional<Boolean> addArtist(@Param("id") String id,
                      @Param("name") String name);


    /** May have to rewrite to use "case" */
    @Query("MATCH (m:Music)-[:artist]->(artist:Artist) " +
           "WHERE artist.name = {artist} " +
           "RETURN artist")
    Optional<Artist> getArtist(@Param("artist") String artist);

}
