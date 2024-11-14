package Fresher;

public class logistics {
    public static int minContainersNeeded(int[] shipments, int[] containerLimits) {
        int containerCount = 0;
        int shipmentIndex = 0;
        int containerIndex = 0;

        while (shipmentIndex < shipments.length) {
            int shipment = shipments[shipmentIndex];

            
            while (shipment > 0 && containerIndex < containerLimits.length) {
                
                if (containerLimits[containerIndex] >= shipment) {
                    
                    containerLimits[containerIndex] -= shipment;
                    shipment = 0;  
                    if (containerLimits[containerIndex] == 0) {
                        containerCount++;
                        containerIndex++;
                    }
                } else {
                    
                    shipment -= containerLimits[containerIndex];
                    containerLimits[containerIndex] = 0;
                    containerCount++;  
                    containerIndex++;  
                }
            }


            if (shipment > 0) {
                return -1;  
            }

            shipmentIndex++;
        }
        return containerCount;
    }

    public static void main(String[] args) {
        int[] shipments = {10, 20, 30};
        int[] containerLimits = {15, 15, 20,10 };

        System.out.println("Minimum number of containers needed: " + minContainersNeeded(shipments, containerLimits));
 }
}