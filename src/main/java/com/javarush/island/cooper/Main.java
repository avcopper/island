package com.javarush.island.cooper;

import com.javarush.island.cooper.system.Result;
import com.javarush.island.cooper.system.ResultCode;
import com.javarush.island.cooper.view.View;
import com.javarush.island.cooper.view.GUIView;
import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.system.Settings;
import com.javarush.island.cooper.app.Application;
import com.javarush.island.cooper.controller.Controller;

public class Main {
    public static void main(String[] args) {
        try {
            Settings settings = Settings.getInstance();
            Island island = new Island(settings);

            View view = new GUIView(island, settings);
            Controller controller = new Controller(view);
            Application application = new Application(controller);
            application.run();
        } catch (Exception e) {
            Application.showResult(new Result(ResultCode.ERROR, e.getMessage()));
        }
    }
}
