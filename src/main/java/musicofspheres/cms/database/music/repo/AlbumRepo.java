package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Album;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AlbumRepo extends Neo4jRepository<Album, Long> {


    @Query("MATCH (artist:Artist)-[:album]->(album:Album) " +
            "WHERE artist.name={artist} AND album.name={album} " +
            "RETURN exists((artist)-[]->(album))")
    Optional<Boolean> checkAlbum(@Param("artist") String artist,
                                 @Param("album") String album);

    @Query("MATCH (music:Music)-[:artist]->(artist:Artist) " +
            "WHERE artist.name={artist}" +
            "MERGE (artist)-[:album]->(album:Album {id:{id},name: {name}})" +
            "RETURN exists((artist)-[]->(album))")
    Optional<Boolean> addAlbum(@Param("artist") String artist,
                               @Param("id") String id,
                               @Param("name") String album);

    /**
     * May have to rewrite to use "case"
     */
    @Query("MATCH (artist:Artist {name:{artist}})-[al:album]-" +
            "(album:Album {name:{album}})" +
            "RETURN album")
    Optional<Album> getAlbum(@Param("artist") String artist,
                             @Param("album") String album);


}
