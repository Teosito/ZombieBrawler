package characters.enemies.states;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;

import characters.Characters;
import characters.enemies.EnemyBase;

public abstract class EnemyBaseState extends BasicGameState{
	
	public boolean follow(EnemyBase enemy, Characters character){
		
		if(enemy.getX()<character.getX()){
			if(character.getX()-enemy.getX()>enemy.getVisionRange()){
				return false;
			}
		}
		if(enemy.getX()>character.getX()){
			if(enemy.getX()-character.getX()>enemy.getVisionRange()){
				return false;
			}
		}
		if(enemy.getY()>character.getY()){
			enemy.setSpeedY(enemy.getSpeed()*-1);
		}
		if(enemy.getY()<character.getY()){
			enemy.setSpeedY(enemy.getSpeed());
		}
		if(enemy.getY()==character.getY()){
			enemy.setSpeedY(0);
		}
		if(enemy.getVisionRange()>=(enemy.getX()-character.getX())&&(enemy.getX()-character.getX()-character.getHitbox().getWidth()>0)){
				enemy.setSpeedX(enemy.getSpeed()*-1);
			}
		if(enemy.getVisionRange()>=(character.getX()-enemy.getX())&&(character.getX()-enemy.getX()>0)){
				enemy.setSpeedX(enemy.getSpeed());
		}
		return true;
	}
	
	public boolean attack(EnemyBase enemy, Characters character)throws SlickException{
		if(enemy.getY()==character.getY()){
			if(enemy.getX()-(character.getX()+character.getHitbox().getWidth())<=enemy.getWeapon().getAttackRange()&&enemy.getX()-character.getX()>0){
					enemy.setState(new EnemyAttackState(enemy));
				return true;
			}
			if(character.getX()-enemy.getX()<=enemy.getWeapon().getAttackRange()&&(character.getX()-enemy.getX()>0)){
				enemy.setState(new EnemyAttackState(enemy));
				return true;
			}
		}
		return false;
	}
	public Characters isClose(EnemyBase enemy, Characters character)throws SlickException{
		for(int i = 0; i < enemy.getCharactersFollowed().size();i++){
			if(enemy.getX()-(character.getX()+character.getHitbox().getWidth())<=enemy.getWeapon().getAttackRange()&&enemy.getX()-character.getX()>0||
					character.getX()-enemy.getX()<=enemy.getWeapon().getAttackRange()&&(character.getX()-enemy.getX()>0)){
			return enemy.getCharactersFollowed().get(i);
			}
		}
		return null;
		
	}
	
}
