package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Song;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends Neo4jRepository<Song, Long>{


    @Query("MATCH (ar:Artist {name:{artist}})-[alb:album]->" +
                 "(al:Album {name:{album}})-[son:song]->" +
                 "(song:Song {name:{song}})" +
                 "RETURN song")
    Song getSong(@Param("artist")String artist,
                       @Param("album") String album,
                       @Param("song") String song);

    @Query("MATCH (ar:Artist {name:{artist}})-[alb:album]->" +
                 "(al:Album {name:{album}}) "+
                 "create (al)-[:song]->(:Song {name:{song}})")
    void addSong(@Param("artist")String artist,
                         @Param("album") String album,
                         @Param("song") String song);

}
