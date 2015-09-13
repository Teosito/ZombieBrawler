package main;

import characters.Characters;
import items.background.BackgroundItems;



public class InCamera {
	
	public static boolean renderCamera(main.Camera camera,Characters object){
		if(object.getX()>(camera.getX()-object.getImageWidth()) && camera.getX()<camera.getX()+Options.WIDTH){
			return true;
		}
		return false;
	}
	public static boolean renderCamera(main.Camera camera,BackgroundItems object){
		if(object.getX()>(camera.getX()-BackgroundItems.getScale()) && camera.getX()<camera.getX()+Options.WIDTH){
			return true;
		}
		return false;
	}
}
