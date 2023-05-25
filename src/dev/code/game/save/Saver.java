package dev.code.game.save;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

import dev.code.game.Game;
import dev.code.game.items.Items;
import dev.code.game.items.AllItems.BroadSword;
import dev.code.game.items.AllItems.LongSword;
import dev.code.game.items.AllItems.Void;
import dev.code.game.ui.Chest; 

public class Saver {

	public static void SaveFile(String t,String l) {
		try {
			t = encrypt(t,4);
			System.out.println(decrypt(t,4));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		File file1 = new File(new File("").getAbsolutePath()+ "\\src\\dev\\code\\game\\save\\"+l+".Please.Do.Not.Peek");
		file1.setWritable(true);
		try {
			file1.createNewFile();
		      FileWriter myWriter = new FileWriter(new File("").getAbsolutePath()+ "\\src\\dev\\code\\game\\save\\"+l+".Please.Do.Not.Peek");
		      myWriter.write(t);
		      myWriter.close();
//		      file1.setWritable(false);
		} catch (IOException e) {
				e.printStackTrace();
		}
		
	}

	public static String ReadFile(String l) {
		String ReturnVal = "";
		try {
		      File myObj =  new File(new File("").getAbsolutePath()+ "\\src\\dev\\code\\game\\save\\"+l+".Please.Do.Not.Peek");
		      Scanner myReader = new Scanner(myObj);
		      ReturnVal += myReader.nextLine();
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return ReturnVal;
	}
	
	public static void readProgress(String file) {
		String s =Saver.decrypt(Saver.ReadFile(file), 4);
		String[][] Arr = new Gson().fromJson(s,String[][].class);
		Game.StorageState.UIObjects.clear();
		for(int i = 0; i < Arr.length;i++) {
			Chest chest = new Chest((i%5)*100, 100*Math.floorDiv(i,5), 100, 100, true);
			for(int I = 0; I < Arr[i].length;I++) {
				Object obj = null;
				switch (Arr[i][I].split("#")[0]) {
					case "Void":
						obj = new Void();
						break;
					case "BroadSword":
						obj = new BroadSword();
						break;
					case "LongSword":
						obj = new LongSword();
						break;
				}
				chest.Inventory.SetItem(obj,Integer.parseInt(Arr[i][I].split("#")[1]), I); ;

			}
			Game.StorageState.UIObjects.add(chest);			
		}			
	}
	
	public static void SaveProggress() {
		String[][] inventoryArr = new String[Game.StorageState.UIObjects.size()][54];
		
		int[] oi = {0};
		Game.StorageState.UIObjects.forEach(obj ->{
			for(var i =0; i< obj.Inventory.ItemArr.length;i++) {
				Items el = obj.Inventory.ItemArr[i];
				if(el != null) {
					inventoryArr[oi[0]][i] = el.getClass().getSimpleName()+"#"+Game.StorageState.UIObjects.get(oi[0]).Inventory.Amount[i];
				}
			}
			oi[0]++;
		});
		
		String inventory = new Gson().toJson(inventoryArr);
		Saver.SaveFile(inventory,"inventory");
	}
	
	public static String encrypt(String t, int key) {
		byte[] bytes = t.getBytes();
		byte[] bytes2 = t.getBytes();
//		for(int i =0; i< bytes.length; i++) {
//			bytes2[i] += (Math.abs(key+i)-2)%(1+Math.abs(1+i%7*2));
//		}
		return new String(bytes2);
	}
	
	public static String decrypt(String t, int key) {
		byte[] bytes = t.getBytes();
		byte[] bytes2 = t.getBytes();
//		for(int i =bytes.length-1; i>= 0; i--) {
//			bytes2[i] -= (Math.abs(key+i)-2)%(1+Math.abs(1+i%7*2));
//		}
		return new String(bytes2);
	}
	
}

//(i%key)+(i%5) ****
//((Math.abs(key-i)+1)%(1+Math.abs(3%((1+i%2))))) -*
//((Math.abs(key+i)-2)%(1+Math.abs(1+i%7*2))) *****