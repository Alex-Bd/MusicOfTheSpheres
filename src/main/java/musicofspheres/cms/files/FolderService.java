package musicofspheres.cms.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class FolderService {

    @Value("${files.root}")
    String root;
    private Path dir;
    private File file;

    public Mono<Boolean> createArtistFolder(String artist){
       dir = Paths.get(root+"/"+artist);
       file = new File(dir.toString());
       return Mono.just(file.mkdir());
    }

    public Mono<Boolean> deleteArtistFolder(String artist){
           dir = Paths.get(root+"/"+artist);
           file = new File(dir.toString());
           return Mono.just(file.delete());
        }

    public Mono<Boolean> createAlbumFolder(String artist,String album){
        dir = Paths.get(root+"/"+artist+"/"+album);
        file = new File(dir.toString());
        return Mono.just(file.mkdir());
    }
    public Mono<Boolean> deleteAlbumFolder(String artist,String album){
        dir = Paths.get(root+"/"+artist+"/"+album);
        file = new File(dir.toString());
        return Mono.just(file.delete());
    }

}
