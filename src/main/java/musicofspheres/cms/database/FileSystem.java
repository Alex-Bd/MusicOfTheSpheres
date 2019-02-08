package musicofspheres.cms.database;


import musicofspheres.cms.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class FileSystem {

    @Autowired
    Context ctx;

    public void integrity(){

    }

    public void addPath(Path p){

        String create = "match (m:Music)" +
                        "create (m)-[:Artist]->(a:Artist)";

    }

}
