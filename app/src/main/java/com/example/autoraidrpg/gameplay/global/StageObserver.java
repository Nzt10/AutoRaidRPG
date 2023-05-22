package com.example.autoraidrpg.gameplay.global;

import com.example.autoraidrpg.gameplay.stage.Stage;

public class StageObserver {

    private static Stage currentStage;

    private StageObserver() {}

    public static void setStage(Stage stage) {
        currentStage = stage;
    }

    public static Stage getInstance() {  return currentStage; }

}
