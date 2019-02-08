package musicofspheres.cms.database.music;

import musicofspheres.cms.database.music.enity.Artist;
import musicofspheres.cms.database.music.repo.ArtistResultRepo;
import musicofspheres.cms.database.music.results.ArtistResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest

public class MusicTests {

    @Autowired
    ArtistResultRepo repo;

    @Test
    public void ArtistsPersistTest(){
    repo.save(new ArtistResult(new Artist(1l,"test1","image")));


    }


}
