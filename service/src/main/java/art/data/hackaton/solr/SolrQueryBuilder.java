package art.data.hackaton.solr;

import static java.util.stream.Collectors.joining;

import art.data.hackaton.model.NasjonalMuseetRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolrQueryBuilder {

    private static final String SEARCH_QUERY_TEMPLATE = "?q=*&fq=identifier.owner:NMK*&fq=artifact.title:%s&wt=json&artifact.hasPictures:true&api.key=demo";

    public List<String> build(NasjonalMuseetRequest nasjonalMuseetRequest) {

        List<String> values = nasjonalMuseetRequest.getValues();

        List<String> searchQueries = new ArrayList<>();

        String andValue = buildAnd(values);

        if (andValue != null) {
            searchQueries.add(andValue);
        }

        String orValue = buildOr(values);

        if (orValue != null) {
            searchQueries.add(orValue);
        }

        return searchQueries;
    }

    // +morgen+skyet
    private String buildAnd(List<String> values) {
        return format(values.stream().collect(joining(" AND ")));
    }

    // morgen OR skyet
    private String buildOr(List<String> values) {
        return format(values.stream().collect(joining(" OR ")));
    }

    private String format(String searchTerm) {
        return (searchTerm == null || searchTerm.isEmpty()) ? null : String.format(SEARCH_QUERY_TEMPLATE, searchTerm);
    }
}