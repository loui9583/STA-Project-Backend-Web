package dat3.airplane.service;

import dat3.airplane.entity.Airplane;
import dat3.airplane.repository.AirplaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {

    AirplaneRepository airplaneRepository;

    public AirplaneService(AirplaneRepository airplaneRepository){
        this.airplaneRepository=airplaneRepository;
    }

    public List<Airplane> getAllAirplanes(){
        List <Airplane> airplanes = airplaneRepository.findAll();
        return airplanes;
    }

}
