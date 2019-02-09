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

    Mono<ServerResponse> getArtists(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters
                .fromObject(service.getArtists()));
    }

    Mono<ServerResponse> getAllMusic(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters
                .fromObject(service.getAllMusic()));
    }

    Mono<ServerResponse>  getSong(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters
                .fromObject(service.getSong(request.queryParam("artist").get(),
                                            request.queryParam("album").get(),
                                            request.queryParam("song").get())));
    }

    Mono<ServerResponse>  addSong(ServerRequest request){

        return ServerResponse
                .ok()
                .build(service.addSong(request.queryParam("artist").get(),
                                       request.queryParam("album").get(),
                                       request.queryParam("song").get()));
    }


}
