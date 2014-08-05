package by.epam.training.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Text implements Document {
	private List<Document> text;
	private String name;

	public Text() {
		text = new ArrayList<Document>();
	}

	@Override
	public void add(Document text) {
		this.text.add(text);

	}

	@Override
	public void remove(Document text) {
		this.text.remove(text);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		Iterator<Document> textIterator = text.iterator();
		while (textIterator.hasNext()) {
			Document doc = textIterator.next();
			s.append(doc.getName());
			s.append(" ");
		}
		return s.toString();
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
		return text.get(i);
	}

	@Override
	public int getSizeOfChilds() {

		return text.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Text other = (Text) obj;
		if (name == null) {
			{
				if (other.name != null) {
					return false;
				}
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (text == null) {
			{
				if (other.text != null) {
					return false;
				}
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		return true;
	}

	@Override
	public List<Document> getListOfChilds() {
		// TODO Auto-generated method stub
		return text;
	}
	@Override
	public int compareTo(Document o) {
		return getSizeOfChilds()-o.getSizeOfChilds();
		
	}
}
