package ATM03.repositories.interfaces;

import ATM03.entities.Cuenta;

public interface ICuentasRepository {
  Cuenta[] obtenerCUenta(int numeroCuenta);
  boolean guardarNuevaCuenta(Cuenta cuenta);
  boolean actualizarCuenta(Cuenta cuenta);
  boolean eleminarCuenta(int numeroCuenta);
}
