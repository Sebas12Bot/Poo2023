package com.banco.dominio;

public class CuentaBancaria {
    public long saldo;
    public int numero;
    public boolean activa = true;
    public Banco banco;

    public boolean estaActiva() {
        return activa;
    }

    public void consignar(long valorAConsignar) {
        if (!estaActiva()) {
            System.out.println("No se puede realizar la consignación. La cuenta está inactiva.");
            return;
        }

        if (valorAConsignar <= 0) {
            System.out.println("El valor a consignar debe ser mayor que cero.");
            return;
        }

        saldo += valorAConsignar;
    }

    public boolean retirar(long valorARetirar){
        if (!estaActiva()){
            return false;
        }
        if (valorARetirar <= 0) {
            return false;
        }
        if (valorARetirar > saldo) {
            return false;
        }
        saldo -= valorARetirar;
        return true;
    }

    public String consultarSaldo() {
        String mensajeSaldo = "Tu saldo es de: " + saldo;
        return mensajeSaldo;
    }

    public boolean transferir(long valorATransferir, CuentaBancaria cuentaDestino){
        if (!estaActiva()) {
            System.out.println("No se puede realizar la transferencia. La cuenta de origen está inactiva.");
            return false;
        }

        if (valorATransferir <= 0) {
            System.out.println("La transferencia debe tener un valor minimo de 50.");
            return false;
        }

        if (valorATransferir > saldo) {
            System.out.println("Saldo insuficiente. No fue posible realizar la transferencia.");
            return false;
        }
        if (!cuentaDestino.estaActiva()) {
            System.out.println("No se puede realizar la transferencia. La cuenta de destino se encuentra inactiva.");
            return false;
        }

        saldo -= valorATransferir;
        cuentaDestino.consignar(valorATransferir);
        System.out.println("Transferencia exitosa. Se transfirieron " + valorATransferir + " a la cuenta destino.");
        return true;
    }
}