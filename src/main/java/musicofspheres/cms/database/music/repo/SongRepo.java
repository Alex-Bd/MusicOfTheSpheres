package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Song;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepo extends Neo4jRepository<Song, Long> {

    @Query("MATCH (artist:Artist)-[:album]->(album:Album)-[:song]->(song:Song) " +
            "WHERE artist.name={artist} AND album.name={album} AND song.name={song} " +
            "RETURN exists((artist)-[]->(album)-[]->(song))")
    Optional<Boolean> checkSong(@Param("artist") String artist,
                                @Param("album") String album,
                                @Param("song") String song);

    @Query("MATCH (artist:Artist)-[:album]->(album:Album) " +
            "WHERE artist.name={artist} AND album.name={album} " +
            "MERGE (album)-[:song]->(song:Song {id:{id}, name:{name}}) " +
            "RETURN exists((album)-[]->(song))")
    Optional<Boolean> addSong(@Param("artist") String artist,
                              @Param("album") String album,
                              @Param("id") String id,
                              @Param("name") String name);


    /**
     * May have to rewrite to use "case"
     */
    @Query("MATCH (ar:Artist {name:{artist}})-[alb:album]->" +
            "(al:Album {name:{album}})-[son:song]->" +
            "(song:Song {name:{song}})" +
            "RETURN song")
    Optional<Song> getSong(@Param("artist") String artist,
                           @Param("album") String album,
                           @Param("song") String song);
}
