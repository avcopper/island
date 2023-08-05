package com.javarush.island.cooper.services;

import com.javarush.island.cooper.constants.AppConstants;
import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.system.Settings;

public class UnknownAction extends Simulation {
    public UnknownAction(Island island, Settings settings) {
        super(island, settings);
    }

    @Override
    public void run() {
        System.out.println(AppConstants.UNKNOWN_ACTION);
    }
}
