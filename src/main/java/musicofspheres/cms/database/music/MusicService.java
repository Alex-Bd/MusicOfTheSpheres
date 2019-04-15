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

    /**
     * Return the artist node if exists
     * 500 error if not.. NTF
     */
    public Artist getArtist(String artist) {
        return artistRepo.getArtist(artist);
    }

    public Album getAlbum(String artist, String album) {
        return albumRepo.getAlbum(artist, album);
    }

    public Song getSong(String Artist, String Album, String Song) {
        return songRepo.getSong(Artist, Album, Song);
    }


    /**
     * Checks if artist by name exists
     * Return true if it does, false otherwise
     */
    public Boolean checkArtist(String artist) {
        return artistRepo.checkArtist(artist);
    }

    public Boolean addArtist(String id, String name) {
        return artistRepo.addArtist(id, name);
    }

    public Boolean checkAlbum(String artist, String album) {
        return albumRepo.checkAlbum(artist, album);
    }

    public Boolean addAlbum(String artist, String id, String name) {
        return albumRepo.addAlbum(artist, id, name);
    }

    public Boolean checkSong(String artist, String album, String song) {
        return songRepo.checkSong(artist, album, song);
    }

    public Boolean addSong(String artist, String album, String id, String name) {
        return songRepo.addSong(artist, album, id, name);
    }


}

