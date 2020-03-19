package com.bautista.backend.service.tela;

import com.bautista.backend.data.tela.TelaEntity;

public class TelaServiceHelper {
    public void copyFieldsFromTo(TelaEntity update, TelaEntity dbData){
        if(update.getNombre() != null){
            dbData.setNombre(update.getNombre());
        }

        if(update.getPrecioCliente() != 0){
            dbData.setPrecioCliente(update.getPrecioCliente());
        }

        if(update.getPrecioProveedor() != 0){
            dbData.setPrecioProveedor(update.getPrecioProveedor());
        }

        if(update.getTipoTela() != null){
            dbData.setTipoTela(update.getTipoTela());
        }

        if(update.getProveedor() != null){
            dbData.setProveedor(update.getProveedor());
        }

    }
}
