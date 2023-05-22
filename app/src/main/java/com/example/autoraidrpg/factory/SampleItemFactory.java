package com.example.autoraidrpg.factory;

import com.example.autoraidrpg.R;
import com.example.autoraidrpg.sample_objects.SampleItem;

public class SampleItemFactory {

    public static SampleItem makeItem(String name) {

        switch(name) {
            case "book of the arcane mage":
                return new SampleItem(name, R.drawable.item_book_of_the_arcane_mage, "+10 magical damage", "New magical spells, allowing them to cast powerful and devastating attacks in combat. This can be especially useful for mage or wizard-type characters who rely on magic as their primary means of offense. However, reading certain mage books may also come with risks, such as attracting the attention of magical creatures or causing the character to become corrupted by dark magic. As a result, players must carefully consider the potential risks and rewards of using a mage book before deciding whether to use it or not.");
            case "shinning sword of the legend":
                return new SampleItem(name, R.drawable.item_shinning_sword_of_the_legend, "+10 physical damage", "A powerful weapon that emits a bright aura or light, often imbued with holy or magical properties. When wielded, the light sword can deal extra damage to undead or demonic enemies, as well as provide a boost to the wielder's accuracy and speed. Some light swords may also have additional effects, such as healing the wielder's HP, boosting their resistance to magic, or increasing the amount of EXP gained from battles. However, using a light sword may also attract the attention of dark forces, making the wielder a target for powerful demonic creatures or dark mages. As a result, the use of a light sword should be carefully considered in any given situation.");
            case "sacred diamond necklace":
                return new SampleItem(name, R.drawable.item_sacred_diamond_necklace, "+10 magical defense", "A sacred necklace, a powerful item that provides a range of beneficial effects to its wearer, typically a cleric or other holy warrior. The necklace may provide a boost to the wearer's health points or mana points, as well as a bonus to their healing or protective spells. Additionally, the necklace may provide resistance to dark magic or curses, making it an essential item for battling undead or demonic enemies. Some cleric necklaces may also provide a boost to the wearer's strength or dexterity, allowing them to wield heavier weapons or move more quickly in combat. However, wearing a cleric necklace may also attract the attention of dark forces, making the wearer a target for powerful demonic creatures or dark mages. As a result, the use of a cleric necklace should be carefully considered in any given situation.");
            case "time warp necklace":
                return new SampleItem(name, R.drawable.item_time_warp_necklace, "+5 speed", "Enhances the wearer's speed and agility. The necklace may provide a boost to the wearer's dexterity or reflexes, allowing them to dodge attacks more easily or move more quickly in combat. Additionally, the necklace may provide a bonus to the wearer's initiative or attack speed, allowing them to strike first in battle or unleash a flurry of attacks. The speed necklace is especially useful for characters who rely on mobility and agility in combat, such as archers or rogues. However, the wearer must be careful not to overexert themselves, as the speed necklace may cause fatigue or even physical damage if used for too long. As a result, the use of a speed necklace should be balanced with other defensive and offensive tactics to ensure the wearer's survival.");
            case "wild heart":
                return new SampleItem(name, R.drawable.item_wild_heart, "+175 health", "Valuable item that provides the wearer with increased health and healing abilities. The necklace may grant a bonus to the wearer's maximum health points or provide passive health regeneration, allowing them to recover from injuries more quickly in combat. Additionally, the heart necklace may provide the wearer with healing abilities, such as the ability to cast a healing spell or to consume a health potion at a reduced cost. The heart necklace is especially useful for characters who act as healers or tanks, as it enables them to withstand more damage and support their allies in combat. However, the wearer must be careful not to become overconfident, as the heart necklace does not provide invincibility and the wearer can still be defeated with sufficient force or tactics. As a result, the heart necklace should be used in conjunction with other defensive and supportive abilities to ensure the wearer's success in combat.");
            case "blue ginseng root":
                return new SampleItem(name, R.drawable.item_blue_ginseng_root, "+10 physical defense", "A powerful defensive ginseng accessory that provides extra protection to the wearer. When equipped, it grants a significant boost to the wearer's defense, reducing the damage taken from incoming attacks. In addition, the Armor Amulet has the ability to absorb a portion of the damage received, protecting the wearer from taking too much damage at once. This makes the wearer more resistant to high-damage attacks and provides an extra layer of defense against particularly tough opponents. However, due to the powerful nature of the amulet, it can be quite heavy and cumbersome to wear, making the wearer slower and less agile in combat. Despite this drawback, the Armor Amulet is a valuable asset to any adventurer seeking extra protection and durability in battle.");
            case "frozen hammer of the gods":
                return new SampleItem(name, R.drawable.item_frozen_hammer_of_the_gods, "+6 physical damage\n+6 physical defense", "A powerful hammer that deals massive damage to enemies, especially those vulnerable to cold attacks. When the hammer strikes, it has a chance to freeze the enemy, slowing their movements and making them more susceptible to additional attacks. The hammer's magic also imbues the wielder with increased resistance to cold-based attacks, providing extra protection in battle. The hammer's powers are most effective when facing enemies in cold environments, making it a valuable tool in battles in frozen tundras or snow-covered peaks. However, it can be less effective in warmer climates or against enemies with high resistance to cold damage. Overall, the Frozen Hammer is a valuable asset to any warrior looking to deal devastating blows and gain an advantage in battle.");
            case "night hunter":
                return new SampleItem(name, R.drawable.item_night_hunter, "+6 physical damage\n+6 speed", "Gains the ability to use the hook as a weapon and as a utility tool. The Hook can be thrown to grab objects, allowing the player to climb up to higher areas or pull down objects to reveal secret paths. In combat, the Hook can be used to pull enemies closer, making it easier to defeat them with melee attacks or spells. The Hook also has a chance to stun enemies it hits, making them vulnerable to follow-up attacks. However, the Hook has a limited range and can be difficult to aim, making it a high-risk, high-reward tool for players who like to get up close and personal with their enemies.");
            case "space scroll":
                return new SampleItem(name, R.drawable.item_space_scroll, "+6 magical damage\n+6 speed", "A magical item that when activated, creates a portal to a different location. The portal remains open for a short period, allowing the user and other nearby individuals to pass through. The destination of the portal can be chosen by the user, but the scroll must be attuned to the desired location beforehand. Once used, the Space Scroll needs to be recharged before it can be used again. This item can be useful for quickly traveling long distances or escaping dangerous situations. However, it is not without its risks, as the user may end up in an unfamiliar or dangerous location if they are not careful in choosing the destination of the portal.");
            case "lumen vitality power potion":
                return new SampleItem(name, R.drawable.item_lumen_vitality_power_potion, "+100 health\n+2.75 speed", "A type of consumable item that temporarily increases the user's health and overall physical endurance. Upon consumption, the potion grants an immediate boost to the user's health points, allowing them to withstand more damage in combat or strenuous activity. In addition, the potion increases the user's stamina and reduces fatigue, enabling them to perform physical tasks for longer periods of time. The effects of the potion last for a limited time, after which the user's health and stamina return to their previous levels. Vitality potions are highly valued by adventurers, warriors, and anyone who needs to stay physically active for prolonged periods, and can be a lifesaver in the midst of battle or a physically demanding quest.");
            case "horror scythe":
                return new SampleItem(name, R.drawable.item_horror_scythe, "+6 physical damage\n+6 magical damage", "The Horror Scythe is a powerful and terrifying weapon that unleashes darkness and chaos upon the enemy. When wielded, it grants its user the power to drain the life force of their opponents, inflicting severe damage and instilling fear into their hearts. This weapon's eerie and malevolent nature is amplified when used in battle, as its bloodthirsty thirst for carnage is almost palpable. The Horror Scythe's unique abilities are further enhanced when used against the undead or other supernatural beings, as its power over death and decay grows exponentially. However, the user must be careful, as the Scythe's dark magic can consume them if they become too dependent on its abilities.");
            case "enchanted hunter trap":
                return new SampleItem(name, R.drawable.item_enchanted_hunter_trap, "+6 physical damage\n+2.75 speed", "Item that can be used to set traps in order to immobilize or damage enemies. When triggered, the trap will snare the enemy for a short period of time, allowing the hunter to either attack or retreat. The trap can be set in various locations and can be triggered by stepping on it, or by using a remote trigger. The trap can be upgraded to deal more damage or to last longer, and can be used in a variety of situations, such as in combat or during a chase. However, it requires strategic placement and timing to be effective, and can be disarmed or avoided by skilled enemies.");
            case "immortal thunder axe":
                return new SampleItem(name, R.drawable.item_immortal_thunder_axe, "+6 magical damage\n+100 health", "The Immortal Thunder Axe is a powerful weapon imbued with the essence of lightning. It has the ability to unleash thunderous shocks that can strike down enemies from afar. This axe also grants its wielder immense strength, allowing them to deal devastating blows that can shatter the toughest armor. Moreover, the axe has an enchantment that makes it indestructible, ensuring its longevity in battle. However, the power of the Immortal Thunder Axe is not easily wielded and requires great skill and mastery to harness. Only the bravest and most skilled warriors are able to fully harness the power of this legendary weapon.");
            case "assassin finest blade":
                return new SampleItem(name, R.drawable.item_assassin_finest_blade, "+4 physical damage\n+10% critical chance", "Assassin Finest Blade is a rare and deadly weapon that possesses the power to take down the toughest of enemies. When wielded in combat, it grants the user exceptional agility and precision, making it easier to hit and dodge attacks. The blade is imbued with dark magic that enables it to deal critical damage and bypass armor. Additionally, the blade's hilt is designed to reduce the weight of the weapon, allowing the user to move with greater speed and fluidity in combat. However, the blade's dark magic comes at a cost - prolonged use can drain the user's energy and cause them to become fatigued. Only the most skilled and experienced assassins can handle the power of the Finest Blade.");
            case "berserk axe":
                return new SampleItem(name, R.drawable.item_berserk_axe, "+4 physical damage\n+1.5 speed\n+65 health", "The Berserk Axe is a powerful weapon that increases the wielder's strength and speed, but at a cost. While equipped, the wielder gains a significant boost to their physical attack power, allowing them to deal massive damage to their enemies. However, the berserk nature of the weapon can cause the wielder to lose control, making them more vulnerable to attacks and lowering their defense. Additionally, the weapon drains the wielder's health over time, making it a risky choice in prolonged battles. Skilled fighters can make great use of this weapon, but it is not recommended for those who are not confident in their abilities.");
            case "marksman sanction gun":
                return new SampleItem(name, R.drawable.item_marksman_sanction_gun, "+30 physical damage\n-5 speed", "Marksman weapon that offers an increased critical hit rate and precision shooting capabilities. It fires specialized rounds that deal heavy damage to a single target or multiple targets in a row. The gun also offers an enhanced zoom for improved accuracy and range. The Sanction Gun is ideal for sniping, as its long-range capabilities allow for precise hits on distant enemies. Additionally, the gun offers a rapid-fire mode for close-range combat, making it a versatile weapon suitable for a wide range of situations.");
            case "scroll of the gods":
                return new SampleItem(name, R.drawable.item_scroll_of_the_gods, "+6 physical defense\n+6 magical defense", "The Scroll of the Gods is a powerful magical artifact that enhances the abilities of the user. When used, it increases the user's magical power and grants them temporary invincibility. The user becomes immune to all forms of damage, and their attacks deal increased damage. Additionally, the Scroll of the Gods has the power to dispel magical effects and barriers, making it a useful tool in combat against spellcasters. However, the power of the scroll is not without its drawbacks, as the user is left weakened and vulnerable once its effects wear off. The scroll must be used with caution, as overuse or misuse can have dire consequences.");
            case "the giant":
                return new SampleItem(name, R.drawable.item_the_giant, "+4 physical damage\n+4 physical defense\n+65 health", "A heavy weapon that inflicts devastating blows on enemies. When wielded in battle, the spiked ball at the end of the chain can swing in a wide arc, striking multiple targets at once. Additionally, the chain can be used to entangle enemies, immobilizing them for a short time. This can give the wielder a strategic advantage, allowing them to attack the enemy while they are vulnerable. The mace's weight and size make it difficult to handle, requiring significant strength and skill to wield effectively. However, in the hands of a capable warrior, the Chain Mace can be a deadly weapon on the battlefield.");

        }

        return null;

    }

}
