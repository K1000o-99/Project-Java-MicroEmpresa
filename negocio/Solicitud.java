/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microempresa.negocio;

import microempresa.negocio.Cliente;
import microempresa.negocio.Producto;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author
 */
public class Solicitud {

    //atributos
    private int numero, total;
    private Date fecha;
    private Cliente cliente;
    private String productos = "";

    //constructor sin parámetros
    public Solicitud() {
    }

    //constructor con parámetros
    public Solicitud(int numero, int total, Date fecha, Cliente cliente, String productos) {
        this.numero = numero;
        this.total = total;
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = productos;
    }

    //accesadores y mutadores
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    //agregar productos a la solicitud
    public void agregarProductos(Producto producto) {
        String unidadMedida = "";

        if (producto.getMedida() == 'U') {
            unidadMedida = "unidades";
        } else {
            unidadMedida = "gramos";
        }

        this.total = this.total + producto.getPrecio();
        this.productos = this.productos + producto.getDescripcion() + " " + producto.getCantidad() + " " + unidadMedida + " $" + producto.getPrecio() + ";\n";

    }

    //ver pedido
    public void verSolicitud() {
        SimpleDateFormat formated = new SimpleDateFormat("dd-MMM-yyyy");
        System.out.println("Solicitud: " + this.numero);
        System.out.println("*****************************");
        System.out.println("Cliente: " + this.cliente.getNombre());
        System.out.println("Fecha: " + formated.format(this.fecha));
        System.out.println(this.productos);
        System.out.println("*****************************");
        System.out.println("Total: $" + this.total);
        System.out.println("");
    }

    //descontar
    public int descontar(int porcentaje) {
        int descuento = (int) (this.total * porcentaje / 100);
        return descuento;
    }
}
