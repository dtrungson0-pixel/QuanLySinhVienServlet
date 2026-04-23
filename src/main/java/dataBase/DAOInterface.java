package dataBase;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public ArrayList<T> selectAll();

	public T selectByID(int id);

	public int inSert(T t);

	public int delete(T t);

	public int update(T t);
}
