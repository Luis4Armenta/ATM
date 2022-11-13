package ATM03.CuentasManager.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ATM03.CuentasManager.models.CuentasManager;
import ATM03.CuentasManager.views.CuentasManagerMenu;

public class EliminarCuentaBtnController implements ActionListener{
  private CuentasManagerMenu vista;
  private CuentasManager modelo;

  public EliminarCuentaBtnController(CuentasManager modelo, CuentasManagerMenu vista) {
    this.modelo = modelo;
    this.vista = vista;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.modelo.eliminarCuenta(Integer.parseInt(this.vista.NumeroCuentaTField.getText()));
    this.vista.NumeroCuentaTField.setText("");
  }
  
}
