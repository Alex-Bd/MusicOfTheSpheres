package musicofspheres.cms.controllers.music;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Slf4j
@Configuration
public class MusicRouter {

    @Bean
    public RouterFunction<ServerResponse> getMusicRoute(MusicHandler musicHandler) {

        return RouterFunctions
                .route(RequestPredicates
                .GET("/getmusic")
                .and(RequestPredicates
                .accept(MediaType.APPLICATION_JSON)), musicHandler::getAllMusic);
    }
    @Bean
    public RouterFunction<ServerResponse> getSongRoute(MusicHandler musicHandler) {

        return RouterFunctions
                .route(RequestPredicates
                .GET("/getmusic")
                .and(RequestPredicates
                .accept(MediaType.APPLICATION_JSON)), musicHandler::getSong);
    }

    @Bean
    public RouterFunction<ServerResponse> addSongRoute(MusicHandler musicHandler) {

        return RouterFunctions
                .route()
                .POST("/addSong",musicHandler::addSong).build();
    }






}
