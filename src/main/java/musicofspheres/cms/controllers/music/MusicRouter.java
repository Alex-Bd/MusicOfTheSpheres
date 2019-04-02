package musicofspheres.cms.controllers.music;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;


@Configuration
public class MusicRouter {
    @Bean
    public RouterFunction<ServerResponse> musicRoute(MusicHandler musicHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/music/getMusic"), musicHandler::getAllMusic)
                .andRoute(RequestPredicates.GET("/music/getArtist/{artist}"), musicHandler::getArtist)
                .andRoute(RequestPredicates.GET("/music/getAlbum/{artist}/{album}"), musicHandler::getAlbum)
                .andRoute(RequestPredicates.GET("/music/getSong/{artist}/{album}/{song}"), musicHandler::getSong)
                .andRoute(RequestPredicates.POST("/music/addSong")
                        .and(RequestPredicates.contentType(MediaType.MULTIPART_FORM_DATA)),musicHandler::addSong);

    }

}
