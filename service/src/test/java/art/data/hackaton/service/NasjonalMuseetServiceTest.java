package art.data.hackaton.service;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import art.data.hackaton.configuration.DefaultTestAnnotations;
import art.data.hackaton.model.NasjonalMuseetRequest;
import art.data.hackaton.model.NasjonalMuseetResponse;
import art.data.hackaton.service.museet.NasjonalMuseetService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@DefaultTestAnnotations
public class NasjonalMuseetServiceTest {

    @Autowired
    private NasjonalMuseetService nasjonalMuseetService;

    @Test
    public void testNationalMuseetService() {

        NasjonalMuseetRequest nasjonalMuseetRequest = new NasjonalMuseetRequest();

        nasjonalMuseetRequest.setValues(asList("morgen", "avsted"));

        final Optional<List<NasjonalMuseetResponse>> responses = nasjonalMuseetService.search(nasjonalMuseetRequest);

        Assert.assertTrue(responses.isPresent());

        List<NasjonalMuseetResponse> responseList = responses.get();
        assertNotNull(responseList);
        assertFalse(responseList.isEmpty());

        for (NasjonalMuseetResponse nasjonalMuseetResponse : responseList) {
            assertNotNull(nasjonalMuseetResponse.getAuthor());
            assertNotNull(nasjonalMuseetResponse.getTitle());
            assertNotNull(nasjonalMuseetResponse.getLinkToImage());
        }
    }
}
