package art.data.hackaton.solr;

import art.data.hackaton.model.NasjonalMuseetRequest;
import org.springframework.stereotype.Component;

@Component
public class SolrQueryBuilder {

    public String build(NasjonalMuseetRequest searchRequest) {
        return "?q=*&fq=identifier.owner:NMK*&fq=artifact.title:*morgen*skyet&wt=json&artifact.hasPictures:true&api.key=demo";
    }
}
