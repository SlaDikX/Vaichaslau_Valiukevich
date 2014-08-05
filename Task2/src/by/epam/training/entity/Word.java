package by.epam.training.entity;

import java.util.List;

public class Word implements Document {
	private String name;

	@Override
	public void add(Document text) {
	}

	@Override
	public void remove(Document text) {
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Document getChild(int i) {
		return null;
	}

	@Override
	public int getSizeOfChilds() {
		return 0;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Word other = (Word) obj;
		if (name == null) {
			{
				if (other.name != null) {
					return false;
				}
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public List<Document> getListOfChilds() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int compareTo(Document o) {
		return getSizeOfChilds()-o.getSizeOfChilds();
		
	}
}
