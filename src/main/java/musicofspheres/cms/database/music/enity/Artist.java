package musicofspheres.cms.database.music.enity;

import lombok.Data;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;


@Data
public class Artist {

    Long id;
    String name;
    String image;
    List<Album> albums;
}
