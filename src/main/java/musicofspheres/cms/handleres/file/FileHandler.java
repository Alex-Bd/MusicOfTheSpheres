package musicofspheres.cms.handleres.file;

public class FileHandler {
/*
    MusicListEntity musicList;
    Artist artist = new Artist();
    Album album = new Album();
    Song song = new Song();
    int x;

    @Override
    public void afterPropertiesSet() throws Exception {
        musicList=populateMusicList();
    }

    private MusicListEntity populateMusicList(){
        MusicListEntity musicList = new MusicListEntity();
        artist = new Artist();
        album = new Album();
        song = new Song();

        for(Path f : ctx.getMusic()) {
            Iterator<Path> i=f.iterator();
            i.next();

           x=0;
            while(i.hasNext()){
                Path p=i.next();
                if(x==0) {
                    String a=p.toString();
                    if(isNew(a,artist.getName())) {
                        artist = new Artist();
                        musicList.addArtist(artist);
                    }
                    if(artist.getName().isEmpty()) {
                        artist.setName(a);
                        artist.setId(f.subpath(1,2).toString());
                    }
                }else if(x==1){
                    String a = p.toString();
                    if(isNew(a,album.getName()))
                        album= new Album();
                    if (album.getName().isEmpty()) {
                        album.setName(a);
                        album.setId(f.subpath(1,3).toString());
                    }
                    if(!artist.containsAlbum(a))
                        artist.addAlbum(album);
                }else if(x==2){
                    String s = p.toString();
                    song = new Song();
                    song.setId(f.subpath(1,4).toString());
                    song.setName(s);
                    song.setPath(f.subpath(1,4).toString());
                    album.addSong(song);
                }
                ++x;
            }
        }
        return musicList;
    }

    private boolean isNew(String newName, String oldName){
        return newName.compareTo(oldName)!=0;
    }


    public  MusicListEntity getList(){

            return  musicList;

    }
*/
}
