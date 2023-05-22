package com.example.autoraidrpg.gameplay.skill.supportSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.SupportSkill;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.skill.SkillType;

import java.util.ArrayList;

public class SwordOfJudgement extends SupportSkill {

    private double pMagDmg;

    public SwordOfJudgement(Entity owner) {
        super("sword of judgement", R.drawable.skill_sword_of_judgement,
                SkillType.SUPPORT_ALLY_SINGLE, owner, new ArrayList<String>(), 12);
        
        this.pMagDmg = 25;

        // description
        this.description.add("gain " + (int) (pMagDmg * level) + "% magical holy damage to itself.");

        // long description
        this.description.add("strike enemies with holy energy, dealing significant damage while also having a chance to stun them. The skill requires the player to wield a sword and have a certain level of proficiency with it. When used, a bright aura surrounds the sword, indicating the skill's activation. It is particularly effective against undead or demonic enemies.");
    }

    @Override
    public void activate(Entity targetedEntity) {
        double ownerMagDmg = discount(this.owner.getMagDmg(), this.pMagDmg * level); // increment
        double actualDiscount = actualDiscount(this.owner.getMagDmg(), this.pMagDmg * level); // for display
        this.owner.setMagDmg(ownerMagDmg);

        // update observer
        battleSubject.getCurrentObserver()
            .addDescription(String.format("%s gained %d magical damage.", owner.getName(), (int) actualDiscount), owner.getRoleImage(), owner.getRoleImage());
        turn = cooldown;
    }
    
}
