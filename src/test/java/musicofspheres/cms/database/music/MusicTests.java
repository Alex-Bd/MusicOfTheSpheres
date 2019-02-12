package musicofspheres.cms.database.music;

import musicofspheres.cms.database.music.repo.AlbumRepo;
import musicofspheres.cms.database.music.repo.ArtistRepo;
import musicofspheres.cms.database.music.repo.SongRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MusicTests {

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    ArtistRepo artistRepo;
    @Autowired
    AlbumRepo albumRepo;
    @Autowired
    SongRepo songRepo;

    @Before
    public void setUp(){
        Session session;
        session = sessionFactory.openSession();
        //System.out.println(sessionFactory.metaData().toString());
        //session.purgeDatabase();
        session.query("create (r:Root)-[:music]->(m:Music)", new HashMap<>());
    }


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

        songRepo.addSong("test","testAlbum","testSong");

       assertEquals(songRepo.getSong("test","testAlbum","testSong").getName(),"testSong");



    }







}
