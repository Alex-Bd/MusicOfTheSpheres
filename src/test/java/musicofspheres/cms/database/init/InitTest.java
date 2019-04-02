package musicofspheres.cms.database.init;

import musicofspheres.cms.database.NeoInit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

public class InitTest {

    @Autowired
    NeoInit neo;


    public void RootTest(){
        assertEquals(0, neo.createRoot());
    }

    public void MusicModuleTest(){
        assertEquals(true, neo.createMusicModule());
    }




}
