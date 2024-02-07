package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.KangarooNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class KangarooController {
    private Map<Long, Kangaroo> kangaroos = new HashMap<>();

    @GetMapping("/kangaroos")
    public List<Kangaroo> getAllKangaroos(){
        return kangaroos.values().stream().toList();
    }

    @GetMapping("/kangaroos/{id}")
    public Kangaroo getKangaroosById(@PathVariable Long id){
        return kangaroos.get(id);
    }

    @PostMapping("/kangaroos")
    public Kangaroo addKangaroo(@RequestBody Kangaroo kangaroo){
        kangaroo.setId(System.currentTimeMillis());
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @PutMapping("/kangaroos/{id}")
    public Kangaroo updateKangaroo(@PathVariable Long id, @RequestBody Kangaroo kangaroo) {
        if (!kangaroos.containsKey(id)) {
            throw new KangarooNotFoundException("Kangaroo not found with id: " + id);
        }

        kangaroo.setId(id);
        kangaroos.put(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/kangaroos/{id}")
    public void deleteKangaroo(@PathVariable Long id) {
        if (!kangaroos.containsKey(id)) {
            throw new KangarooNotFoundException("Kangaroo not found with id: " + id);
        }
        kangaroos.remove(id);
    }

}
