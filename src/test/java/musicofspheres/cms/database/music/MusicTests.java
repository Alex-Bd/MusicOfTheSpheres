package musicofspheres.cms.database.music;

import lombok.AllArgsConstructor;
import lombok.Data;
import musicofspheres.cms.database.music.enity.Artist;
import musicofspheres.cms.database.music.repo.AlbumRepo;
import musicofspheres.cms.database.music.repo.ArtistRepo;
import musicofspheres.cms.database.music.repo.ArtistResultRepo;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.harness.junit.Neo4jRule;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MusicTests {


    @Rule
    public Neo4jRule neoServer = new Neo4jRule();
    private Session session;

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    ArtistRepo artistRepo;
    @Autowired
    ArtistResultRepo resultRepo;
    @Autowired
    AlbumRepo albumRepo;

    @Before
    public void setUp() throws Exception {
        session = sessionFactory.openSession();
        session.purgeDatabase();
        session.query("create (r:Root)-[:music]->(m:Music)", new HashMap<String, Object>());
    }

    @Test
    public void createArtistTest() {
        artistRepo.createArtist("test","image");
         artistRepo.createArtist("test1","image");
         artistRepo.createArtist("test2","image");

        assertEquals(artistRepo.getArtist("test").getName(),"test");
        albumRepo.addAlbum("test","testAlbum");
         albumRepo.addAlbum("test1","testAlbum");
         albumRepo.addAlbum("test2","testAlbum3");

        assertEquals(albumRepo.getAlbum("test","testAlbum").getName(),"testAlbum");

        assertEquals(artistRepo.getArtistOfAlbum("testAlbum").size(),2);
    }







}
