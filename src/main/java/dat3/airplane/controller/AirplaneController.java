package dat3.airplane.controller;

import dat3.airplane.entity.Airplane;
import dat3.airplane.service.AirplaneService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/airplanes")
public class AirplaneController {
    AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService){
        this.airplaneService=airplaneService;
    }

    @GetMapping
    List<Airplane> getAirplanes(){
        return  airplaneService.getAllAirplanes();
    }
}
