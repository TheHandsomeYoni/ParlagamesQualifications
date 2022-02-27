package me.thehandsomeyoni.parlagamesqualification.Statics;

import me.thehandsomeyoni.parlagamesqualification.Main;

public class GetPlugin {

    // -> Static reference to the plugin (main class)
    public static Main getPlugin(){
        return Main.getPlugin(Main.class);
    }
}
