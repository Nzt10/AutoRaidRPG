package com.example.autoraidrpg.gameplay.skill.supportSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.skill.SupportSkill;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class Seclusion extends SupportSkill {

    private double pStats;

    public Seclusion(Entity owner) {
        super("seclusion", R.drawable.skill_seclusion,
                SkillType.SUPPORT_ALLY_SINGLE, owner, new ArrayList<String>(), 15);
        
        this.pStats = 3;

        // description
        this.description.add("gain " + (int) (pStats * level) + "% all stats to itself.");

        // long description
        this.description.add("blend into their surroundings, becoming nearly invisible to the naked eye. This makes it ideal for reconnaissance, ambushes, and escapes. While in seclusion, the user can move quietly and undetected, making it difficult for enemies to detect their presence. However, prolonged use of the skill can drain the user's stamina, and it may be ineffective against enemies with heightened senses or magical abilities.");
    }

    @Override
    public void activate(Entity targetedEntity) {
        // all stats increment
        double ownerHp = discount(this.owner.getHp(), this.pStats * level);
        double ownerPhyDmg = discount(this.owner.getPhyDmg(), this.pStats * level);
        double ownerMagDmg = discount(this.owner.getMagDmg(), this.pStats * level);
        double ownerPhyDef = discount(this.owner.getPhyDef(), this.pStats * level);
        double ownerMagDef = discount(this.owner.getMagDef(), this.pStats * level);
        double ownerSpd = discount(this.owner.getSpd(), this.pStats * level);

        // all stats increase
        double ownerDiscountHp = actualDiscount(this.owner.getHp(), this.pStats * level);
        double ownerDiscountPhyDmg = actualDiscount(this.owner.getPhyDmg(), this.pStats * level);
        double ownerDiscountMagDmg = actualDiscount(this.owner.getMagDmg(), this.pStats * level);
        double ownerDiscountPhyDef = actualDiscount(this.owner.getPhyDef(), this.pStats * level);
        double ownerDiscountMagDef = actualDiscount(this.owner.getMagDef(), this.pStats * level);
        double ownerDiscountSpd = actualDiscount(this.owner.getSpd(), this.pStats * level);

        // set up stats
        this.owner.setHp(ownerHp);
        this.owner.setPhyDmg(ownerPhyDmg);
        this.owner.setMagDmg(ownerMagDmg);
        this.owner.setPhyDef(ownerPhyDef);
        this.owner.setMagDef(ownerMagDef);
        this.owner.setSpd(ownerSpd);

        // update observer
        battleSubject.getCurrentObserver().addDescription(String.format("%s gained %d health.", owner.getName(), (int) ownerDiscountHp), owner.getRoleImage(), owner.getRoleImage());
        battleSubject.getCurrentObserver().addDescription(String.format("%s gained %d physical damage.", owner.getName(), (int) ownerDiscountPhyDmg), owner.getRoleImage(), owner.getRoleImage());
        battleSubject.getCurrentObserver().addDescription(String.format("%s gained %d magical damage.", owner.getName(), (int) ownerDiscountMagDmg), owner.getRoleImage(), owner.getRoleImage());
        battleSubject.getCurrentObserver().addDescription(String.format("%s gained %d physical defense.", owner.getName(), (int) ownerDiscountPhyDef), owner.getRoleImage(), owner.getRoleImage());
        battleSubject.getCurrentObserver().addDescription(String.format("%s gained %d magical defense.", owner.getName(), (int) ownerDiscountMagDef), owner.getRoleImage(), owner.getRoleImage());
        battleSubject.getCurrentObserver().addDescription(String.format("%s gained %d speed.", owner.getName(), (int) ownerDiscountSpd), owner.getRoleImage(), owner.getRoleImage());
        turn = cooldown;
    }
    
}
