package com.genspark.SQRLNutRitionAPI.Controller;

import com.genspark.SQRLNutRitionAPI.Entity.Squirrel;
import com.genspark.SQRLNutRitionAPI.Entity.User;
import com.genspark.SQRLNutRitionAPI.Service.SquirrelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "") // Put React server address here
@RestController
@RequestMapping("squirrel/")
public class SquirrelController {

    @Autowired
    private SquirrelService squirrelService;

    @PostMapping("/create")
    public Squirrel createSquirrel(@RequestBody Squirrel sqrl) {
        return this.squirrelService.createSquirrel(sqrl);
    }

    @GetMapping("/getbyid/{id}")
    public Squirrel getSquirrelById(@PathVariable int id) {
        return this.squirrelService.getSquirrelById(id);
    }

    @GetMapping("/getbyuser")
    public List<Squirrel> getSquirrelsByUser(@RequestBody User user) {
        return this.squirrelService.getSquirrelsByUser(user);
    }

    @PutMapping("/update")
    public Squirrel updateSquirrel(@RequestBody Squirrel sqrl) {
        return this.squirrelService.updateSquirrel(sqrl);
    }

    @DeleteMapping("/deletesquirrelbyid/{id}")
    public String deleteSquirrelById(@PathVariable int id) {
        return this.squirrelService.deleteSquirrelById(id);
    }

    @DeleteMapping("/deletesquirrelsbyuser")
    public String deleteSquirrelsByUser(@RequestBody User user) {
        return this.squirrelService.deleteSquirrelsByUser(user);
    }
}
