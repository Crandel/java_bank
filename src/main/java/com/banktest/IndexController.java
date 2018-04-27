package com.banktest;


import com.banktest.models.IndexModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {
    @GetMapping("/test")
    public IndexModel test(@RequestParam(value="id", defaultValue="10") String str_id) {
        try {

            long id = Long.parseLong(str_id);
            return new IndexModel(id);
        } catch (NumberFormatException e){
            return new IndexModel(10);
        }
    }

    @GetMapping("/index")
    public IndexModel index(@RequestParam(value="id", defaultValue="10") String str_id) {
        try {

            long id = Long.parseLong(str_id);
            return new IndexModel(id + 100);
        } catch (NumberFormatException e){
            return new IndexModel(10);
        }
    }
}
