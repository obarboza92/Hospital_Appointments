package citasebais;

import javax.swing.JOptionPane;

public class listas {

    nodo primero;
    nodo ultimo;
    boolean contador = true;

    public listas() {
        primero = null;
        ultimo = null;
    }

    // metodo para agregar cita 
    public void ingresarCita(int numeroCita, String NombrePaciente, String hora, String fecha, String nombreDoctor) {        
        nodo actual = new nodo();

        actual = primero;
        boolean encontrado = false;
        if (primero == null) {
            //si el primero esta null se salta la busqueda y procede a agregar el primer nodo
        } else {
            do {
                if (actual.fecha.equals(fecha)) {
                    if (actual.hora.equals(hora)) {
                        encontrado = true;
                    }
                }
                actual = actual.siguiente;
            } while (actual != primero);
            if (encontrado == true) {
                JOptionPane.showMessageDialog(null, "Espacio ocupado");
                contador = false;
            } else {
                nodo nuevo = new nodo();
                nuevo.numeroCita = numeroCita;
                nuevo.NombrePaciente = NombrePaciente;
                nuevo.hora = hora;
                nuevo.fecha = fecha;
                nuevo.nombreDoctor = nombreDoctor;

                ultimo.siguiente = nuevo;
                nuevo.siguiente = primero;
                ultimo = nuevo;
                contador = true;

            }
        }
        if (primero == null) {
            nodo nuevo = new nodo();
            nuevo.numeroCita = numeroCita;
            nuevo.NombrePaciente = NombrePaciente;
            nuevo.hora = hora;
            nuevo.fecha = fecha;
            nuevo.nombreDoctor = nombreDoctor;

            primero = nuevo;
            ultimo = primero;
            primero.siguiente = ultimo;
            contador = true;
        }

    }

    // metodo para buscar paciente por nombre
    public void buscarPaciente(String nombrePaciente) {
        nodo actual = new nodo();
        actual = primero;
        boolean encontrado = false;
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "no hay citas");
        } else {
            do {
                if (actual.NombrePaciente.equals(nombrePaciente)) {
                    encontrado = true;
                    System.out.println(" Hora de la cita de " + actual.NombrePaciente + ": " + actual.hora + " "
                            + "\n Dia de la cita de " + actual.NombrePaciente + ": " + actual.fecha + "\n" + ""
                            + " ---------------------------------------\n");
                }
                actual = actual.siguiente;
            } while (actual != primero);
            if (encontrado == true) {

            } else {
                JOptionPane.showMessageDialog(null, "Paciente no existe");
            }
        }

    }

    // metodo para mostrar toda la consulta del ebais
    public void mostrarConsulta() {
        nodo actual = new nodo();
        actual = primero;
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "no hay citas");
        } else {
            do {
                System.out.println(" Numero de Cita: " + actual.numeroCita + ""
                        + "\n Nombre de Paciente: " + actual.NombrePaciente + ""
                        + "\n Hora de cita: " + actual.hora + ""
                        + "\n fecha de cita: " + actual.fecha + ""
                        + "\n Doctor Asignado: " + actual.nombreDoctor + "\n" + ""
                        + " ---------------------------------------\n");
                actual = actual.siguiente;
            } while (actual != primero);
        }

    }

    // metodo para elminar cita
    public void eliminarCita(String nombrePaciente) {
        nodo actual = new nodo();
        nodo anterior = new nodo();
        actual = primero;
        anterior = ultimo;
        boolean encontrado = false;
        if (actual == null && anterior == null) {
            JOptionPane.showMessageDialog(null, "no hay citas");
        } else {
            do {
                if (actual.NombrePaciente.equals(nombrePaciente)) {
                    if (primero == ultimo) {
                        primero = null;
                        ultimo = null;
                        encontrado = true;
                        break;
                    } else {
                        if (actual == primero) {
                            primero = primero.siguiente;
                            ultimo.siguiente = primero;
                            encontrado = true;
                        } else if (actual == ultimo) {
                            anterior.siguiente = ultimo.siguiente;
                            ultimo = anterior;
                            encontrado = true;
                        } else {
                            anterior.siguiente = actual.siguiente;
                            encontrado = true;
                        }

                    }
                }
                anterior = actual;
                actual = actual.siguiente;
            } while (actual != primero);
        }

        if (encontrado == false && actual != null) {
            JOptionPane.showMessageDialog(null, "Usuario no existe");
        }

    }
}
