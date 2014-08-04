package by.epam.training.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sentence implements Document {
	private List<Document> sentence;
	private String name;

	public Sentence() {
		sentence = new ArrayList<Document>();
	}

	@Override
	public void add(Document text) {
		sentence.add(text);
	}

	@Override
	public void remove(Document text) {
		sentence.remove(text);

	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		Iterator<Document> sentenceIterator = sentence.iterator();
		while (sentenceIterator.hasNext()) {
			Document doc = sentenceIterator.next();
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

		return sentence.get(i);
	}

	@Override
	public int getSizeOfChilds() {
		return sentence.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((sentence == null) ? 0 : sentence.hashCode());
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
		Sentence other = (Sentence) obj;
		if (name == null) {
			{
				if (other.name != null) {
					return false;
				}
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (sentence == null) {
			{
				if (other.sentence != null) {
					return false;
				}
			}
		} else if (!sentence.equals(other.sentence)) {
			return false;
		}
		return true;
	}

}
