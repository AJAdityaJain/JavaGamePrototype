package dev.code.game.economy;

import dev.code.game.items.Items;

public class Deal {
	public int numInp;
	public Items objInp;
	public int numOut;
	public Items objOut;

	public Deal(Items objInp, int numInp, Items objOut, int numOut) {
		this.objInp = objInp;
		this.numInp = numInp;
		this.objOut = objOut;
		this.numOut = numOut;
	}
}