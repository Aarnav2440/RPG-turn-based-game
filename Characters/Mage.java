package Characters;

import java.awt.Point;
import Attacks.DamageSpell;
import Attacks.MeleeAttack;

/**
 * This class is called Mage, it is a subclass of Caster.It is a concrete class.
 * Mages are characters who cause damage by mainly casting spells and melee attacks but can't
 * cast a healing spell or resurrection.
 *
 * @author Aarnav Lakhanpal 
 */

public class Mage extends Caster
{

    /**
     * Mage constructor creates a mage type character with a name,intellect,maxHP,a starting position and maxMana.
     * It also adds the list of attacks which are used and can be cast by this type of Caster.
     *
     * @param name
     * @param intellect
     * @param maxHP
     * @param position
     * @param maxMana
     */
    public Mage(String name,int intellect,int maxHP,Point position,int maxMana)
    {
        super(name,intellect,maxHP,position,maxMana);
 
        MeleeAttack attack1=new MeleeAttack(0,"Staff",3,3);
        DamageSpell attack2=new DamageSpell(20,"Fire Ball",10,7);
        DamageSpell attack3=new DamageSpell(15,"Frost Ball",7, 15);
        DamageSpell attack4=new DamageSpell(30,"Lightning",15,20);
        
        attackList.add(attack1);
        attackList.add(attack2);
        attackList.add(attack3);
        attackList.add(attack4);

    }


}





















