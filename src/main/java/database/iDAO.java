package database;


import java.util.ArrayList;

public interface iDAO<A>  {
        public ArrayList<A> list();

        public A get(int id);

        public boolean remove(int id);

        public A update(int id, A newA);

        public A add(A newA);

        public int getLastId();
}

