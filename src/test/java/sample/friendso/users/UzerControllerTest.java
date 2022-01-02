package sample.friendso.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UzerController.class)
public class UzerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test void
    should_return_details_of_user_id() throws Exception {
        var id = "uzr-id-a1";
        ResultActions result = this.mockMvc.perform(get("/uzers/{userId}", id))
                .andExpect(status().isOk());
        result.andExpect(jsonPath("$.data.name").value("sarah"));
        result.andExpect(jsonPath("$.data.id").value(id));
    }

}
