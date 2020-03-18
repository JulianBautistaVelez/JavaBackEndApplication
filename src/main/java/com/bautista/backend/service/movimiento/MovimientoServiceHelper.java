package com.bautista.backend.service.movimiento;

import com.bautista.backend.data.dinero.DineroEntity;
import com.bautista.backend.data.movimiento.DestinoMovimiento;
import com.bautista.backend.data.movimiento.MovimientoEntity;
import com.bautista.backend.data.movimiento.TipoMovimiento;
import com.bautista.backend.model.movimiento.MovimientoRequestModel;
import org.springframework.stereotype.Component;

@Component
public class MovimientoServiceHelper {

    /**
     * Método para actualizar la tabla que contiene la liquidez cuando un movimiento
     * se elimina
     * @param movimientoDeleted
     */
    public DineroEntity generateNewDineroUpdate(
            MovimientoEntity movimientoDeleted, DineroEntity lastState){
        DineroEntity update = new DineroEntity();
        int changeSymbol =
                TipoMovimiento.gasto.equals(movimientoDeleted.getTipo())? 1:-1;

        if(DestinoMovimiento.caja.equals(movimientoDeleted.getCajaBanco())){
            float newCuantity =
                    lastState.getCaja() + (movimientoDeleted.getValor() * changeSymbol);
            update.setCaja(newCuantity);
            update.setBanco(lastState.getBanco());
        } else {
            float newCuantity =
                    lastState.getBanco() + (movimientoDeleted.getValor() * changeSymbol);
            update.setBanco(newCuantity);
            update.setCaja(lastState.getCaja());
        }
        return update;
    }
}
