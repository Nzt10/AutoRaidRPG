package com.example.autoraidrpg.gameplay.stage;

import com.example.autoraidrpg.R;

public class StageFactory {

    public static final int MAX_STAGE = 10;

    public static Stage makeStage(int level) {

        switch (level) {
            // CHAPTER 1
            case 1:
                return new Stage(level, R.drawable.background_01,
                        "The Call to Adventure: The protagonist receives a message from a mysterious figure, inviting them on a quest.", 1, 5, 0)
                        .addUnit("assassin", 1, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 1);
            case 2:
                return new Stage(level, R.drawable.background_01,
                        "The Gathering: The protagonist meets with their allies and receives their first task.", 1, 5, 0)
                        .addUnit("warrior", 1, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 1);
            case 3:
                return new Stage(level, R.drawable.background_01,
                        "The Road Ahead: The group sets out on their journey, facing obstacles and challenges along the way.", 1, 10, 0)
                        .addUnit("warrior", 1, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 1)
                        .addUnit("assassin", 1, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 2);
            case 4:
                return new Stage(level, R.drawable.background_01,
                        "The First Battle: The group engages in their first major battle, testing their skills and teamwork.", 1, 10, 0)
                        .addUnit("warrior", 1, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 1)
                        .addUnit("warrior", 1, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 2);
            case 5:
                return new Stage(level, R.drawable.background_01,
                        "The Dark Forest: The group enters a dangerous forest, full of mysterious creatures and hidden dangers.", 1, 10, 0)
                        .addUnit("warrior", 1, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 1)
                        .addUnit("marksman", 1, 1,
                                new int[]{1, 1, 1, 1, 1}, false, 1);
            case 6:
                return new Stage(level, R.drawable.background_02,
                        "The Enchanted Castle: The group discovers an enchanted castle, full of magical artifacts and secrets.", 2, 12, 0)
                        .addUnit("assassin", 3, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 1);
            case 7:
                return new Stage(level, R.drawable.background_02,
                        "The Betrayal: One of the group's allies is revealed to be a traitor, putting the rest of the group in danger.", 2, 12, 0)
                        .addUnit("warrior", 2, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 0)
                        .addUnit("assassin", 2, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 1)
                        .addUnit("warrior", 2, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 2);
            case 8:
                return new Stage(level, R.drawable.background_02,
                        "The Prison Break: The group must break into a heavily guarded prison to rescue an important ally.", 2, 12, 0)
                        .addUnit("warrior", 2, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 0)
                        .addUnit("warrior", 2, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 2)
                        .addUnit("marksman", 2, 1,
                                new int[]{1, 1, 1, 1, 1}, false, 1);
            case 9:
                return new Stage(level, R.drawable.background_02,
                        "The Shadow Realm: The group is transported to a dark and dangerous realm, where they must battle powerful demons and monsters.", 2, 14, 0)
                        .addUnit("warrior", 2, 1,
                                new int[]{1, 1, 1, 1, 1}, true, 1)
                        .addUnit("marksman", 2, 1,
                                new int[]{1, 1, 1, 1, 1}, false, 0)
                        .addUnit("marksman", 2, 1,
                                new int[]{1, 1, 1, 1, 1}, false, 2);
            case MAX_STAGE:
                return new Stage(level, R.drawable.background_02,
                        "The Lost City: The group discovers a lost city, full of ancient ruins and treasures.", 5, 18, 5)
                        .addUnit("berserker", 5, 1,
                                new int[]{2, 2, 2, 2, 2}, true, 1)
                        .addUnit("marksman", 2, 1,
                                new int[]{1, 2, 1, 1, 1}, false, 0)
                        .addUnit("marksman", 2, 1,
                                new int[]{1, 2, 1, 1, 1}, false, 1)
                        .addUnit("marksman", 2, 1,
                                new int[]{1, 2, 1, 1, 1}, false, 2);
        }

        return null;
    }

}
