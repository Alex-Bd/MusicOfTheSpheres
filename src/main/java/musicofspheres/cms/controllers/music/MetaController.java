package musicofspheres.cms.controllers.music;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/music")
public class MetaController {

    @PutMapping("/setmeta")
    public void setMetaInfo(Map<String,String> info){


    }


}
