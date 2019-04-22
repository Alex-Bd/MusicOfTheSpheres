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
    String id;
    String name;
    String image;
    @Relationship(type="album")
    List<Album> albums;

    public Artist(String id,String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
