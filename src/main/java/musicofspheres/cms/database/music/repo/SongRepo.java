package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Song;
import musicofspheres.cms.database.music.results.SongResult;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends Neo4jRepository<Song, Long>{


    @Query("MATCH (ar:Artist {name:{artist}})-[alb:Album]->" +
                 "(al:Album {name:{album}})-[son:Song]->" +
                 "(song:Song {name:{song}})" +
                 "RETURN song")
    SongResult getSong(@Param("artist")String artist,
                       @Param("album") String album,
                       @Param("song") String song);



}
