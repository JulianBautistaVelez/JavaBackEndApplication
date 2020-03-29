package com.bautista.backend.service.dinero;

import com.bautista.backend.data.movimiento.DestinoMovimiento;
import com.bautista.backend.data.movimiento.MovimientoEntity;
import com.bautista.backend.data.movimiento.TipoMovimiento;
import com.bautista.backend.model.dinero.TransferenciaRequestModel;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

public class DineroServiceHelper {

    public static void generaMovimientosTransferencia(
            TransferenciaRequestModel transferencia,
            EnumMap<DestinoMovimiento, MovimientoEntity> movimientos
    ){
        MovimientoEntity movimientoBanco = new MovimientoEntity();
        MovimientoEntity movimientoCaja = new MovimientoEntity();

        movimientos.put(DestinoMovimiento.banco, movimientoBanco);
        movimientos.put(DestinoMovimiento.caja, movimientoCaja);

        if(DestinoMovimiento.banco.equals(transferencia.getDestino())) {
            for (Map.Entry<DestinoMovimiento, MovimientoEntity> entry : movimientos.entrySet()) {
                entry.getValue().setConcepto("Transferencia de caja a banco");
                entry.getValue().setValor(transferencia.getDinero());
                entry.getValue().setTipo(
                        DestinoMovimiento.banco.equals(entry.getKey()) == true ?
                                TipoMovimiento.ingreso : TipoMovimiento.gasto
                );
                entry.getValue().setCajaBanco(entry.getKey());
            }
        } else {
            for (Map.Entry<DestinoMovimiento, MovimientoEntity> entry : movimientos.entrySet()) {
                entry.getValue().setConcepto("Transferencia de banco a caja");
                entry.getValue().setValor(transferencia.getDinero());
                entry.getValue().setTipo(
                        DestinoMovimiento.caja.equals(entry.getKey()) == true ?
                                TipoMovimiento.ingreso : TipoMovimiento.gasto
                );
                entry.getValue().setCajaBanco(entry.getKey());
            }
        }

        String uuid = UUID.randomUUID().toString();

        movimientoBanco.setMovimientoId(uuid);
        movimientoCaja.setMovimientoId(uuid);

    }
}
