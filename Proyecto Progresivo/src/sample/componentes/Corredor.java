package sample.componentes;

import javafx.scene.control.ProgressBar;

public class Corredor extends Thread {
    private ProgressBar pgbCarril;
    String nombre;

    public Corredor(String nombre, ProgressBar pgb) {

        super(nombre);//con super se hace referencia al constructor de la clase padre-
        this.pgbCarril = pgb;
    }

    @Override
    public void run() {
        super.run();
        double avance = 0;

        //representa la cantidad de kilometros que va a correr
        for (int i = 1; i <= 10; i++) {
            while (avance < 1) {
                try {

                    avance += Math.random() / 10;
                    //así se castea
                    Thread.sleep((long) (Math.random() * 1000));
                    pgbCarril.setProgress(avance);
                    System.out.println("Corredor " + getName() + "" + "(Km." + i + ")");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("corredor " + getName() + " llegó a la meta");
    }
}
