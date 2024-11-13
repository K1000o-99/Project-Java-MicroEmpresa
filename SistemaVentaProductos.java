package microempresa;

import microempresa.negocio.Solicitud;
import microempresa.negocio.Validador;
import microempresa.negocio.Cliente;
import microempresa.negocio.Producto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author
 */
public class SistemaVentaProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // variables a usar para controlar el menu y ciclos de validación
        int opcion; // opción de menu ingresada por un usuario
        boolean flag; //validaciones
        // datos a ingresar del cliente
        int rut, telefono;
        String nombre, mail, direccion;
        char dv;
        //datos a ingresar del producto
        int codigo, precio, cantidad, totalProductos;
        String subcategoria, descripcion;
        char medida;
        // datos a ingresar de la solicitud
        int numero = 0;
        String fecha;
        int porcentaje;
        int descuento;

        // variable para leer el teclado
        Scanner teclado = new Scanner(System.in);

        // se instancia el validador para usar sus métodos
        Validador valida = new Validador();
        // se instancia un cliente usando constructor sin parámetros para
        // setear sus valores luego de validarlos
        Cliente cliente = new Cliente();
        // se instancia una solicitud usando constructor sin parámetros para
        // setear sus valores luego de validarlos
        Solicitud sol = new Solicitud();

        do {
            System.out.println();
            System.out.println("ESTA APLICACION SIMULA UNA SESION DE COMPRA DE PRODUCTOS DE UN CLIENTE.");
            System.out.println("POR AHORA, ESTA APLICACIÓN NO VALIDA QUE SE HAYA INGRESADO UN CLIENTE,");
            System.out.println("PREVIO A INGRESAR UNA SOLICITUD DE COMPRA, PREVIO A MOSTRAR EL DETALLE");
            System.out.println("DE ÉSTA O PREVIO A HACER UN DESCUENTO.");
            System.out.println();
            System.out.println("····· MENU ·····");
            System.out.println("1 Ingresar Cliente");
            System.out.println("2 Ingresar Solicitud y sus Productos");
            System.out.println("3 Aplicar descuento");
            System.out.println("4 Ver Solicitud");
            System.out.println("5 Salir");
            System.out.println();
            System.out.println("Ingrese una opcion:");
            opcion = teclado.nextInt(); // ingresar sólo números si no, aplicación se cae

            switch (opcion) {
                case 1:
                    // repite el ingreso de rut y dv mientras no sea válido
                    System.out.println();
                    do {
                        System.out.println("Ingrese rut:");
                        rut = teclado.nextInt(); // ingresar sólo números si no, aplicación se cae
                        System.out.println("Ingrese DV:");
                        dv = teclado.next().charAt(0);
                        flag = valida.validarRut(rut, dv);
                        if (flag == false) {
                            System.out.println("ERROR: Rut inválido!");
                        }
                    } while (flag == false);
                    System.out.println("Ingrese su nombre:");
                    nombre = teclado.next();
                    // repite ingreso del teléfono mientras no sea válido
                    do {
                        System.out.println("Ingrese teléfono:");
                        telefono = teclado.nextInt();  // ingresar sólo números si no, aplicación se cae
                        flag = valida.validarTelefono(telefono);
                        if (flag == false) {
                            System.out.println("ERROR: Teléfono inválido.  El largo debe ser de ocho dígitos.");
                        }
                    } while (flag == false);
                    // repite el ingreso del email, mientras no sea válido
                    do {
                        System.out.println("Ingrese e-mail:");
                        mail = teclado.next();
                        flag = valida.validarCorreo(mail);
                        if (flag == false) {
                            System.out.println("ERROR: Mail inválido.  El largo debe ser de al menos seis caracteres.");

                        }
                    } while (flag == false);
                    System.out.println("Ingrese dirección:");
                    direccion = teclado.next();

                    //guardar los datos válidos en el cliente
                    cliente.setRut(rut);
                    cliente.setDv(dv);
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setMail(mail);
                    cliente.setDireccion(direccion);

                    System.out.println("----------------------------------------");
                    break;
                case 2:
                    numero +=1; // se incrementa en 1 el número de solicitud cada vez que se cree una nueva
                    sol.setNumero(numero);
                    sol.setCliente(cliente);
                    Date fechaDate = null;
                    // repite el ingreso de la fecha mientras no sea válida
                    System.out.println();
                    do {
                        System.out.println("Ingrese la Fecha de la solicitud(dd/mm/yyyy):");
                        fecha = teclado.next();
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // la clase SimpleDateFormat permite validaar el formato de entreda
                        try {
                            fechaDate = formato.parse(fecha);
                            flag = valida.validarFecha(fechaDate);
                        } catch (ParseException ex) {
                            flag = false;
                            System.out.println("ERROR: Fecha inválida.  Debe ajustarse el formato de entrada dd/mm/yyyy");
                        }
                    } while (flag == false);
                    sol.setFecha(fechaDate);

                    //Productos     
                    System.out.println("¿Cuántos Productos comprará?");
                    totalProductos = teclado.nextInt(); // ingresar sólo números si no, aplicación se cae
                    // repite el ingreso de productos según cuántos productos vaya a comprar
                    for (int i = 1; i <= totalProductos; i++) {
                        Producto prod = new Producto();
                        codigo = 0;
                        precio = 0;
                        cantidad = 0;
                        subcategoria = "";
                        descripcion = "";
                        medida = ' ';
                        // repite el ingreso del código mientras no sea válido
                        do {
                            System.out.println("Ingrese el código de un producto:");
                            codigo = teclado.nextInt(); // ingresar sólo números si no, aplicación se cae
                            flag = valida.validarCodigo(codigo);
                            if (flag == false) {
                                System.out.println("ERROR: Código inválido.  Debe tener cuatro digitos.");
                            }
                        } while (flag == false);
                        // repite el ingreso del precio mientras no sea válido
                        do {
                            System.out.println("Ingrese el precio:");
                            precio = teclado.nextInt(); // ingresar sólo números si no, aplicación se cae
                            flag = valida.validarPrecio(precio);
                            if (flag == false) {
                                System.out.println("ERROR: Precio inválido.  Debe ser un número positivo.");
                            }
                        } while (flag == false);
                        // repite el ingreso de la sucategoría mientras no sea válida
                        do {
                            System.out.println("Ingrese subcategoría (Fruta o Verdura):");
                            subcategoria = teclado.next();
                            flag = valida.validarSubcategoria(subcategoria);
                            if (flag == false) {
                                System.out.println("ERROR: Subcategoria inválida.  Debe ingresar la palabra Fruta o Verdura.");
                            }
                        } while (flag == false);

                        System.out.println("Ingrese descripción(nombre) del producto que lleva:");
                        descripcion = teclado.next();
                        // repite el ingreso de la unidad de medida mientras no sea válida
                        do {
                            flag = true;
                            System.out.println("Ingrese la unidad de medida (U:unidad o G:gramos)");
                            medida = teclado.next().toUpperCase().charAt(0);
                            switch (medida) {
                                case 'U':
                                    System.out.println("Ingrese la cantidad de unidades:");
                                    break;
                                case 'G':
                                    System.out.println("Ingrese los gramos:");
                                    break;
                                default:
                                    System.out.println("ERROR: Unidad de medida inválida.  Debe ingresar U (unidades) o G (gramos)");
                                    flag = false;
                                    break;
                            }
                        } while (flag == false);
                        cantidad = teclado.nextInt(); // ingresar sólo números si no, aplicación se cae

                        //guardar los datos válidos en el producto
                        prod.setCodigo(codigo);
                        prod.setPrecio(precio);
                        prod.setSubcategoria(subcategoria);
                        prod.setDescripcion(descripcion);
                        prod.setMedida(medida);
                        prod.setCantidad(cantidad);

                        // agrega el producto a la solicitud
                        sol.agregarProductos(prod);
                        System.out.println("----------------------------------------º");
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Ingrese porcentaje de descuento (1% - 100%):");
                    porcentaje = teclado.nextInt(); // ingresar sólo números si no, aplicación se cae
                    descuento = sol.descontar(porcentaje);
                    System.out.println("Total: $" + sol.getTotal());
                    System.out.println("Descuento: $" + descuento);
                    System.out.println("------------------------");
                    System.out.println("A Pagar: $" + (sol.getTotal() - descuento));
                    break;
                case 4:
                    System.out.println();
                    sol.verSolicitud();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Opción Inválida");
            }
        } while (opcion != 5);
    }
}
