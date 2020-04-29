package project;

import javax.swing.JOptionPane;

/// Creo la pantalla, para ingresar datos
public class Pantalla {

    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("nombre:");
        String texto = JOptionPane.showInputDialog("edad:");
        int edad = Integer.parseInt(texto);
        texto = JOptionPane.showInputDialog("sexo:");
        char sexo = texto.charAt(0);
        texto = JOptionPane.showInputDialog("peso:");
        double peso = Double.parseDouble(texto);
        texto = JOptionPane.showInputDialog("altura:");
        double altura = Double.parseDouble(texto);

        /// Creamos persona
        Persona persona = new Persona(nombre, edad, sexo, peso, altura);

        //Usamos metodos para realizar la misma accion para cada objeto
        System.out.println("Persona");
        MuestraMensajePeso(persona);
        MuestraMayorDeEdad(persona);
        System.out.println(persona.toString());
    }

    public static void MuestraMensajePeso(Persona p) {
        int IMC = p.calcularIMC();
        switch (IMC) {
            case Persona.Peso_ideal:
                System.out.println("Tiene peso ideal");
                break;
            case Persona.Peso_bajo:
                System.out.println("Tiene bajo peso");
                break;
            case Persona.Peso_alto:
                System.out.println("Tiene sobrepeso");
                break;
        }
    }

    public static void MuestraMayorDeEdad(Persona p) {

        if (p.Mayor_edad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
    }

}