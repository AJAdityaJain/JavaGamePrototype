package dev.code.game.StructGen;

import java.util.ArrayList;

import dev.code.game.entities.Entities;

public class Floor {
	public int z;
	public ArrayList<Room> Rooms = new ArrayList<Room>();
	public ArrayList<Entities> Entities = new ArrayList<Entities>();
	public Floor(int z) {
		this.z = z;
		Rooms.add(new Room(0,0,z));
	}
}
