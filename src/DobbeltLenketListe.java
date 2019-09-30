////////////////// class DobbeltLenketListe //////////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;



public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node hode;          // peker til den første i listen
    private Node hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        hode = hale = null;               // hode er null
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        this();  // alle variabelene er nullet
        Objects.requireNonNull(a, "Tabellen a er null");

        // Finner den første i a som ikke er null
        int i = 0;
        for (; i < a.length && a[i] == null; i++) ;

        if (a.length == 1) {//Hvis tabellen kun har et element peker hode og hale til samme verdi
            Node<T> p = hode = hale = new Node<>(a[i], null, null);
        } else {
            if (i < a.length) {
                Node<T> p = hode = new Node<>(a[i], null, null);  // den første noden
                antall = 1;

                for (i++; i < a.length; i++) {
                    if (a[i] != null) {
                        p = p.neste = new Node<>(a[i], null, null);   // en ny node
                        antall++;
                    }
                }
                hale = p;
            }
        }

    }

    public Liste<T> subliste(int fra, int til) {
        throw new NotImplementedException();
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return (antall == 0 && hode == null && hale == null);
    }

    @Override
    public boolean leggInn(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T hent(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T fjern(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public void nullstill() {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('[');
        if (!tom()) {
            Node<T> p = hode;
            s.append(p.verdi);

            p = p.neste;

            while (p != null)  // tar med resten hvis det er noe mer
            {
                s.append(',').append(' ').append(p.verdi);
                p = p.neste;
            }
        }

        s.append(']');

        return s.toString();
    }

    public String omvendtString() {
        StringBuilder s = new StringBuilder();
        s.append('[');
        if (!tom()) {
            Node<T> p = hale;
            s.append(p.verdi);
            p = p.forrige;
            while (p != null) {
                s.append(',').append(' ').append(p.verdi);
                p = p.neste;
            }
        }

        s.append(']');

        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new NotImplementedException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new NotImplementedException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new NotImplementedException();
        }


        @Override
        public T next() {
            throw new NotImplementedException();
        }

        @Override
        public void remove() {
            throw new NotImplementedException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new NotImplementedException();
    }

    private Node<T> finnNode(int indeks) {

        Node<T> p = hode, hale;

        if (indeks < antall / 2) {
            for (int i =0; i < indeks; i++) p = p.neste;
        }
        else if (indeks > antall / 2) {
            for (int j = 0; j < indeks; j--) p = p.neste;
        }
        return p;
    }

        public static void main (String[]args){
            String[] s = {};
            //String [] s={"Ole", null,"Per","Kari", null};
            Liste<String> liste = new DobbeltLenketListe<>(s);
            String[] s1 = {}, s2 = {"A"}, s3 = {null, "A", null, "B", null};

            DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
            DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
            DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
            System.out.println(l1.toString() + " " + l2.toString() + " " + l3.toString() + l1.omvendtString() + " " + l2.omvendtString() + " " + l3.omvendtString());

        }



}// class DobbeltLenketListe


