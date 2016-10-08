package art.data.hackaton.model;

public class NasjonalMuseetRequest {

    private NasjonalMuseetRequest() {

    }

    public static NasjonalMuseetRequest build(SearchRequest searchRequest) {
        return new NasjonalMuseetRequest();
    }
}
