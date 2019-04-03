package musicofspheres.cms.drive;

import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileLoader implements InitializingBean {

    Auth auth;
    @Autowired
    public FileLoader(Auth auth) {
        this.auth = auth;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        String pageToken = null;
        do {
            FileList result = auth.getDriveService().files().list()
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .setPageToken(pageToken)
                    .execute();
            for (File file : result.getFiles()) {
               // auth.getDriveService().files().delete(file.getId());
System.out.println(file.getName());
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
    }
}
