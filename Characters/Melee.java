package Characters;

import java.awt.Point;
import Attacks.*;
/**
 * This class is called Melee, it is a subclass of RPGCharacter.
 * Melee character is a character who causes damage by physical attack instead of casting spells.
 * @author Aarnav Lakhanpal 
 */
public abstract class Melee extends RPGCharacter
{

private final int maxEnergy;
private int currentEnergy;

/**
 * Melee constructor creates a melee type RPGCharacter with a name,strehght,maxHP,a starting position and maxEnergy.
 * Also calls the constructor of the parent class and sets the intellect to one.
 *
 */
  public Melee(String name,int strenght,int maxHP,Point position,int maxEnergy)
  {

      super(name,1,strenght,maxHP,position);
      this.maxEnergy=maxEnergy;
      this.currentEnergy=maxEnergy;

  }
  public int getMaxEnergy(){return maxEnergy;}
  public int getCurrentEnergy(){return currentEnergy;}

/**
 * This method will select an attack from the attackList based on the index of the attack given
 * as the second parameter in this method.
 * We use a try catch block to make sure that the Index out of bounds exception is handled if the attack index is out of bounds.
 * We will deduct the cost of the physical attack from the currentEnergy and update the currentEnergy.
 * We will send the character's strenght as parameter in the interactWithTarget method of the specified attack.
 *
 * @param player
 * @param index
 * @return An integer value if the attack fails
 *-1 if the attack index is out of bounds.
 *-2 if the target is out of range.
 *-3 if we don't have enough mana.
 * If the attack is successful then we return Character's currentHP.
 */

@Override
  public int attack(RPGCharacter player, int index)
  {
     
    try{

        Attack physicalAttack=attackList.get(index);
        Double distance=getPosition().distance(player.getPosition());
    
      
          if(distance>physicalAttack.getRange()){
                return -2;
          }
          else if(physicalAttack.getCost()>=this.currentEnergy){
                return -3;
          }

        currentEnergy=currentEnergy-physicalAttack.getCost();
        physicalAttack.interactWithTarget(player,strenght);

      return player.getCurrentHP();
}

    catch(IndexOutOfBoundsException exception){ 
        return -1;
}


}
/**
 * This method appends to the toString method of the parents class using the super keyword.
 * @return A string representing the melee character with its currentEnergy and MaxEnergy.
 */
@Override
public String toString()
{
  return super.toString()+"\n Energy "+getCurrentEnergy()+"/"+getMaxEnergy();
}














}
