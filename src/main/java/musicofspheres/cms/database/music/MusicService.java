package musicofspheres.cms.database.music;

import musicofspheres.cms.database.music.repo.ArtistResultRepo;
import musicofspheres.cms.database.music.repo.SongRepo;
import musicofspheres.cms.database.music.results.ArtistResult;
import musicofspheres.cms.database.music.results.SongResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService{

    ArtistResultRepo art;
    SongRepo song;

    @Autowired
    public MusicService(ArtistResultRepo art, SongRepo song) {
        this.art = art;
        this.song = song;
    }

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


    public List<ArtistResult> getArtists(){
        return art.getArtists();
    }

    public SongResult getSong(String Artist, String Album, String Song){
        return song.getSong(Artist,Album,Song);
    }

}
