package musicofspheres.cms.database.music;

import musicofspheres.cms.database.music.enity.Song;
import musicofspheres.cms.database.music.repo.AlbumRepo;
import musicofspheres.cms.database.music.repo.ArtistRepo;
import musicofspheres.cms.database.music.repo.ArtistResultRepo;
import musicofspheres.cms.database.music.repo.SongRepo;
import musicofspheres.cms.database.music.results.ArtistResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService {

    ArtistResultRepo art;
    ArtistRepo artistRepo;
    AlbumRepo albumRepo;
    SongRepo songRepo;

    public MusicService(ArtistResultRepo art, ArtistRepo artistRepo, AlbumRepo albumRepo, SongRepo songRepo) {
        this.art = art;
        this.artistRepo = artistRepo;
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
    }

    @Autowired


    public List<ArtistResult> getAllMusic() {
        List<ArtistResult> result = new ArrayList<>();
        try {
            result = art.getAllMusic();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public List<ArtistResult> getArtists() {
        return art.getArtists();
    }

    public Song getSong(String Artist, String Album, String Song) {
        return songRepo.getSong(Artist, Album, Song);
    }

    public Mono<Void> addSong(String artist, String album, String song) {

        songRepo.addSong(artist, album, song);
        return Mono.create(voidMonoSink -> {});
    }
}

