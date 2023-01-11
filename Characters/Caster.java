package Characters;

import Attacks.*;
import java.awt.*;
/**
 * This class is called Caster, it is a subclass of RPGCharacter.
 * Casters are characters who cause damage by mainly casting spells.
 *
 * @author Aarnav Lakhanpal 
 */
public abstract class Caster extends RPGCharacter
{

 private final int maxMana;
 private int currentMana;
 /**
  * Caster constructor creates a caster type character with a name,intellect,maxHP,a starting position and maxMana.
  * It also calls the constructor of the parent class and sets the strenght to one.
  *
  * @param name
  * @param intellect
  * @param maxHP
  * @param position
  * @param maxMana
  */
 public Caster(String name,int intellect,int maxHP,Point position,int maxMana)
 {
  
    super(name,intellect,1,maxHP,position);
    
    this.maxMana=maxMana;
    this.currentMana=maxMana;
    

 }
 public int getCurrentMana(){return currentMana;}
 public int getMaxMana(){return maxMana;}

/**
 * This method will select an attack from the attacklist based on the index of the attack given
 * as the second parameter in this method.We will either heal or deal damage to the character.
 * We use a try catch block to make sure that the Index out of bounds exception is handled if the attack index is out of bounds
 * We will check with instanceof and if it is a healing spell then we will heal the character,
 * if it is any other spell attack then we will send the character's intellect as parameter
 * and any non spell attack will send 0 as the attack modifies using the
 * interactWithTarget method of the specified attack.
 *
 *
 * @param player
 * @param index
 * @return An integer value if the attack fails
 * -1 if the attack index is out of bounds.
 * -2 if the character is out of range.
 * -3 if we don't have enough mana.
 * If the attack is successful then we return targets currentHP.
 */
@Override

public int attack(RPGCharacter player,int index)
{
    try{
       
         Attack magicSpell=attackList.get(index);
         Double distance=getPosition().distance(player.getPosition());
   
            if(distance>magicSpell.getRange()){
                  return -2;
            }
            else if(magicSpell.getCost()>currentMana){
                  return -3;
            }

         this.currentMana=currentMana-magicSpell.getCost();

            if(magicSpell instanceof HealingSpell){
                  magicSpell.interactWithTarget(this,intellect);
            }
            else if(magicSpell instanceof Spell){
                  magicSpell.interactWithTarget(player,intellect);
            }
            else if(magicSpell instanceof MeleeAttack){
                  magicSpell.interactWithTarget(player, 0);
            }

   return player.getCurrentHP();
}
   catch(IndexOutOfBoundsException exception){
       return -1;
}

}
/**
 * This method appends the parents class toString method using the super keyword.
 * @return A string representing the caster with its currentHp and MaxHP.
 */
@Override
public String toString()
{
   return super.toString()+"\n Mana: "+getCurrentMana()+"/"+getMaxMana();
}














}
