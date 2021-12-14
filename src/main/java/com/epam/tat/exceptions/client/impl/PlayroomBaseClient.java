package com.epam.tat.exceptions.client.impl;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.client.IPlayroom;

import java.util.List;

public class PlayroomBaseClient implements IPlayroom {

	private List<Toy> toyList;

	public PlayroomBaseClient(List<Toy> toyList) {
		this.toyList = toyList;
	}

	@Override
	public List<Toy> getAllToys() {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	@Override
	public List<Toy> getToysByParameter(String parameter, String value) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	@Override
	public boolean addToy(Toy toy) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	@Override
	public boolean removeToy(Toy toy) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	@Override
	public boolean updateToy(Long id, Toy toy) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

}
