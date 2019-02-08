package musicofspheres.cms.handleres.file;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;


public class FileSync {

    public void afterPropertiesSet() throws Exception {
       /* Map m = new HashMap();
        Session db=session.openSession();

        String match="match (Music:Music) ";


        for(Artist artist : files.getList().getArtists()){
            String addArtist=String.format("create (Music)-[:Artist]->(:Artist {name:\"%s\"})",artist.getName());
            db.query(match+addArtist,m);
            for(Album album:artist.getAlbums()){
                match=String.format("match (Music:Music)-[]-(artist:Artist {name:\"%s\"})",artist.getName());
                String createAlbum=String.format(" create (artist)-[:Album]->(:Album {name:\"%s\"})",album.getName());
                db.query(match+createAlbum,m);
                for(Song song:album.getSongs()){
                    match=String.format("match (Music:Music)-[]-(artist:Artist {name:\"%s\"})-[]-(album:Album {name:\"%s\"})",artist.getName(),album.getName());
                    String createSong=String.format(" create (album)-[:Song]->(:Song {name:\"%s\", path:\"%s\"})",song.getName(),song.getPath());

                    db.query(match+createSong,m);
                }
            }
        }

*/
    }

}
