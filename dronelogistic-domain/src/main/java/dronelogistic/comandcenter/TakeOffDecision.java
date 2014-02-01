package dronelogistic.comandcenter;

import java.util.Collections;
import java.util.List;

import dronelogistic.comandcenter.businessrules.DeliveryTimeAcceptanceStrategy;
import dronelogistic.orderinformations.AcceptableDeliveryTime;

public class TakeOffDecision {
    
    private Integer cargoID;
    private Integer warehausID;
    private List<String> possibleDronTypes;
    private boolean placeOfDeliveryAccepted;
    private boolean profitabilityAndPriorityAcceptance;
    private AcceptableDeliveryTime acceptableDeliveryTime;
    private transient CargoIndependentSubDecisions cargoIndependentSubDecisions;
    
    TakeOffDecision(Integer cargoID, Integer warehausID, CargoIndependentSubDecisions cargoIndependentSubDecisions) {
        this.cargoID = cargoID;
        this.warehausID = warehausID;
        this.cargoIndependentSubDecisions = cargoIndependentSubDecisions;
        
        possibleDronTypes = Collections.emptyList();
        placeOfDeliveryAccepted = false;
        profitabilityAndPriorityAcceptance = false;
    }
    
    public boolean isCargoAndOrderAcceptable() {
        return !possibleDronTypes.isEmpty() && placeOfDeliveryAccepted;
    }
    
    public boolean isPositive(DeliveryTimeAcceptanceStrategy deliveryTimeAcceptanceStrategy) {
        return isCargoAndOrderAcceptable()
                && profitabilityAndPriorityAcceptance
                && cargoIndependentSubDecisions.arePositive()
                && deliveryTimeAcceptanceStrategy.isPositive(acceptableDeliveryTime);
    }
    
    public Integer getCargoID() {
        return cargoID;
    }
    
    public Integer getWarehausID() {
        return warehausID;
    }
    
    public List<String> getPossibleDronTypes() {
        return possibleDronTypes;
    }
    
    public void setPossibleDronTypes(List<String> possibleDronTypes) {
        this.possibleDronTypes = possibleDronTypes;
    }
    
    public void setPlaceOfDeliveryAccepted(boolean placeOfDeliveryAccepted) {
        this.placeOfDeliveryAccepted = placeOfDeliveryAccepted;
        
    }
    
    public void setProfitabilityAndPriorityAcceptance(boolean profitabilityAndPriorityAcceptance) {
        this.profitabilityAndPriorityAcceptance = profitabilityAndPriorityAcceptance;
    }
}
