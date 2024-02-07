package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class KoalaController {
    private Map<Long, Koala> koalas = new HashMap<>();


    @GetMapping("/koalas")
    public List<Koala> getAllKoalas() {
        return koalas.values().stream().toList();
    }
    @GetMapping("/koalas/{id}")
    public Koala getKoalaById(@PathVariable long id) {
        return koalas.get(id);
    }
    @PostMapping("/koalas")
    public Koala addKoala(@RequestBody Koala koala) {
    koala.setId(System.currentTimeMillis());
    koalas.put(koala.getId(), koala);
    return koala;
    }
    @PutMapping("/koalas/{id}")
    public Koala updateKoala(@PathVariable Long id, @RequestBody Koala koala){
        if(koalas.containsKey(id)){
            koala.setId(id);
            koalas.put(id, koala);
        }
        return koala;
    }
    @DeleteMapping("/koalas/{id}")
    public void deleteKoala(@PathVariable Long id){
    koalas.remove(id);
    }

}
