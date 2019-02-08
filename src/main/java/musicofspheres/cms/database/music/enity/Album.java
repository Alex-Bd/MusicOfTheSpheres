package musicofspheres.cms.database.music.enity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;


@Data
@NodeEntity
public class Album {

    @Id
    @GeneratedValue
    Long id;
    String name;
    @Relationship(type="song")
    List<Song> songs;
}
