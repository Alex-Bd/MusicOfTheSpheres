package musicofspheres.cms.handleres.file.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Album {

    private String id;
    private String name="";
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song){
        songs.add(song);
    }
}
