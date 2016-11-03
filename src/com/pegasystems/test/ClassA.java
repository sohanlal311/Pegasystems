package com.pegasystems.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ClassA implements Serializable, Cloneable {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ClassA instance = ClassA.getInstance();
		System.out.println(instance);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("sohan.txt")));
		objectOutputStream.writeObject(instance);
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("sohan.txt")));
		instance = (ClassA) objectInputStream.readObject();
		System.out.println(instance);
	}

	private static volatile ClassA instance;

	private ClassA() {

	}

	public static ClassA getInstance() {
		if (instance == null) {
			synchronized (ClassA.class) {
				if (instance == null) {
					instance = new ClassA();
				}
			}
		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public Object readResolve() {
		return instance;
	}

}
