package sample.friendso.users;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("uzers")
@Slf4j
public class UzerController {

    @GetMapping("{id}")
    public Object findUser(@PathVariable String id){
        log.info("find user {}", id);
        var data = Map.of("name", "sarah", "id", id);
        return wrapResponse(data);
    }

    private Map<String, Object> wrapResponse(Object resp){
        return Map.of("data", resp);
    }

}
