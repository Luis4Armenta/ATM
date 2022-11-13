/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM03.CuentasManager.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ATM03.CuentasManager.models.CuentasManager;
import ATM03.CuentasManager.views.CuentasManagerMenu;

/**
 *
 * @author luigi
 */

public class CrearCuentaBtnController implements ActionListener{
  CuentasManager modelo;
  CuentasManagerMenu vista;
  
  public CrearCuentaBtnController(CuentasManagerMenu vista, CuentasManager modelo) {
    this.modelo = modelo;
    this.vista = vista;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    int numeroCuenta = Integer.parseInt(this.vista.NumeroCuentaTField.getText());

    this.modelo.crearCuenta(null);
  }
    
}
