package musicofspheres.cms;

import lombok.Data;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
public class Context {

    private String root;
    private int rootCount;
    private List<Path> music;
    private Path start;

    private SessionFactory sessionFactory;
    Session session;


    public void afterPropertiesSet() throws Exception {
       //session=sessionFactory.openSession();
       root="c:\\Sync\\db\\public\\Music";
       start = Paths.get(root);
       music=fileWalker();
       rootCount = setRootCount();
    }

    private List<Path> fileWalker(){
        List<Path> list = new ArrayList<>();
        Stream<Path> stream = null;
        try {
            stream = Files.walk(start, FileVisitOption.FOLLOW_LINKS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stream.filter(Files::isRegularFile)
                .filter((p) -> p.toString().endsWith(".mp3"))
                .forEach(list::add);

        return list;
    }

    public Path findArtist(String artist){
        for(Path p:music){
            System.out.println(p);
            if(p.getName(rootCount).toString().compareTo(artist) == 0)
               return p;
        }
        return null;
    }
    public Path findAlbum(String artist, String album){
        for(Path p:music){
            if(p.getName(rootCount).toString().compareTo(artist) == 0)
                if(p.getName(rootCount+1).toString().compareTo(album) == 0)
                    return p;
        }
        return null;
    }

    public Path findSong(String artist, String album, String song){
        for(Path p:music){
            if(p.getName(rootCount).toString().compareTo(artist) == 0)
                if(p.getName(rootCount+1).toString().compareTo(album) == 0)
                    if(p.getName(rootCount+2).toString().compareTo(song) == 0)
                        return p;
        }
        return null;
    }


    private int setRootCount(){
       String[] count = root.split("\\\\");
        return count.length;
    }

}
