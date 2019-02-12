package musicofspheres.cms.controllers.music;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;



@Configuration
public class MusicRouter {
    @Bean
    public RouterFunction<ServerResponse> getMusicRoute(MusicHandler musicHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/music/getMusic"), musicHandler::getAllMusic)
                .andRoute(RequestPredicates.GET("/music/getArtist/{artist}"), musicHandler::getArtist)
                .andRoute(RequestPredicates.GET("/music/getAlbum/{artist}/{album}"), musicHandler::getAlbum)
                .andRoute(RequestPredicates.GET("/music/getSong/{artist}/{album}/{song}"), musicHandler::getSong)
                .andRoute(RequestPredicates.POST("/music/addSong/{artist}"), musicHandler::addArtist)
                .andRoute(RequestPredicates.POST("/music/addSong/{artist}/{album}"), musicHandler::addAlbum)
                .andRoute(RequestPredicates.POST("/music/addSong/{artist}/{album}/{song}"), musicHandler::addSong);
    }

}
