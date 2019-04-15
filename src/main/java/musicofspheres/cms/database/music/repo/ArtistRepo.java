package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Artist;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepo extends Neo4jRepository<Artist, Long> {


    @Query("MATCH (m:Music)-[:artist]->(artist:Artist) " +
           "return case artist.name " +
           "when {artist} "+
           "then true " +
           "else false end")
    boolean checkArtist(@Param("artist") String artist);


    @Query( "MATCH (r:Root)-[:module]->(m:Music) " +
            "MERGE (m)-[:artist]->(artist:Artist {id:{id}, name:{name}})" +
            "return case artist.name " +
            "when {name} "+
            "then true " +
            "else false end")
    boolean addArtist(@Param("id") String id,
                      @Param("name") String name);


    /** May have to rewrite to use "case" */
    @Query("MATCH (m:Music)-[:artist]->(artist:Artist) " +
           "where artist.name = {artist} " +
           "return artist")
    Artist getArtist(@Param("artist") String artist);

}
