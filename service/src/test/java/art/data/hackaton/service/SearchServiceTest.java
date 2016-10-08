package art.data.hackaton.service;

import art.data.hackaton.configuration.DefaultTestAnnotations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DefaultTestAnnotations
public class SearchServiceTest {

    @Autowired
    private SearchService searchService;

    @Test
    public void searchServiceTest() {

    }
}
