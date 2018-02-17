package mars.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovesControllerTest {

    @Autowired
    private MovesController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void successFullMoveToRight() throws Exception {
        this.mockMvc.perform(post("/rest/mars/MMRMMRMM")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void failsWithInvalidCmd() throws Exception {
        this.mockMvc.perform(post("/rest/mars/AAA")).andDo(print()).andExpect(status().isBadRequest()).
                andExpect(content().string(containsString("Invalid cmd")));
    }

    @Test
    public void failsWithInvalidPosition() throws Exception {
        this.mockMvc.perform(post("/rest/mars/MMMMMMMMMMMM")).andDo(print()).andExpect(status().isBadRequest()).
                andExpect(content().string(containsString("Invalid position")));
    }
}
