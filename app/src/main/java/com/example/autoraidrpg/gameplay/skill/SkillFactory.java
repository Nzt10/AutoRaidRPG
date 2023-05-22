package com.example.autoraidrpg.gameplay.skill;

import com.example.autoraidrpg.gameplay.skill.activeSkills.Backstab;
import com.example.autoraidrpg.gameplay.skill.activeSkills.Cleave;
import com.example.autoraidrpg.gameplay.skill.activeSkills.Fear;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.skill.activeSkills.AreaOfDarkness;
import com.example.autoraidrpg.gameplay.skill.activeSkills.BasicAttack;
import com.example.autoraidrpg.gameplay.skill.activeSkills.BleedStrike;
import com.example.autoraidrpg.gameplay.skill.activeSkills.BloodExplosion;
import com.example.autoraidrpg.gameplay.skill.activeSkills.BloodImpale;
import com.example.autoraidrpg.gameplay.skill.activeSkills.BloodPoint;
import com.example.autoraidrpg.gameplay.skill.activeSkills.BloodRupture;
import com.example.autoraidrpg.gameplay.skill.activeSkills.BombExplosion;
import com.example.autoraidrpg.gameplay.skill.activeSkills.ChainLightning;
import com.example.autoraidrpg.gameplay.skill.activeSkills.DarkBinding;
import com.example.autoraidrpg.gameplay.skill.activeSkills.DarkDomination;
import com.example.autoraidrpg.gameplay.skill.activeSkills.DarkPurge;
import com.example.autoraidrpg.gameplay.skill.activeSkills.DeadRoot;
import com.example.autoraidrpg.gameplay.skill.activeSkills.ElementalPunch;
import com.example.autoraidrpg.gameplay.skill.activeSkills.FatalSlash;
import com.example.autoraidrpg.gameplay.skill.activeSkills.Fireball;
import com.example.autoraidrpg.gameplay.skill.activeSkills.FlashKunai;
import com.example.autoraidrpg.gameplay.skill.activeSkills.FlowPunch;
import com.example.autoraidrpg.gameplay.skill.activeSkills.FurySwipe;
import com.example.autoraidrpg.gameplay.skill.activeSkills.HammerIgnition;
import com.example.autoraidrpg.gameplay.skill.activeSkills.HammerSlam;
import com.example.autoraidrpg.gameplay.skill.activeSkills.HammerStomp;
import com.example.autoraidrpg.gameplay.skill.activeSkills.HeadShot;
import com.example.autoraidrpg.gameplay.skill.activeSkills.HeatBlast;
import com.example.autoraidrpg.gameplay.skill.activeSkills.HighSpeedPierce;
import com.example.autoraidrpg.gameplay.skill.activeSkills.HolySlash;
import com.example.autoraidrpg.gameplay.skill.activeSkills.ImperialThrust;
import com.example.autoraidrpg.gameplay.skill.activeSkills.MagicMissile;
import com.example.autoraidrpg.gameplay.skill.activeSkills.MassiveStrike;
import com.example.autoraidrpg.gameplay.skill.activeSkills.PalmDiagram;
import com.example.autoraidrpg.gameplay.skill.activeSkills.PoisonStrike;
import com.example.autoraidrpg.gameplay.skill.activeSkills.PowerPull;
import com.example.autoraidrpg.gameplay.skill.activeSkills.PowerStrike;
import com.example.autoraidrpg.gameplay.skill.activeSkills.QuickThrust;
import com.example.autoraidrpg.gameplay.skill.activeSkills.RagingSlash;
import com.example.autoraidrpg.gameplay.skill.activeSkills.SaberSlash;
import com.example.autoraidrpg.gameplay.skill.activeSkills.ShieldBash;
import com.example.autoraidrpg.gameplay.skill.activeSkills.SilverShot;
import com.example.autoraidrpg.gameplay.skill.activeSkills.SolarStrike;
import com.example.autoraidrpg.gameplay.skill.activeSkills.TheWhirlwind;
import com.example.autoraidrpg.gameplay.skill.activeSkills.ThroatCutting;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.AssassinMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.BerserkerMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.BlacksmithMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.ClericMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.CommanderMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.FierceWarrior;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.HunterMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.HunterStance;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.KnightArmor;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.KnightMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.MageMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.MarksmanMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.NecromancerMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.PaladinMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.SpearMaster;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.TheCommander;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.ThiefMastery;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.VampiricTouch;
import com.example.autoraidrpg.gameplay.skill.passiveSkills.WarriorMastery;
import com.example.autoraidrpg.gameplay.skill.supportSkills.DarkForce;
import com.example.autoraidrpg.gameplay.skill.supportSkills.Heal;
import com.example.autoraidrpg.gameplay.skill.supportSkills.LightArmorEnhancement;
import com.example.autoraidrpg.gameplay.skill.supportSkills.Seclusion;
import com.example.autoraidrpg.gameplay.skill.supportSkills.StealArmor;
import com.example.autoraidrpg.gameplay.skill.supportSkills.SwordOfJudgement;

