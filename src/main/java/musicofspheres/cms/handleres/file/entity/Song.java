package musicofspheres.cms.handleres.file.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Song {

    private String id;
    private String name="";
    private String path="";

    public void setPath(String path){

        this.path=path.replaceAll("\\\\","\\\\\\\\");

    }
}
