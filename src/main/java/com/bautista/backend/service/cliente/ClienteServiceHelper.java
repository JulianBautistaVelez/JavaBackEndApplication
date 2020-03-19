package com.bautista.backend.service.cliente;

import com.bautista.backend.data.cliente.ClienteEntity;

public class ClienteServiceHelper {

    public void copyFieldsFromTo(ClienteEntity update, ClienteEntity dbData){
        if(update.getComentarios() != null){
            dbData.setComentarios(update.getComentarios());
        }

        if(update.getDireccion() != null){
            dbData.setDireccion(update.getDireccion());
        }

        if(update.getNombre() != null){
            dbData.setNombre(update.getNombre());
        }

        if(update.getPresupuestos() != null){
            dbData.setPresupuestos(update.getPresupuestos());
        }

        if(update.getTrabajos() != null){
            dbData.setTrabajos(update.getTrabajos());
        }

        if(update.getTelefono() != 0){
            dbData.setTelefono(update.getTelefono());
        }

    }
}
