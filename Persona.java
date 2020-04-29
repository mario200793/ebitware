package project;

import javax.swing.JOptionPane;

public class Persona {

    /// Constantes
    private final static char Sexo_const = 'H';

    public final static int Peso_bajo = -1;

    public final static int Peso_ideal = 0;

    public final static int Peso_alto = 1;

    /// Atributos

    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    /// Persona
    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        dni_prueba();
        this.sexo = sexo;
        sexo_prueba();
    }
    private void sexo_prueba() {
        /// Comprobamos el sexo
        if (sexo != 'H' && sexo != 'M') {
            this.sexo = Sexo_const;
        }
    }
    private void dni_prueba(){
        /// Generamos el numero para un DNI
        int dni_0 = ((int) Math.floor(Math.random()*(10000000-1000000)+1000000));
        /// llamamos al metodo dni_letra que me convierte el dni_0 que esta en numero, a letra
        DNI = Integer.toString(dni_letra(dni_0));
    }

    private char dni_letra(int dni_l) {
        String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int modulo = dni_l % 23;
        char letra = juegoCaracteres.charAt(modulo);
        return letra;
    }

    ///Metodos set de cada parametro:
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public void setPesoe(double peso) {
        this.peso = peso;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    /// Calculamos IMC:
    public int calcularIMC() {
        //Formula dada en el examen
        double pesoActual = peso / (Math.pow(altura, 2));
        //Condicion que devuelve si tu peso es alto bajo o ideal
        if (pesoActual >= 20 && pesoActual <= 25) {
            return Peso_ideal;
        } else if (pesoActual < 20) {
            return Peso_bajo;
        } else {
            return Peso_alto;
        }
    }
    /// Para saber si es mayor de edad:
    public boolean Mayor_edad() {
        boolean mayor = false;
        if (edad >= 18) {mayor = true;}
        return mayor;
    }

    public String toString() {
        String sexo_s;
        if (this.sexo == 'H') {
            sexo_s = "Hombre";
        } else {
            sexo_s = "Mujer";
        }
        return "Informacion de la persona:\n"
                + "Nombre: " + nombre + "\n"
                + "Sexo: " + sexo_s + "\n"
                + "Edad: " + edad + " años\n"
                + "DNI: " + DNI + "\n"
                + "Peso: " + peso + " kg\n"
                + "Altura: " + altura + " metros\n";
    }

}

