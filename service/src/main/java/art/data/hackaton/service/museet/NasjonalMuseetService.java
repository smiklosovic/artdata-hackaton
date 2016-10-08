package art.data.hackaton.service.museet;

import art.data.hackaton.model.NasjonalMuseetRequest;
import art.data.hackaton.model.NasjonalMuseetResponse;
import art.data.hackaton.solr.SolrQueryBuilder;
import art.data.hackaton.solr.SolrQueryExecutor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@JBossLog
public class NasjonalMuseetService {

    @Autowired
    private SolrQueryExecutor solrQueryExecutor;

    @Autowired
    private SolrQueryBuilder solrQueryBuilder;

    public Optional<NasjonalMuseetResponse> search(NasjonalMuseetRequest nasjonalMuseetRequest) {

        String query = solrQueryBuilder.build(nasjonalMuseetRequest);

        return Optional.ofNullable(solrQueryExecutor.execute(query));
    }
}