public class SkillFactory {

    public static Skill makeSkill(Entity owner, String skillName) {
        switch(skillName) {
            // STAMP SKILLS
            case "basic-attack": return new BasicAttack(owner);

            // WARRIOR
            case "warrior-skill-1": return new WarriorMastery();
            case "warrior-skill-2": return new MassiveStrike(owner);
            case "warrior-skill-3": return new Cleave(owner);
            case "warrior-skill-4": return new FatalSlash(owner);

            // MARKSMAN
            case "marksman-skill-1": return new MarksmanMastery();
            case "marksman-skill-2": return new PowerStrike(owner);
            case "marksman-skill-3": return new SilverShot(owner);
            case "marksman-skill-4": return new HeadShot(owner);

            // MAGE
            case "mage-skill-1": return new MageMastery();
            case "mage-skill-2": return new MagicMissile(owner);
            case "mage-skill-3": return new Fireball(owner);
            case "mage-skill-4": return new ChainLightning(owner);

            // KNIGHT
            case "knight-skill-1": return new KnightMastery();
            case "knight-skill-2": return new ShieldBash(owner);
            case "knight-skill-3": return new PowerPull(owner);
            case "knight-skill-4": return new KnightArmor();

            // CLERIC
            case "cleric-skill-1": return new ClericMastery();
            case "cleric-skill-2": return new SolarStrike(owner);
            case "cleric-skill-3": return new Heal(owner);
            case "cleric-skill-4": return new HeatBlast(owner);

            // COMMANDER
            case "commander-skill-1": return new CommanderMastery();
            case "commander-skill-2": return new SaberSlash(owner);
            case "commander-skill-3": return new TheCommander();
            case "commander-skill-4": return new ImperialThrust(owner);

            // ASSASSIN
            case "assassin-skill-1": return new AssassinMastery();
            case "assassin-skill-2": return new Backstab(owner);
            case "assassin-skill-3": return new BleedStrike(owner);
            case "assassin-skill-4": return new FlashKunai(owner);

            // HUNTER
            case "hunter-skill-1": return new HunterMastery();
            case "hunter-skill-2": return new ThroatCutting(owner);
            case "hunter-skill-3": return new BombExplosion(owner);
            case "hunter-skill-4": return new HunterStance();

            // THIEF
            case "thief-skill-1": return new ThiefMastery();
            case "thief-skill-2": return new StealArmor(owner);
            case "thief-skill-3": return new BloodPoint(owner);
            case "thief-skill-4": return new PoisonStrike(owner);

            // BERSERKER
            case "berserker-skill-1": return new BerserkerMastery();
            case "berserker-skill-2": return new RagingSlash(owner);
            case "berserker-skill-3": return new FurySwipe(owner);
            case "berserker-skill-4": return new FierceWarrior();

            // BLACKSMITH
            case "blacksmith-skill-1": return new BlacksmithMastery();
            case "blacksmith-skill-2": return new HammerStomp(owner);
            case "blacksmith-skill-3": return new HammerIgnition(owner);
            case "blacksmith-skill-4": return new HammerSlam(owner);

            // SHAMAN
            case "shaman-skill-1": return new DarkPurge(owner);
            case "shaman-skill-2": return new DarkBinding(owner);
            case "shaman-skill-3": return new DarkForce(owner);
            case "shaman-skill-4": return new Fear(owner);

            // NECROMANCER
            case "necromancer-skill-1": return new NecromancerMastery();
            case "necromancer-skill-2": return new DeadRoot(owner);
            case "necromancer-skill-3": return new AreaOfDarkness(owner);
            case "necromancer-skill-4": return new DarkDomination(owner);

            // SPEARMAN
            case "spearman-skill-1": return new SpearMaster();
            case "spearman-skill-2": return new HighSpeedPierce(owner);
            case "spearman-skill-3": return new QuickThrust(owner);
            case "spearman-skill-4": return new TheWhirlwind(owner);

            // PALADIN
            case "paladin-skill-1": return new PaladinMastery();
            case "paladin-skill-2": return new LightArmorEnhancement(owner);
            case "paladin-skill-3": return new SwordOfJudgement(owner);
            case "paladin-skill-4": return new HolySlash(owner);

            // VAMPIRE
            case "vampire-skill-1": return new VampiricTouch();
            case "vampire-skill-2": return new BloodRupture(owner);
            case "vampire-skill-3": return new BloodExplosion(owner);
            case "vampire-skill-4": return new BloodImpale(owner);

            // MONK
            case "monk-skill-1": return new Seclusion(owner);
            case "monk-skill-2": return new FlowPunch(owner);
            case "monk-skill-3": return new PalmDiagram(owner);
            case "monk-skill-4": return new ElementalPunch(owner);
        }
        return null;
    }
    
}
