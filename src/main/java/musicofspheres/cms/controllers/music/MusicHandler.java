package musicofspheres.cms.controllers.music;

import musicofspheres.cms.database.music.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class MusicHandler{

    @Autowired
    MusicService service;

    public Mono<ServerResponse> getArtists(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters
                .fromObject(service.getArtists()));
    }

    public Mono<ServerResponse> getAllMusic(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters
                .fromObject(service.getAllMusic()));
    }

    public Mono<ServerResponse>  getSong(ServerRequest request){

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters
                .fromObject(service.getSong(request.pathVariable("artist"),
                        request.pathVariable("album"),
                        request.pathVariable("song"))));
    }
}
