package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Album;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbumRepo extends Neo4jRepository<Album, Long> {

    @Query("MATCH (artist:Artist {name:{artist}})-[al:album]-" +
            "(album:Album {name:{album}})" +
            "RETURN album")
    Album getAlbum(@Param("artist") String artist,
                   @Param("album") String album);

    @Query("MATCH (artist:Artist {name:{artist}}) " +
            "MERGE (artist)-[:album]->(album:Album {name: {album}})")
    void addAlbum(@Param("artist") String artist,
                  @Param("album") String album);

}
