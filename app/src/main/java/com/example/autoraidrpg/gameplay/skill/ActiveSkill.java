package com.example.autoraidrpg.gameplay.skill;

import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.formation.battleFormationTypes.AttackType;
import com.example.autoraidrpg.gameplay.global.BattleInformationObserver;
import com.example.autoraidrpg.gameplay.inspector.ChanceInspector;
import com.example.autoraidrpg.gameplay.subject.BattleSubject;

import java.util.List;

public abstract class ActiveSkill extends Skill implements Active {

    protected Entity owner;
    protected AttackType attackType;
    protected double pPhyDmg, pMagDmg, apPhyDmg, apMagDmg;
    private ChanceInspector chanceInspector;

    // observers
    protected BattleSubject battleSubject;

    public ActiveSkill(String name, int itemImage, SkillType skillType, Entity owner, AttackType attackType, List<String> description, int cooldown) {
        super(name, itemImage, skillType, description);
        this.owner = owner;
        this.attackType = attackType;
        this.cooldown = cooldown;
        chanceInspector = new ChanceInspector();

        // based and incremental stats
        pPhyDmg = pMagDmg = apPhyDmg = apMagDmg = 0;
        
        // set global observer
        battleSubject = BattleInformationObserver.getInstance();
    }

    @Override
    public void activate(Entity targetedEntity) {
        attack(targetedEntity);
        turn = cooldown;
    }

    @Override
    public void activateToAll(List<Entity> targetedEntities) {
        targetedEntities.stream().forEach(e -> { if(e != null) activate(e); });
    }

    // attack hostile
    private void attack(Entity targetedEntity) {
        // actual damage
        double phyDmg = discount(owner.getPhyDmg(), (level * apPhyDmg) + pPhyDmg);
        double magDmg = discount(owner.getMagDmg(), (level * apMagDmg) + pMagDmg);

        if(chanceInspector.evaded(targetedEntity.getDodge())) {
            // update observer
            battleSubject.getCurrentObserver()
                .addDescription(String.format("%s evaded %s's ability skill.", targetedEntity.getName(), owner.getName()), targetedEntity.getRoleImage(), owner.getRoleImage());
            return;
        }

        buffs.stream().forEach(buff -> {
            targetedEntity.applyBuff(buff);
              
            // update observer
            battleSubject.getCurrentObserver()
                .addDescription(String.format("%s applied %s buff to %s.", owner.getName(), buff.getName(), targetedEntity.getName()), targetedEntity.getRoleImage(), owner.getRoleImage());
        });

        switch(attackType) {
            case PHYSICAL: physicalAttack(targetedEntity, phyDmg); break;
            case MAGICAL: magicalAttack(targetedEntity, magDmg); break;
            case BOTH:
                physicalAttack(targetedEntity, phyDmg);
                magicalAttack(targetedEntity, magDmg);
                break;
            default:
                break;
        }

        // set extra moves to the owner
        if(this.extra != null) this.extra.accept(owner);
    }

    // physical content
    protected void physicalAttack(Entity target, double damage) {
        double aCritDmg = chanceInspector.setDmg(damage).crit(owner.getCritChance(), owner.getCritDmg());
        double aDamage = aCritDmg - target.getPhyDef();
        double currentHealth = target.getHp() - aDamage;

        if(aDamage > 0) {
            // update observer
            battleSubject.getCurrentObserver()
                .addDescription(String.format("%s recieved %d physical damage.", target.getName(), (int) aDamage), target.getRoleImage(), owner.getRoleImage());
        } else {
            // update observer
            battleSubject.getCurrentObserver()
                .addDescription(String.format("%s's physical defense is to high and did not recieve any physical damage.", target.getName()), target.getRoleImage(), target.getRoleImage());
            return;
        }

        target.inflictHp(currentHealth);
    }

    // magical content
    protected void magicalAttack(Entity target, double damage) {
        double aCritDmg = chanceInspector.setDmg(damage).crit(owner.getCritChance(), owner.getCritDmg());
        double aDamage = aCritDmg - target.getMagDef();
        double currentHealth = target.getHp() - aDamage;

        if(aDamage > 0) {
            // update observer
            battleSubject.getCurrentObserver()
                .addDescription(String.format("%s recieved %d magical damage.", target.getName(), (int) aDamage), target.getRoleImage(), owner.getRoleImage());
        } else {
            // update observer
            battleSubject.getCurrentObserver()
                .addDescription(String.format("%s's magical defense is to high and did not recieve any magical damage.", target.getName()), target.getRoleImage(), target.getRoleImage());
            return;
        }
        
        target.inflictHp(currentHealth);
    }

    public AttackType getAttackType() { return attackType; }
    
}
