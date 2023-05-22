package com.example.autoraidrpg.gameplay.skill.activeSkills;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.gameplay.buff.BuffFactory;
import com.example.autoraidrpg.gameplay.skill.ActiveSkill;
import com.example.autoraidrpg.gameplay.skill.SkillType;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;

import java.util.ArrayList;

public class HolySlash extends ActiveSkill {

    private boolean hasArmor = false;

    public HolySlash(Entity entity) {
        super("holy slash", R.drawable.skill_holy_slash,
                SkillType.SINGLE, entity, AttackType.PHYSICAL, new ArrayList<String>(), 3);

        // attack damage increases by armor once
        this.extra = e -> {
            if(!hasArmor) this.pPhyDmg += e.getPhyDef() * (0.105 * level);
            hasArmor = true;
        };
        
        // base
        this.pMagDmg += 35;

        // incremental
        this.apMagDmg += 15;

        // description
        this.description.add("deals " + (int) (pMagDmg + (level * apMagDmg)) + "% physical damage + armor.");

        // long description
        this.description.add("inflicts holy damage to enemies. The player channels holy energy into their weapon and unleashes a devastating slash that damages all enemies in a cone-shaped area in front of them. The attack is especially effective against undead or demonic enemies, and can also dispel evil magic or curses. However, it requires a high level of faith and skill to perform.");
        
        // add ignite buffs
        buffs.add(BuffFactory.makeBuff("ignite", 15 + (level * 3), entity, 1 * level));
    }
    
}
