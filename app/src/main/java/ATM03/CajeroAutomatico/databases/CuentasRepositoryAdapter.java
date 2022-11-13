package ATM03.CajeroAutomatico.databases;

import ATM03.entities.Cuenta;
import ATM03.repositories.HashMapBinFileCuentasRepository;
import ATM03.repositories.HashMapBinFileCuentasRepository;
import ATM03.repositories.interfaces.ICuentasRepository;

public class CuentasRepositoryAdapter extends BaseDatosBanco {
  private ICuentasRepository cuentasRepository;

  public CuentasRepositoryAdapter(String rutaArchivo) {
    this.cuentasRepository = HashMapBinFileCuentasRepository.obtenerInstancia(rutaArchivo);
  }

  private Cuenta obtenerCuenta(int numeroCuenta) {
    Cuenta[] result = this.cuentasRepository.obtenerCUenta(numeroCuenta);

    if (result.length > 0) {
      Cuenta cuenta = result[0];
      
      return cuenta;
    } else {
      return null;
    }
  }

  @Override
  public boolean autenticarUsuario(int numeroCuentaUsuario, int nipUsuario) {
    Cuenta cuenta = this.obtenerCuenta(numeroCuentaUsuario);

    if (cuenta != null) {
      return cuenta.validarNIP(nipUsuario);
    } else {
      return false;
    }
  }

  @Override
  public double obtenerSaldoDisponible(int numeroCuentaUsuario) {
    Cuenta cuenta = this.obtenerCuenta(numeroCuentaUsuario);
    
    return cuenta.obtenerSaldoDisponible();
  }

  @Override
  public double obtenerSaldoTotal(int numeroCuentaUsuario) {
    Cuenta cuenta = this.obtenerCuenta(numeroCuentaUsuario);
    
    return cuenta.obtenerSaldoTotal();
  }

  @Override
  public void abonar(int numeroCuentaUsuario, double monto) {
    Cuenta cuenta = this.obtenerCuenta(numeroCuentaUsuario);

    cuenta.abonar(monto);
    this.cuentasRepository.actualizarCuenta(cuenta);
  }

  @Override
  public void cargar(int numeroCuentaUsuario, double monto) {
    Cuenta cuenta = this.obtenerCuenta(numeroCuentaUsuario);

    cuenta.cargar(monto);
    this.cuentasRepository.actualizarCuenta(cuenta);
  }

  public boolean guardadCuenta(Cuenta cuenta) {
    return this.cuentasRepository.guardarNuevaCuenta(cuenta);
  }
}

