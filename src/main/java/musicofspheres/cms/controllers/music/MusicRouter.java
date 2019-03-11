package musicofspheres.cms.controllers.music;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.io.File;
import java.util.Map;


@Configuration
public class MusicRouter {
    @Bean
    public RouterFunction<ServerResponse> musicRoute(MusicHandler musicHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/music/getMusic"), musicHandler::getAllMusic)
                .andRoute(RequestPredicates.GET("/music/getArtist/{artist}"), musicHandler::getArtist)
                .andRoute(RequestPredicates.GET("/music/getAlbum/{artist}/{album}"), musicHandler::getAlbum)
                .andRoute(RequestPredicates.GET("/music/getSong/{artist}/{album}/{song}"), musicHandler::getSong)
                .andRoute(RequestPredicates.POST("/music/addArtist/{artist}"), musicHandler::addArtist)
                .andRoute(RequestPredicates.POST("/music/addAlbum/{artist}/{album}"), musicHandler::addAlbum)
                .andRoute(RequestPredicates.POST("/music/addSong")
                        .and(RequestPredicates.contentType(MediaType.MULTIPART_FORM_DATA)),musicHandler::addSong);


    }

}
