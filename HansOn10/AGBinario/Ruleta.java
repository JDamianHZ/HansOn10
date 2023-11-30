
public class Ruleta {

    static double Dato1=Generar.divisiones.get(0);
    static double Dato2=Generar.divisiones.get(1);
    static double Dato3=Generar.divisiones.get(2);
    static double Dato4=Generar.divisiones.get(3);
    static double Dato5=Generar.divisiones.get(4);
    static double Dato6=Generar.divisiones.get(5);

    static String cromo1=Generar.GenerarN.get(0);
    static String cromo2=Generar.GenerarN.get(1);
    static String cromo3=Generar.GenerarN.get(2);
    static String cromo4=Generar.GenerarN.get(3);
    static String cromo5=Generar.GenerarN.get(4);
    static String cromo6=Generar.GenerarN.get(5);


    static void ruleta(){
        double Dato1M= Dato1*100;
        double Dato1MR= Math.round(Dato1M);

        double Dato2M= Dato2*100;
        double Dato2MR= Math.round(Dato2M);

        double Dato3M= Dato3*100;
        double Dato3MR= Math.round(Dato3M);

        double Dato4M= Dato4*100;
        double Dato4MR= Math.round(Dato4M);

        double Dato5M= Dato5*100;
        double Dato5MR= Math.round(Dato5M);

        double Dato6M= Dato6*100;
        double Dato6MR= Math.round(Dato6M);


        System.out.println(Dato1MR+Dato2MR+Dato3MR+Dato4MR+Dato5MR+Dato6MR);


        for (int i=0; i<Dato1MR;i++){
            Generar.RuletaA.add(cromo1);
        }
        for (int i=0; i<Dato2MR;i++){
            Generar.RuletaA.add(cromo2);
        }
        for (int i=0; i<Dato3MR;i++){
            Generar.RuletaA.add(cromo3);
        }
        for (int i=0; i<Dato4MR;i++){
            Generar.RuletaA.add(cromo4);
        }
        for (int i=0; i<Dato5MR;i++){
            Generar.RuletaA.add(cromo5);
        }
        for (int i=0; i<Dato6MR;i++){
            Generar.RuletaA.add(cromo6);
        }


    }

}
