package musicofspheres.cms.database.music.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String path;



}
