package com.miempresa.gestionReservas.implem;

import com.miempresa.gestionReservas.dtos.PagoDTO;
import com.miempresa.gestionReservas.entidades.Pago;
import com.miempresa.gestionReservas.mappers.PagoMapper;
import com.miempresa.gestionReservas.repositories.RepoPago;
import com.miempresa.gestionReservas.services.ServicePago;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements ServicePago {

    private final RepoPago repoPago;
    private final PagoMapper pagoMapper;

    public PagoServiceImpl(RepoPago repoPago, PagoMapper pagoMapper) {
        this.repoPago = repoPago;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public List<PagoDTO> listarPagos() {
        return repoPago.findAll()
                .stream()
                .map(pagoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PagoDTO realizarPago(PagoDTO pagoDTO) {
        Pago pago = pagoMapper.toEntity(pagoDTO);
        pago = repoPago.save(pago);
        return pagoMapper.toDTO(pago);
    }
}
