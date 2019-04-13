package musicofspheres.cms.database.music.enity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;


@Data
@NoArgsConstructor
@NodeEntity
public class Artist {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String image;
    @Relationship(type="album")
    List<Album> albums;

    public Artist(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
