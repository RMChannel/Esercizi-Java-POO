import java.util.ArrayList;

public class Allenamento {
        private ArrayList<Esercizio> esercizi;

        public Allenamento() {
            esercizi = new ArrayList<>();
        }

        public Allenamento(ArrayList<Esercizio> esercizi) {
            this.esercizi = esercizi;
        }

        public void addEsercizio(Esercizio esercizio) {
            esercizi.add(esercizio);
        }

        public void removeEsercizio(Esercizio esercizio) {
            if(!esercizi.remove(esercizio)) {
                throw new IllegalArgumentException("L'esercizio non fa parte dell'allenamento");
            }
        }

        public void printAllEsercizi() {
            int scelta=0;
            for(Esercizio esercizio : esercizi) {
                if(esercizio.getClass()==Cardio.class) {
                    scelta=1;
                    System.out.println("Tipo: Cardio");
                }
                else if(esercizio.getClass()==Forza.class) {
                    scelta=2;
                    System.out.println("Tipo: Forza");
                }
                else {
                    scelta=3;
                    System.out.println("Tipo: Esercizio");
                }
                String difficoltà="";
                switch(esercizio.getDifficoltà()) {
                    case 1:
                        difficoltà="Facile";
                        break;
                    case 2:
                        difficoltà="Media";
                        break;
                    case 3:
                        difficoltà="Difficile";
                        break;
                }
                System.out.println("    Nome: " + esercizio.getNome()+"\n    Durata: "+esercizio.getDurata()+"\n    Ripetizioni: "+esercizio.getRipetizioni()+"\n    Difficoltà"+difficoltà+"\n    Descrizione: "+esercizio.eseguiEsercizio()+"\n");
            }
        }

        public double tempoTotale() {
            double sum=0;
            for(Esercizio esercizio : esercizi) {
                sum+=esercizio.getDurata();
            }
            return sum;
        }

        public ArrayList<Esercizio> getEsercizi() {
            return esercizi;
        }
}
