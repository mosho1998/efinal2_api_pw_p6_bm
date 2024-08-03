package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.modelo.VehiculoDTO;
import com.example.demo.service.IVehiculoService;

@RestController
@CrossOrigin
@RequestMapping(path = "/vehiculos")
public class VehiculoController {

    @Autowired
    private IVehiculoService iVehiculoService;

    // http://localhost:8080/API/v1.0/Concesionario/vehiculos
    @PostMapping
    public void guardarVehiculo(@RequestBody Vehiculo vehiculo) {
        this.iVehiculoService.guardar(vehiculo);
    }

    // http://localhost:8080/API/v1.0/Consecionario/vehiculos/consulta
    @GetMapping(path="/consulta")
    public List<VehiculoDTO> getVehicles() {
        List<Vehiculo> vehicles = iVehiculoService.buscarTodos();
        return vehicles.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private VehiculoDTO convertToDto(Vehiculo vehicle) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setPlaca(vehicle.getPlaca());
        dto.setMarca(vehicle.getMarca());
        dto.setModelo(vehicle.getModelo());
        return dto;
    }

    // http://localhost:8080/API/v1.0/Consecionario/vehiculos/borrar/${placa}
    @DeleteMapping(path = "/borrar/{placa}")
    public void borrarVehiculo(@PathVariable String placa) {
        this.iVehiculoService.eliminar(placa);
    }
    
    
}
