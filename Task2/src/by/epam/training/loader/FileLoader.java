package by.epam.training.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {
	FileReader in;
	BufferedReader brin = null;

	public BufferedReader open(String path) throws FileNotFoundException {
		in = new FileReader(path);
		brin = new BufferedReader(in);
		return brin;
	}

	public void close() throws IOException {
		brin.close();
	}
}
