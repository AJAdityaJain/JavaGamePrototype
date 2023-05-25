package dev.code.game.StructGen;

import java.util.ArrayList;

public class Dungeon {
	public ArrayList<Floor> floors = new ArrayList<Floor>();
	public Dungeon() {
		floors.add(new Floor(0));
	}
}
