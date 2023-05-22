package com.example.autoraidrpg.gameplay.bag;

import com.example.autoraidrpg.gameplay.bag.items.AssassinFinestBlade;
import com.example.autoraidrpg.gameplay.bag.items.BerserkAxe;
import com.example.autoraidrpg.gameplay.bag.items.BlueGinsengRoot;
import com.example.autoraidrpg.gameplay.bag.items.BookOfTheArcangeMage;
import com.example.autoraidrpg.gameplay.bag.items.EnchantedHunterTrap;
import com.example.autoraidrpg.gameplay.bag.items.FrozenHammerOfTheGods;
import com.example.autoraidrpg.gameplay.bag.items.HorrorScythe;
import com.example.autoraidrpg.gameplay.bag.items.ImmortalHunterAxe;
import com.example.autoraidrpg.gameplay.bag.items.LumenVitalityPowerPotion;
import com.example.autoraidrpg.gameplay.bag.items.MarksmanSanctionGun;
import com.example.autoraidrpg.gameplay.bag.items.NightHunter;
import com.example.autoraidrpg.gameplay.bag.items.SacredDiamondNecklace;
import com.example.autoraidrpg.gameplay.bag.items.ScrollOfTheGods;
import com.example.autoraidrpg.gameplay.bag.items.ShiningSwordOfTheLegend;
import com.example.autoraidrpg.gameplay.bag.items.SpaceScroll;
import com.example.autoraidrpg.gameplay.bag.items.TheGiant;
import com.example.autoraidrpg.gameplay.bag.items.TimeWarpNecklace;
import com.example.autoraidrpg.gameplay.bag.items.WildHeart;

public class ItemFactory {

    public static Item makeItem(String itemName) {
        switch(itemName) {
            case "book of the arcane mage": return new BookOfTheArcangeMage();
            case "shinning sword of the legend": return new ShiningSwordOfTheLegend();
            case "sacred diamond necklace": return new SacredDiamondNecklace();
            case "time warp necklace": return new TimeWarpNecklace();
            case "wild heart": return new WildHeart();
            case "blue ginseng root": return new BlueGinsengRoot();
            case "frozen hammer of the gods": return new FrozenHammerOfTheGods();
            case "night hunter": return new NightHunter();
            case "space scroll": return new SpaceScroll();
            case "lumen vitality power potion": return new LumenVitalityPowerPotion();
            case "horror scythe": return new HorrorScythe();
            case "enchanted hunter trap": return new EnchantedHunterTrap();
            case "immortal thunder axe": return new ImmortalHunterAxe();
            case "assassin finest blade": return new AssassinFinestBlade();
            case "berserk axe": return new BerserkAxe();
            case "marksman sanction gun": return new MarksmanSanctionGun();
            case "scroll of the gods": return new ScrollOfTheGods();
            case "the giant": return new TheGiant();
        }
        return null;
    }
    
}
