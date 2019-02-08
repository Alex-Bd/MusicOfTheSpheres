package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.enity.Album;
import musicofspheres.cms.database.music.results.AlbumResult;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlbumRepo extends Neo4jRepository<Album, Long> {

   @Query("MATCH (artist:Artist {name:{artist}})-[al:Album]-" +
                "(album:Album {name:{album}})-[s:Song]-" +
                "(song:Song)" +
                "RETURN album , collect(song) as songs,collect(s),collect(al)")
   AlbumResult getAlbum(@Param("artist") String artist,
                        @Param("album") String album);

}
