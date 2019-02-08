package musicofspheres.cms.database.music.enity;

import lombok.Data;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;


@Data
public class Album {
    Long id;
    String name;
    List<Song> songs;
}
