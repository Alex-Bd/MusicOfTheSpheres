package musicofspheres.cms.database;


import musicofspheres.cms.database.init.InitRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeoInit implements InitializingBean {

    @Autowired
    InitRepo repo;

    public int createRoot(){
       return  repo.createRoot();
    }
    public boolean createMusicModule(){
       return repo.createMusic();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        createRoot();
        createMusicModule();
    }
}
