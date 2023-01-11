package Characters;

import java.awt.Point;
import java.util.ArrayList;
import Attacks.*;
/**
 * This class is the RPGCharacter class,it creates a RPGCharacter for the player to use and has its own methods associated with it.
 * It implements the Comparable interface also it is the parent class to Caster and Melee classes respectively.It implements the Comparable interface.
 *
 * @author Aarnav Lakhanpal 
 */


public abstract class RPGCharacter implements Comparable<RPGCharacter>
{
    private String name;
    private final int maxHP;
    private Point position;

    protected int currentHP;
    protected int intellect;
    protected int strenght;
    protected ArrayList<Attack> attackList;

    /**
     * RPGCharacter constructor creates the base game character which gives a character its
     * name,intellect,strenght,maximum health points and a starting position.
     *
     * @param name
     * @param intellect
     * @param strenght
     * @param maxHP
     * @param position
     */
 public RPGCharacter(String name,int intellect,int strenght,int maxHP,Point position)
 {

    this.name=name;
    this.intellect=intellect;
    this.strenght=strenght;
    this.maxHP=maxHP;
    this.position=position;

    attackList=new ArrayList<>();
    currentHP=maxHP;
}

public int getCurrentHP(){return currentHP;}
public Point getPosition(){return position;}
public int getMaxHP(){return maxHP;}
public String getName(){return name;}

/**
 * This method will move the character in the game and how they much they will move in x and y direction
 * is decided by the first and second parameter.
 *
 * @param dx
 * @param dy
 * @return returns nothing.
 */
public void move(int dx,int dy)
{
  getPosition().translate(dx, dy);
}

/**
 * This method will deal damage to the character by reducing its current health points.
 * After the damage is done to the player and the currentHP of that player is less than or equal to zero.
 * Then we set the value of currentHP to zero and return false indicating that the character is dead  or else just deduct the
 * currentHP of the character by subtracting damage parameter from the currentHP and return true indicating that the character is alive.
 *
 * @param damage
 * @return A boolean value true if the character is alive after receiving the damage or false if they are dead.
 */
public boolean takeDamage(int damage)
{
    currentHP=currentHP-damage;

      if(currentHP<=0){
          currentHP=0;
          return false;
        }
      else{
          return true;
        }
  
}

/**
 * This method will heal the character by adding the parameter variable to the currentHP of the character.
 * If The lifeForce is greater than or equal to the character's maxHP then we set its currentHP to maxHP and return true
 * or false and then we just heal the character.
 *
 * @param lifeForce
 * @return A boolean value true if the character is fully healed and its currentHP is set equal to its maxHP
 * or false otherwise and just heals the character.
 */
public boolean heal(int lifeForce)
{     
      if(lifeForce>=maxHP){
            currentHP=maxHP;
            return true;
          }
      else{ 
            currentHP=getCurrentHP()+lifeForce;
            return false;
          }
  }

/**
 * This method is an abstract method which is to be overridden by the child classes of RPGCharacter.
 * @param player
 * @param index
 * @return An integer value.
 */
public abstract int attack(RPGCharacter player,int index);

/**
 * This method will compare the two characters on the basis of their currentHP's and order them from
 * highest currentHP to the lowest.
 *
 * @param player
 * @return An integer value which will sort the characters in a descending order.
 */
public int compareTo(RPGCharacter player)
{ 
  
    if(player.getCurrentHP()==this.getCurrentHP()){
        return 0;
    }
    else if(player.getCurrentHP()>this.getCurrentHP()){
        return 1;
    }
    else{
        return -1;
    }
}
/**
 * This method will return each character's attacks on a new line with the attacks index and specific
 * attack string's representation as done below.
 *
 * @return A string value with the index of the character's attack and the attack string in the specified manner below.
 */
public String getAttacks()
{
  String attack="";
  
  for(int i=0;i<attackList.size();i++){
   
      attack+=i+" - "+attackList.get(i)+"\n";
      

  }
  
  return attack;
}
/**
 *This method will return a string representing the character with their name ,their type and the currentHP and maxHP.
 *
 * @return A string value with the character's name,the characters type,currentHP and maxHP.
 */
public String toString()
{
  return name+" ("+name.getClass().getSimpleName()+") - "+getCurrentHP()+"/"+getMaxHP();
  
}














}
