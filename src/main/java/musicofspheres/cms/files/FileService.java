package musicofspheres.cms.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    @Value("${files.root}")
    String root;
    private Path dir;
    private File file;

   /* public Mono<Boolean> createSong(String artist, String album, String song, File data){

        dir = Paths.get(root+"/"+artist+"/"+album+"/"+song);
        //file.createNewFile()
    }
*/
}
