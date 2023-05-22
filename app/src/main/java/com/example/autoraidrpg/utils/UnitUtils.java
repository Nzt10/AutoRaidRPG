package com.example.autoraidrpg.utils;

import com.example.autoraidrpg.StatsView;
import com.example.autoraidrpg.adapter.SkillInfoAdapter;
import com.example.autoraidrpg.gameplay.entity.Entity;
import com.example.autoraidrpg.gameplay.skill.skillManager.SkillManager;
import com.example.autoraidrpg.model.RoleCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UnitUtils {

    public final static double[] expCostsPerLevel = {
            // level 1 - 10
                10,     18,     30,     45,     50,     55,     65,     75,     77,     250,
            // level 11 - 20
                80,     82,     90,     95,    100,    104,    108,    115,    130,     500,
            // level 21 - 30
               134,    145,    150,    155,    160,    170,    190,    220,    280,    1000,
            // level 31 - 40
               300,    320,    340,    360,    380,    420,    460,    500,    550,    1500,
            // level 41 - 50
               600,    700,    800,    900,   1000,   1100,   1200,   1300,   1400,  10_000,
            // level 51 - 60
              1500,   1750,   2000,   2250,   2500,   2750,   3000,   3500,   4000,  25_000,
            // level 61 - 70
              4500,   5000,   5500,   6000,   6500,   7500,   8500,   9500, 10_500,  50_000,
            // level 71 - 80
            11_500, 12_500, 13_500, 15_000, 16_500, 18_000, 19_500, 21_000, 22_500, 100_000,
            // level 81 - 90
            24_000, 26_000, 28_000, 30_000, 33_000, 36_000, 39_000, 42_000, 45_000, 150_000,
            // level 91 - 100
            50_000, 55_000, 60_000, 65_000, 70_000, 75_000, 80_000, 85_000, 90_000, 250_000
    };

    // set and get skills
    public static List<SkillInfoAdapter> setAndGetSkills(SkillManager skillManager) {
        // skill setup
        List<SkillInfoAdapter> skillInfo = new ArrayList<>();

        skillManager.getSkills().stream().forEach(skill -> skillInfo.add(new SkillInfoAdapter(
                skill.getName(), skill.getItemImage(), skill.getLevel(), skill.getDescription()
        )));

        return skillInfo;
    }

    public static void setStats(Entity entity, StatsView statsView) {

        // number stats
        statsView.getHealth().setText(String.valueOf((int) entity.getHp()));
        statsView.getPhysicalDamage().setText(String.valueOf((int) entity.getPhyDmg()));
        statsView.getMagicalDamage().setText(String.valueOf((int) entity.getMagDmg()));
        statsView.getPhysicalDefense().setText(String.valueOf((int) entity.getPhyDef()));
        statsView.getMagicalDefense().setText(String.valueOf((int) entity.getMagDef()));
        statsView.getSpeed().setText(String.valueOf((int) entity.getSpd()));

        // percentage stats
        statsView.getCriticalChance().setText(String.valueOf((int) entity.getCritChance()) + "%");
        statsView.getCriticalDamage().setText(String.valueOf((int) entity.getCritDmg()) + "%");
        statsView.getDodge().setText(String.valueOf((int) entity.getDodge()) + "%");
        statsView.getArmorPenetration().setText(String.valueOf((int) entity.getArmPen()) + "%");
        statsView.getMagicPenetration().setText(String.valueOf((int) entity.getMagPen()) + "%");
        statsView.getAccuracy().setText(String.valueOf((int) entity.getAcc()) + "%");

    }

    public static void setSingleStats(Entity entity, RoleCollection roleCollection) {
        entity.setRoleCollectionID(roleCollection.getId());
        entity.setRoleID(roleCollection.getRoleID());
        entity.setLevel(roleCollection.getLevel());
        entity.setRating(roleCollection.getRating());

        // set skills
        entity.getSkillManager().getSkills().get(0).setLevel(roleCollection.getSkillA()); // SKILL A
        entity.getSkillManager().getSkills().get(1).setLevel(roleCollection.getSkillB()); // SKILL B
        entity.getSkillManager().getSkills().get(2).setLevel(roleCollection.getSkillC()); // SKILL C
        entity.getSkillManager().getSkills().get(3).setLevel(roleCollection.getSkillD()); // SKILL D
        entity.getSkillManager().getSkills().get(4).setLevel(roleCollection.getSkillE()); // SKILL E
    }

    public static void setStats(List<Entity> entities, List<RoleCollection> roleCollections) {
        AtomicInteger index = new AtomicInteger(0);

        entities.forEach(unit -> {
            RoleCollection roleCollection = roleCollections.get(index.getAndIncrement());
            setSingleStats(unit, roleCollection);
        });
    }

}
