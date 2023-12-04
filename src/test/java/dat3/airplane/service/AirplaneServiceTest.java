package dat3.airplane.service;

import dat3.airplane.entity.Airplane;
import dat3.airplane.repository.AirplaneRepository;
import dat3.airplane.service.AirplaneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AirplaneServiceTest {


    @Autowired
    AirplaneRepository airplaneRepository;

    @Autowired
    AirplaneService airplaneService;

    /*@Test
    void testGetAllAirplanes(){
        Airplane a1 = new Airplane("boeing", true);
        airplaneRepository.save(a1);
        assertEquals(5, airplaneService.getAllAirplanes().size());
    }*/

}