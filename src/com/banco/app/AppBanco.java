package com.banco.app;

import com.banco.dominio.CuentaBancaria;
import com.banco.dominio.Persona;

public class AppBanco {
    public static void main(String[] args) {
        CuentaBancaria miCuenta = new CuentaBancaria();
        miCuenta.consignar(900000);

        if (miCuenta.estaActiva()) {
            System.out.println("La cuenta está activa, puede proseguir con su proceso💵.");
        } else {
            System.out.println("La cuenta se encuentra inactiva.");
        }

        System.out.println(miCuenta.consultarSaldo());

        long valorARetirar = 10000;
        if (miCuenta.retirar(valorARetirar)) {
            System.out.println("Retiro exitoso. Su nuevo saldo es de: " + miCuenta.saldo);
        } else {
            System.out.println("No fue posible realizar el retiro, intente nuevamente.");
        }

        long valorAConsignar = 200;
        miCuenta.consignar(valorAConsignar);
        System.out.println("Consignacion exitosa. Su nuevo saldo es de: " + miCuenta.saldo);

        Persona usuario1 = new Persona();
        usuario1.nombre = "Cuenta 1";
        usuario1.identificacion = "000001";
        CuentaBancaria cuenta1 = new CuentaBancaria();
        cuenta1.consignar(900000);
        usuario1.propietario = cuenta1;

        Persona usuario2 = new Persona();
        usuario2.nombre = "Cuenta 2";
        usuario2.identificacion = "000002";
        CuentaBancaria cuenta2 = new CuentaBancaria();
        cuenta2.consignar(900000);
        usuario2.propietario = cuenta2;

        long valorATransferir = 50000;
        if (usuario1.propietario.transferir(valorATransferir, usuario2.propietario)) {
            System.out.println("Transferencia exitosa. El nuevo saldo de la cuenta1 es de: " + usuario1.propietario.saldo);
            System.out.println("El nuevo saldo de la cuenta2 es de: " + usuario2.propietario.saldo);
        } else {
            System.out.println("No fue posible realizar la transferencia, intente nuevamente.");
        }
    }
}
