package com.example.demo.Controller;
import com.example.demo.Service.ElemenServiceImpl;
import com.example.demo.model.PowerElement;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping()
public class PowerElementController {
    private final ElemenServiceImpl elemenService;
    @Autowired
    public PowerElementController(ElemenServiceImpl elemenService) {
        this.elemenService = elemenService;
    }
    @GetMapping()
    public ResponseEntity<List<PowerElement>> readAll() {
        final List<PowerElement> elements = elemenService.readAll();

        return elements != null &&  !elements.isEmpty()
                ? new ResponseEntity<>(elements, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public List<PowerElement> getById(@PathVariable int id) {
        return elemenService.getById(id);
    }

    @PostMapping("/add")
    public String addObject(@RequestBody PowerElement object) {
        return elemenService.addPowerElement(object);
    }

    @GetMapping("/stat")
    public JSONObject getStatisticVoltage() {
        return elemenService.getStatitic();
    }
}
