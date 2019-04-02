package musicofspheres.cms.database.music;

import musicofspheres.cms.database.music.enity.Album;
import musicofspheres.cms.database.music.enity.Artist;
import musicofspheres.cms.database.music.enity.Song;
import musicofspheres.cms.database.music.repo.AlbumRepo;
import musicofspheres.cms.database.music.repo.ArtistRepo;
import musicofspheres.cms.database.music.repo.ArtistResultRepo;
import musicofspheres.cms.database.music.repo.SongRepo;
import musicofspheres.cms.database.music.results.ArtistResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
public class MusicService {

    private ArtistResultRepo art;
    private ArtistRepo artistRepo;
    private AlbumRepo albumRepo;
    private SongRepo songRepo;

    @Autowired
    public MusicService(ArtistResultRepo art, ArtistRepo artistRepo, AlbumRepo albumRepo, SongRepo songRepo) {
        this.art = art;
        this.artistRepo = artistRepo;
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
    }

    public List<ArtistResult> getAllMusic() {
        List<ArtistResult> result;
        result = art.getAllMusic();
        return result;
    }

    public Artist getArtist(String artist) {
        return artistRepo.getArtist(artist);
    }
    public Album getAlbum(String artist, String album) {
            return albumRepo.getAlbum(artist,album);
        }

    public Song getSong(String Artist, String Album, String Song) {
        return songRepo.getSong(Artist, Album, Song);
    }

    public Mono<Boolean> addSong(String artist,String album,String song) {

        Mono blockingWrapper = Mono.fromCallable(() -> {
            if(songRepo.addSong(artist,album,song))
                return  Mono.just(true);
            else
                return Mono.just(false);
        });

        blockingWrapper = blockingWrapper.subscribeOn(Schedulers.elastic());
        return blockingWrapper;
    }


}

