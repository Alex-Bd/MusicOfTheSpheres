package musicofspheres.cms.database.music.repo;

import musicofspheres.cms.database.music.results.ArtistResult;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArtistResultRepo extends Neo4jRepository<ArtistResult, Long> {

    @Query("MATCH (artist:Artist {name:{artist}})-[a:Album]-" +
                 "(album:Album)-[al:Song]-" +
                 "(song:Song)" +
                 "return artist,collect(album) as albums, collect(song) as songs,collect(a),collect(al)")
    ArtistResult getArtist(@Param("artist") String artist);

    @Query("MATCH (artist:Artist)-[al:album]-(album:Album)-[s:song]-(song:Song) " +
            "  With artist, album, collect({name: song.name, id:id(song), path:song.path}) as songs " +
            "   return {name: artist.name, id: id(artist), " +
            "           albums:collect({id: id(album), " +
            "                           name:album.name, " +
            "                           songs:songs})} as artists")
    List<ArtistResult> getAllMusic();

}
