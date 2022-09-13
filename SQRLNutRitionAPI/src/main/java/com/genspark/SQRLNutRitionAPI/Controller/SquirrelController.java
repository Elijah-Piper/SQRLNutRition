package com.genspark.SQRLNutRitionAPI.Controller;

import com.genspark.SQRLNutRitionAPI.Entity.Squirrel;
import com.genspark.SQRLNutRitionAPI.Entity.User;
import com.genspark.SQRLNutRitionAPI.Service.SquirrelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/") // Put React server address here
@RestController
@RequestMapping("squirrel/")
public class SquirrelController {

    @Autowired
    private SquirrelService squirrelService;

    @PostMapping("/create/{username}")
    public User createSquirrel(@RequestBody Squirrel sqrl, @PathVariable String username) {
        return this.squirrelService.createSquirrel(sqrl, username);
    }

    @GetMapping("/getbyid/{id}")
    public Squirrel getSquirrelById(@PathVariable int id) {
        return this.squirrelService.getSquirrelById(id);
    }

    @GetMapping("/getbyusername/{username}")
    public List<Squirrel> getSquirrelsByUsername(@PathVariable String username) {
        return this.squirrelService.getSquirrelsByUsername(username);
    }

    @PutMapping("/update")
    public Squirrel updateSquirrel(@RequestBody Squirrel sqrl) {
        return this.squirrelService.updateSquirrel(sqrl);
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deleteSquirrelById(@PathVariable int id) {
        return this.squirrelService.deleteSquirrelById(id);
    }

    @DeleteMapping("/deletebyusername")
    public String deleteSquirrelsByUsername(@PathVariable String username) {
        return this.squirrelService.deleteSquirrelsByUsername(username);
    }
}
