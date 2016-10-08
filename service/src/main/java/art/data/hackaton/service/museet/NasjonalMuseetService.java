package art.data.hackaton.service.museet;

import art.data.hackaton.model.NasjonalMuseetRequest;
import art.data.hackaton.model.NasjonalMuseetResponse;
import art.data.hackaton.solr.SolrQueryBuilder;
import art.data.hackaton.solr.SolrQueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NasjonalMuseetService {

    @Autowired
    private SolrQueryExecutor solrQueryExecutor;

    @Autowired
    private SolrQueryBuilder solrQueryBuilder;

    public Optional<List<NasjonalMuseetResponse>> search(NasjonalMuseetRequest nasjonalMuseetRequest) {

        List<String> queries = solrQueryBuilder.build(nasjonalMuseetRequest);

        return Optional.ofNullable(solrQueryExecutor.execute(queries));
    }
}
