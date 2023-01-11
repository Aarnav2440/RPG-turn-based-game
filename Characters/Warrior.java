package Characters;
import java.awt.Point;
import Attacks.MeleeAttack;
/**
 * This class is the child class of Melee class.It is a concrete class.
 * Warriors are characters who deal damage by melee attacks only.
 *
 *@author Aarnav Lakhanpal 
 */
public class Warrior extends Melee 
{
    /**
     * Warrior constructor creates a warrior type melee type character with a name,strenght,maxHP,a starting position and maxEnergy.
     * It also adds the list of attacks which are used and can be used to deal damage by the warrior.
     *
     * @param name
     * @param strenght
     * @param maxHP
     * @param position
     * @param maxEnergy
     */
    public Warrior(String name,int strenght,int maxHP,Point position,int maxEnergy)
    {
        super(name,strenght,maxHP,position,maxEnergy);

        MeleeAttack attack1=new MeleeAttack(0,"Punch",5,3);
        MeleeAttack attack2=new MeleeAttack(3,"Slam",5,3);
        MeleeAttack attack3=new MeleeAttack(20,"Charge",30,15);

        attackList.add(attack1);
        attackList.add(attack2);
        attackList.add(attack3);
    }

  
}
  

 
  






 
 




