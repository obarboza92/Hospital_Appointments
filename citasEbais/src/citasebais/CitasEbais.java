package citasebais;

import java.util.ArrayList;
//import static java.util.Collections.list;
import java.util.List;
import javax.swing.JOptionPane;

public class CitasEbais {

    public static void main(String[] args) {
        // lista de dias de la semana permitidos
        List<String> diasValidos = new ArrayList<>();

        diasValidos.add("lunes");
        diasValidos.add("martes");
        diasValidos.add("miercoles");
        diasValidos.add("jueves");
        diasValidos.add("viernes");

        //lista de horas permitidas
        List<String> horasValidas = new ArrayList<>();

        horasValidas.add("7:00am");
        horasValidas.add("7:30am");
        horasValidas.add("8:00am");
        horasValidas.add("8:30am");
        horasValidas.add("9:00am");
        horasValidas.add("9:30am");
        horasValidas.add("10:00am");
        horasValidas.add("10:30am");
        horasValidas.add("11:00am");
        horasValidas.add("11:30am");
        horasValidas.add("12:00md");
        horasValidas.add("12:30pm");
        horasValidas.add("1:00pm");
        horasValidas.add("1:30pm");
        horasValidas.add("2:00pm");
        horasValidas.add("2:30pm");
        horasValidas.add("3:00pm");
        horasValidas.add("3:30pm");

        listas l = new listas();
        int opcion = 0;

        int numeroCita = 1;
        String nombrePaciente;
        String hora;
        String fecha;
        String nombreDoctor;

        // mensaje de bienvenida    
        JOptionPane.showMessageDialog(null, " Bienvenido al EBAIS \n"
                + " La citas se asignan de Lunes a Viernes en horario de 7:00am a 3:30pm \n"
                + " Asegurese de seguir el formato correcto al ingresar sus datos");

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Asignar cita \n"
                        + "2. Eliminar cita(Buscar por paciente)\n"
                        + "3. Mostrar toda la consulta del EBAIS\n"
                        + "4. Buscar paciente para ver dia y hora de cita\n"
                        + "5. Salir", " Menu de Opciones", 3));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Caracter invalido");
            }

            switch (opcion) {

                case 1:
                    boolean error = true;
                    do {
                        try {

                            nombrePaciente = JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente:").toLowerCase();
                            do {
                                hora = JOptionPane.showInputDialog(null, "Ingrese la hora de la cita (formato h:mm am/pm, ej: 10:30am):");
                                if (!horasValidas.contains(hora)) {
                                    JOptionPane.showMessageDialog(null, "Hora ingresada es incorrecta, asegurese de seguir el formato indicado, intente de nuevo");
                                }
                            } while (!horasValidas.contains(hora));

                            do {
                                fecha = JOptionPane.showInputDialog(null, "Ingrese el dia de la semana deseado para su cita:").toLowerCase();
                                if (!diasValidos.contains(fecha)) {
                                    JOptionPane.showMessageDialog(null, "Dia incorrecto, intente de nuevo");
                                } else {

                                }
                            } while (!diasValidos.contains(fecha));

                            nombreDoctor = JOptionPane.showInputDialog(null, "Ingrese el nombre del doctor:");
                            l.ingresarCita(numeroCita, nombrePaciente, hora, fecha, nombreDoctor);

                            error = false;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Caracter invalido");
                        }
                    } while (error);
                    if (l.contador == true) {
                        numeroCita++;
                    }
                    break;
                case 2:
                    nombrePaciente = JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente para eliminar la cita:").toLowerCase();
                    l.eliminarCita(nombrePaciente);
                    break;
                case 3:
                    l.mostrarConsulta();
                    break;
                case 4:
                    nombrePaciente = JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente:").toLowerCase();
                    l.buscarPaciente(nombrePaciente);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Programa Finalizado");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Intente de nuevo");
                    break;
            }

        } while (opcion <= 6);
    }

}
