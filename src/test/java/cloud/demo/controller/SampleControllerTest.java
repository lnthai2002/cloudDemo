package cloud.demo.controller;

import cloud.demo.services.Service1;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SampleController.class)
public class SampleControllerTest extends TestCase {

    @Configuration
    static class ContextConfiguration {
        @Bean
        public Service1 service1() {
            return Mockito.mock(Service1.class);
        }
    }

    @Autowired
    private Service1 service1;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAString() throws Exception {
        String id = "1";
        String retValue = "asample";

        //assume the service1 works correctly
        when(service1.getSample(ArgumentMatchers.anyString()))
                .thenReturn(retValue);

        //act
        mockMvc.perform(get("/v1/samples?id=1"))
                //.param("id", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.val").value(retValue));
    }
}