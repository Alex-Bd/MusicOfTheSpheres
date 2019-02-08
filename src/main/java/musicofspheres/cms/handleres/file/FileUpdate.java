package musicofspheres.cms.handleres.file;

import musicofspheres.cms.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUpdate {

    @Autowired
    Context ctx;

    public boolean rename(String oldName, String newName){


        return false;
    }

}
