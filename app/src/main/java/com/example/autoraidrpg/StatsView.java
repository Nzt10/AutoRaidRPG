package com.example.autoraidrpg;

import android.widget.TextView;

public interface StatsView {

    public abstract TextView getHealth();
    public abstract TextView getPhysicalDamage();
    public abstract TextView getMagicalDamage();
    public abstract TextView getPhysicalDefense();
    public abstract TextView getMagicalDefense();
    public abstract TextView getSpeed();
    public abstract TextView getCriticalChance();
    public abstract TextView getCriticalDamage();
    public abstract TextView getDodge();
    public abstract TextView getArmorPenetration();
    public abstract TextView getMagicPenetration();
    public abstract TextView getAccuracy();

}
