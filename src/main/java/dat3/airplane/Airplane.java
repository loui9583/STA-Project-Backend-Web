package dat3.airplane;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String airplaneType;
    private boolean isCurrentlyAvailable;

    public Airplane(String airplaneType, boolean isCurrentlyAvailable) {
        this.airplaneType = airplaneType;
        this.isCurrentlyAvailable = isCurrentlyAvailable;
    }
}
