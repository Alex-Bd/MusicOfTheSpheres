package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Song;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends Neo4jRepository<Song, Long> {

    @Query("MATCH (artist:Artist)-[:album]->(album:Album)-[:song]->(song:Song) " +
           "return case when artist.name={artist} and album.name={album} and song.name={song} " +
           "then true " +
           "else false end")
    boolean checkSong(@Param("artist") String artist,
                      @Param("album") String album,
                      @Param("song") String song);

    @Query("MATCH (artist:Artist)-[:album]->(album:Album) " +
           "WHERE artist.name={artist} and album.name={album} "+
           "MERGE (album)-[:song]->(song:Song {id:{id}, name:{name}}) " +
           "RETURN case when artist.name={artist} and album.name={album} and song.name={name} " +
           "then true " +
           "else false end")
    boolean addSong(@Param("artist") String artist,
                    @Param("album") String album,
                    @Param("id") String id,
                    @Param("name") String name);


    /** May have to rewrite to use "case" */
    @Query("MATCH (ar:Artist {name:{artist}})-[alb:album]->" +
            "(al:Album {name:{album}})-[son:song]->" +
            "(song:Song {name:{song}})" +
            "RETURN song")
    Song getSong(@Param("artist") String artist,
                 @Param("album") String album,
                 @Param("song") String song);
}
