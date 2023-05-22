package com.example.autoraidrpg.gameplay.skill.supportSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.skill.SupportSkill;
import com.example.autoraidrpg.gameplay.entity.Entity;

import java.util.ArrayList;

public class Heal extends SupportSkill {

    private double pMagDmg, apMagDmg;

    public Heal(Entity owner) {
        super("heal", R.drawable.skill_heal,
                SkillType.SUPPORT_ALLY_SINGLE, owner, new ArrayList<String>(), 5);
        
        this.pMagDmg = 115; // based
        this.apMagDmg = 50; // incremental

        // description
        this.description.add("heal a single ally " + (int) (pMagDmg + (level * apMagDmg)) + "% magical damage.");

        // long description
        this.description.add("heal is a fundamental skill for characters who wish to support their allies in combat or in recovery. The skill allows the character to restore health to themselves or their allies, providing crucial support in battles and other dangerous situations. The skill requires the character to have a deep understanding of medicine and a steady hand, as well as access to appropriate medical supplies. Heal is a versatile skill that can be used to recover from injuries, cure diseases and poisons, and even revive fallen allies, making it a valuable skill for any character seeking to provide support in combat and beyond.");
    }

    @Override
    public void activate(Entity targetedEntity) {
        double healAmount = discount(owner.getMagDmg(), (level * apMagDmg) + pMagDmg);
        double healedHp = targetedEntity.getHp() + healAmount;

        targetedEntity.supportHp(healedHp);

        // update observer
        battleSubject.getCurrentObserver()
            .addDescription(String.format("%s healed %s by %d magical healing.", owner.getName(), targetedEntity.getName(), (int) healAmount), owner.getRoleImage(), targetedEntity.getRoleImage());
        turn = cooldown;
    }
    
}
