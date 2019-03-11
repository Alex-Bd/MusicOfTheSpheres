package musicofspheres.cms.database.music;

import musicofspheres.cms.database.music.enity.Album;
import musicofspheres.cms.database.music.enity.Artist;
import musicofspheres.cms.database.music.enity.Song;
import musicofspheres.cms.database.music.repo.AlbumRepo;
import musicofspheres.cms.database.music.repo.ArtistRepo;
import musicofspheres.cms.database.music.repo.ArtistResultRepo;
import musicofspheres.cms.database.music.repo.SongRepo;
import musicofspheres.cms.database.music.results.ArtistResult;
import musicofspheres.cms.files.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
public class MusicService {

    private ArtistResultRepo art;
    private ArtistRepo artistRepo;
    private AlbumRepo albumRepo;
    private SongRepo songRepo;
    private FolderService folderService;

    @Autowired
    public MusicService(ArtistResultRepo art, ArtistRepo artistRepo, AlbumRepo albumRepo, SongRepo songRepo, FolderService folderService) {
        this.art = art;
        this.artistRepo = artistRepo;
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.folderService = folderService;
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

    public Mono<Boolean> addArtist(String artist) {

        Mono blockingWrapper = Mono.fromCallable(() -> {
            if(artistRepo.createArtist(artist))
               return folderService.createArtistFolder(artist);
            else
                return Mono.just(false);
        });

        blockingWrapper = blockingWrapper.subscribeOn(Schedulers.elastic());
        return blockingWrapper;
    }


    public Mono<Void> addSong(String artist,String album,String song) {
        Mono blockingWrapper = Mono.fromCallable(() -> {
              songRepo.addSong(artist, album, song);
              return true;
        });
        blockingWrapper = blockingWrapper.subscribeOn(Schedulers.elastic());

        return blockingWrapper;
    }


}

