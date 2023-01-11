package Characters;

import java.awt.Point;
import Attacks.*;
/**
 * This class is the child class of Caster class.It is a concrete class.
 * Priests are characters who deal damage by spells and melee attacks but most
 * importantly is the only type of character which can cast Resurrection.
 *
 * @author Aarnav Lakhanpal 
 */

public class Priest extends Caster 
{
 
/**
 * Priest constructor creates a priest type character with a name,intellect,maxHP,a starting position and maxMana.
 * It also adds the list of attacks which are used and can be cast by this type of Caster.
 *
 * @param name
 * @param intellect
 * @param maxHP
 * @param position
 * @param maxMana
 */
    public Priest(String name,int intellect,int maxHP,Point position,int maxMana)
    {
        super(name,intellect,maxHP,position,maxMana);

        MeleeAttack attack1=new MeleeAttack(0,"Wand", 3, 3);
        DamageSpell attack2=new DamageSpell(10,"Smite",10,7);
        HealingSpell attack3=new HealingSpell(20,"Flash Heal",15,15);
        Resurrection attack4=new Resurrection();

        attackList.add(attack1);
        attackList.add(attack2);
        attackList.add(attack3);
        attackList.add(attack4);

    }



}
