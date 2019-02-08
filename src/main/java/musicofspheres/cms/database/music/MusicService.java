package musicofspheres.cms.database.music;

import musicofspheres.cms.Context;
import musicofspheres.cms.database.music.repo.AlbumRepo;
import musicofspheres.cms.database.music.repo.ArtistRepo;
import musicofspheres.cms.database.music.repo.SongRepo;
import musicofspheres.cms.database.music.results.ArtistResult;
import musicofspheres.cms.database.music.results.SongResult;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService{

    @Autowired
    Context ctx;
    @Autowired
    SessionFactory session;
    @Autowired
    AlbumRepo repo;
    @Autowired
    ArtistRepo art;
    @Autowired
    SongRepo song;

    public List<ArtistResult> getAllMusic(){
        List<ArtistResult> result = new ArrayList<>();
        try {
           result = art.getAllMusic();
            System.out.println(result);
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    public ArtistResult getArtist(){
        return art.getArtist("Alizee");
    }


    public List<ArtistResult> getArtists(){
        return art.getArtists();
    }

public SongResult getSong(String Artist, String Album, String Song){
        System.out.println("wtf");
        return song.getSong(Artist,Album,Song);
}

}
