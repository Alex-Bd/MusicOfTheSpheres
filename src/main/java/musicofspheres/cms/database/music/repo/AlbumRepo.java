package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Album;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbumRepo extends Neo4jRepository<Album, Long> {


    @Query("MATCH (artist:Artist)-[:album]->(album:Album) " +
           "return case when artist.name={artist} and album.name={album} " +
           "then true " +
           "else false end")
    boolean checkAlbum(@Param("artist") String artist,
                       @Param("album") String album);

    @Query("MATCH (music:Music)-[:artist]->(artist:Artist) " +
           "where artist.name={artist}"+
           "MERGE (artist)-[:album]->(album:Album {id:{id},name: {name}})" +
           "RETURN case when artist.name={artist} and album.name={name} " +
           "then true " +
           "else false end")
    boolean addAlbum(@Param("artist") String artist,
                     @Param("id") String id,
                     @Param("name") String album);

    /** May have to rewrite to use "case" */
    @Query("MATCH (artist:Artist {name:{artist}})-[al:album]-" +
            "(album:Album {name:{album}})" +
            "RETURN album")
    Album getAlbum(@Param("artist") String artist,
                   @Param("album") String album);


}
