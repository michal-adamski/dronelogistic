package dronelogistic.comandcenter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import dronelogistic.dronflightcontrol.Drone;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class DroneTakeOffDecision {
    
    @Getter private Drone drone;
    @Getter private Integer cargoID;
    
}
