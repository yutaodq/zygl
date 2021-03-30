package mike.wolf.zygl.application.service;

import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.in.GetVehicleStateQuery;
import mike.wolf.zygl.application.port.out.VehicleStateQueryAllPort;

import java.util.List;
import java.util.Map;

public class GetVehicleStateService implements GetVehicleStateQuery {
    private VehicleStateQueryAllPort vehicleStateQueryAllPort;

    public GetVehicleStateService(VehicleStateQueryAllPort vehicleStateQueryAllPort) {
        this.vehicleStateQueryAllPort = vehicleStateQueryAllPort;
    }

    @Override
    public Map<String, List<VehicleStateDTO>> findAll() {
        return this.findAll(true);

    }
    public Map<String, List<VehicleStateDTO>> findAll(boolean removeUnavailableProducts) {

        List<VehicleStateDTO> vehicleStates = vehicleStateQueryAllPort.findAllVehicleStates();
return vehicleStates.stream().collect();
//        List<ProductDTO> products = productRepository.findAllProducts();
//        if(removeUnavailableProducts){
//            return products.stream()
//                    .filter(product -> product.getQuantityAvailable() > 0)
//                    .collect(Collectors.groupingBy(p -> p.getCategory().getName()));
//        }
//        return products.stream()
//                .collect(Collectors.groupingBy(p -> p.getCategory().getName()));
    }// findAll()

}

