package by.epam.training.entity;

public interface Document {
	public void add(Document text);

	public void remove(Document text);

	public String getName();

	public void setName(String name);

	public Document getChild(int i);

	public int getSizeOfChilds();
}
