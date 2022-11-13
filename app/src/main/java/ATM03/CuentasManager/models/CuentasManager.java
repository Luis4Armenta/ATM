package ATM03.CuentasManager.models;

import ATM03.entities.Cuenta;
import ATM03.repositories.interfaces.ICuentasRepository;

public class CuentasManager {
  ICuentasRepository cuentasRepository;

  public CuentasManager(ICuentasRepository repository) {

    this.cuentasRepository = repository;
  }

  public void crearCuenta(Cuenta cuenta) {
    this.cuentasRepository.guardarNuevaCuenta(cuenta);
  }

  public void editarCuenta(Cuenta cuenta) {
    this.cuentasRepository.actualizarCuenta(cuenta);
  }

  public void eliminarCuenta(int numeroCuenta) {
    this.cuentasRepository.eleminarCuenta(numeroCuenta);
  }
}
