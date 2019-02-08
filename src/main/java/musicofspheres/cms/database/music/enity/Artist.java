package musicofspheres.cms.database.music.enity;

import lombok.Data;
import java.util.List;


@Data
public class Artist {

    Long id;
    String name;
    String image;
    List<Album> albums;

    public Artist(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
