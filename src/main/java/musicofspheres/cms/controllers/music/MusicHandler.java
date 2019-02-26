package musicofspheres.cms.controllers.music;

import musicofspheres.cms.database.music.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@CrossOrigin
public class MusicHandler {

    private MusicService service;
    @Autowired
    public MusicHandler(MusicService service) {
        this.service = service;
    }

    Mono<ServerResponse> getAllMusic(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin","*")
                .body(BodyInserters
                      .fromObject(service.getAllMusic())) ;
    }

    Mono<ServerResponse> getArtist(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin","*")
                .body(BodyInserters
                     .fromObject(service.getArtist(request.pathVariable("artist"))));
    }

    Mono<ServerResponse> getAlbum(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin","*")
                .body(BodyInserters
                     .fromObject(service.getAlbum(request.pathVariable("artist"),request.pathVariable("album"))));
    }

    Mono<ServerResponse> getSong(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin","*")
                .body(BodyInserters
                        .fromObject(service.getSong(request.pathVariable("artist"),
                                request.pathVariable("album"),
                                request.pathVariable("song"))));
    }


    Mono<ServerResponse> addSong(ServerRequest request) {

       service.addSong(request.pathVariable("artist"),
                       request.pathVariable("album"),
                       request.pathVariable("song"));

            return ServerResponse.ok().contentType(APPLICATION_JSON).header("Access-Control-Allow-Origin","*").body(Mono.just("SUCCESS"), String.class);

    }
}