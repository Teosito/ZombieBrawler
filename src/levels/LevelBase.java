package levels;


import items.background.BackgroundItems;
import items.background.Building;

import java.util.ArrayList;
import java.util.Collections;

import main.Camera;
import main.InCamera;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import weapons.Bullet;
import characters.Characters;
import characters.enemies.EnemyBase;
import characters.mainCharacter.MainCharacter;

public abstract class LevelBase extends BasicGameState{
	protected static MainCharacter mainCharacter;
	protected ArrayList<EnemyBase>enemies = new ArrayList<EnemyBase>();
	protected ArrayList<BackgroundItems>buildings = new ArrayList<BackgroundItems>();
	protected ArrayList<Characters>renderCharacters = new ArrayList<Characters>();
	protected Camera camera;
	protected int ID;
	protected int numberOfBuildings;
	protected static ArrayList<Integer> rememberX = new ArrayList<Integer>();
		
	public void bulletHittable(){
		for(int i = 0; i<enemies.size();i++){
			Bullet.addHittable(enemies.get(i));
		}
	}
	public void enemyFollow(Characters character){
		EnemyBase.addCharactersFollowed(character);
	}
	public void getCharactersRender(){
		renderCharacters.addAll(enemies);
		renderCharacters.add(mainCharacter);
	}
	public void createBuildings(int numberOfBuildings, StateBasedGame arg1, int ID)throws SlickException{
		for(int i = 0; i<numberOfBuildings;i++){
			int id = ID+(i+1);
			buildings.add(new Building(Building.getScale()*i, id));
			arg1.addState(new InBuilding(id));
			System.out.println(id);		
		}
	}
	public void rearrangeRenderArray(){
		for(int i=0;i<renderCharacters.size();i++){
			for(int l=1;l<renderCharacters.size();l++){
				if(renderCharacters.get(i).getY()>renderCharacters.get(l).getY()){
					Collections.swap(renderCharacters, l, i);
				}
			}
		}
	}	
	public void renderAll(GameContainer arg0, StateBasedGame arg1, Graphics arg2)throws SlickException{
		for(int i = 0; i<buildings.size();i++){
			if(InCamera.renderCamera(camera, buildings.get(i))){
				buildings.get(i).render(arg0, arg1, arg2);
			}
		}
		for(int i = 0; i<MainCharacter.getWeapon().getBullets().size();i++){
			MainCharacter.getWeapon().getBullets().get(i).getState().render(arg0, arg1, arg2);
		}
		for(int i = 0; i<enemies.size();i++){
			for(int l = 0; l<enemies.get(i).getWeapon().getEnemyBullets().size();l++){
				enemies.get(i).getWeapon().getEnemyBullets().get(l).getState().render(arg0, arg1, arg2);
			}
		}
		for(int i = 0; i<renderCharacters.size();i++){
			if(InCamera.renderCamera(camera, renderCharacters.get(i))){
				renderCharacters.get(i).getState().render(arg0, arg1, arg2);
			}
		}
	}	
	public void enterLevel(Characters character, BackgroundItems building, GameContainer arg0, StateBasedGame arg1)throws SlickException{
			if(character.getHitbox().intersects(building.getHitbox())){
				if(arg0.getInput().isKeyDown(Input.KEY_C)){
					if(arg0.getInput().isKeyPressed(Input.KEY_C)){
					arg1.enterState(building.getID());
					rememberX.add(mainCharacter.getX());
					mainCharacter.setX(building.getDoorX());
				}
			}
		}
	}
	public void exitLevel(GameContainer arg0, StateBasedGame arg1){
		if(arg0.getInput().isKeyDown(Input.KEY_C)){
			if(arg0.getInput().isKeyPressed(Input.KEY_C)){
				int id = ID/1000;
				id=id*1000;
				arg1.enterState(id);
				mainCharacter.setX(rememberX.get(rememberX.size()-1));
				rememberX.remove(rememberX.size()-1);
			}
		}
	}
	public void updateEnemy(GameContainer arg0, StateBasedGame arg1, int arg2)throws SlickException{
		for(int i = 0; i< enemies.size();i++){
			enemies.get(i).getState().update(arg0, arg1, arg2);
			for(int l = 0; l<enemies.get(i).getWeapon().getEnemyBullets().size();l++){
				enemies.get(i).getWeapon().getEnemyBullets().get(l).getState().update(arg0, arg1, arg2);
				if(enemies.get(i).getWeapon().getEnemyBullets().get(l).isFinish()){
					enemies.get(i).getWeapon().getEnemyBullets().remove(l);
				}
			}
			if(enemies.get(i).getHitpoints()<=0){
				for(int l = 0; l<MainCharacter.getWeapon().getBullets().size();l++){
					for(int k = 0; k<Bullet.getHITTABLE().size();k++){
						if(Bullet.getHITTABLE().get(k).equals(enemies.get(i))){
							Bullet.getHITTABLE().remove(k);
							enemies.get(i).setY(-1000);
						}
					}
				}
			}
		}
	}
	public void updateBullets(GameContainer arg0, StateBasedGame arg1, int arg2)throws SlickException{
		if(Bullet.getHITTABLE().isEmpty()==false){
			for(int i = 0; i<MainCharacter.getWeapon().getBullets().size();i++){
				for(int l = 0;l<enemies.size();l++){
					if(MainCharacter.getWeapon().getBullets().get(i).getHitbox().intersects(enemies.get(l).getHitbox())){
						if(MainCharacter.getWeapon().getBullets().get(i).isDestructible()){
							enemies.get(l).setHitpoints(enemies.get(l).getHitpoints()-MainCharacter.getWeapon().getBullets().get(i).getDamage());
							MainCharacter.getWeapon().getBullets().remove(i);
						}
					}
				}
			}
		}
	}
	public void updateMainCharacter(GameContainer arg0, StateBasedGame arg1, int arg2)throws SlickException{
		mainCharacter.getState().update(arg0, arg1, arg2);
		if(mainCharacter.isShoot()){
			MainCharacter.getWeapon().shoot(mainCharacter.getX()+mainCharacter.getImage().getWidth()/2,
					mainCharacter.getY()+mainCharacter.getImage().getHeight()/2, mainCharacter.isDirection());
		}
		for(int i = 0; i<MainCharacter.getWeapon().getBullets().size();i++){
			MainCharacter.getWeapon().getBullets().get(i).getState().update(arg0, arg1, arg2);
			if(MainCharacter.getWeapon().getBullets().get(i).isFinish()){
				MainCharacter.getWeapon().getBullets().remove(i);
			}
		}
	}
}
