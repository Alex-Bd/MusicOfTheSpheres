package musicofspheres.cms.files;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FolderServiceTest {

    @Autowired
    FolderService service;

    @Before
    public void init(){
        service.createArtistFolder("TestForAlbum").subscribe();

    }

    @Test
    public void artistTest(){
        StepVerifier.create(service.createArtistFolder("TestForArtist"))
                .expectNext(true)
                .verifyComplete();
        StepVerifier.create(service.deleteArtistFolder("TestForArtist"))
                .expectNext(true)
                .verifyComplete();

    }

    @Test
    public void albumTest(){
        StepVerifier.create(service.createAlbumFolder("TestForAlbum","TestForAlbum"))
                .expectNext(true)
                .verifyComplete();
        StepVerifier.create(service.deleteAlbumFolder("TestForAlbum","TestForAlbum"))
                .expectNext(true)
                .verifyComplete();
    }
    @After
    public void finish(){
        service.deleteArtistFolder("TestForAlbum").subscribe();
    }

}
