package by.epam.training.entity;

import java.util.List;

public interface Document extends Comparable<Document> {
	public void add(Document text);

	public void remove(Document text);

	public String getName();

	public void setName(String name);

	public Document getChild(int i);

	public int getSizeOfChilds();
	
	public List<Document> getListOfChilds();
}
