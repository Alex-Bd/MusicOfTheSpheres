package musicofspheres.cms.handleres.file.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@QueryResult
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MusicListEntity {


    List<Artist> artists = new ArrayList<>();

    public void addArtist(Artist artist){
        artists.add(artist);
    }


    public List<Song> getSongs(){
        List<Song> songs = new LinkedList<>();
        for(Artist artist : artists){
            for(Album album:artist.getAlbums()){
                songs.addAll(album.getSongs());
            }
        }
    return songs;
    }
}
