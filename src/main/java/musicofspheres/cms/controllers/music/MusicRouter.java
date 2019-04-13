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
                .route(RequestPredicates.GET("/music/getMusic"), musicHandler::getMusic)
                .andRoute(RequestPredicates.GET("/music/getArtist/{artist}"),musicHandler::getArtist)
                .andRoute(RequestPredicates.GET("/music/getAlbum/{artist}/{album}"),musicHandler::getAlbum)
                .andRoute(RequestPredicates.GET("/music/getSong/{artist}/{album}/{song}"),musicHandler::getSong)


                .andRoute(RequestPredicates.GET("/music/checkArtist/{artist}"), musicHandler::checkArtist)
                .andRoute(RequestPredicates.POST("/music/addArtist/{id}/{artist}"),musicHandler::addArtist)

                .andRoute(RequestPredicates.GET("/music/checkAlbum/{artist}/{album}"), musicHandler::checkAlbum)
                .andRoute(RequestPredicates.POST("/music/addAlbum/{artist}/{id}/{name}"),musicHandler::addAlbum)

                .andRoute(RequestPredicates.GET("/music/checkSong/{artist}/{album}/{song}"), musicHandler::checkSong)
                .andRoute(RequestPredicates.POST("/music/addSong/{artist}/{album}/{id}/{name}"), musicHandler::addSong);

    }

}
