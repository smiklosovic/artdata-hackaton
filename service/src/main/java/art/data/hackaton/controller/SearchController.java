package art.data.hackaton.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

import art.data.hackaton.model.SearchResponse;
import art.data.hackaton.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SearchController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SearchService searchService;

    @RequestMapping("/search")
    public ResponseEntity<SearchResponse> search(@RequestParam(value = "time", required = true) int time) {

        logger.info("[search]");

        Optional<SearchResponse> searchResponse = searchService.search(time);

        return searchResponse.isPresent() ? new ResponseEntity<>(searchResponse.get(), OK) : new ResponseEntity<>(BAD_REQUEST);
    }
}
