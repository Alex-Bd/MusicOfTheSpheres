package musicofspheres.cms.handleres.file.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Artist {

    private String id;
    private String name="";
    private List<Album> albums = new ArrayList<>();

    public void addAlbum(Album album){
        albums.add(album);
    }
    public boolean containsAlbum(String album){
        for(Album a:albums){
            if(a.getName().compareTo(album)==0)
                return true;
        }
        return false;
    }

}
