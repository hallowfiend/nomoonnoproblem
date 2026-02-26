package com.protonmail.hallowfiend.nomoonnoproblem;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("nomoonnoproblem") // Must match mods.toml
public class nomoonnoproblem {

    public nomoonnoproblem(FMLJavaModLoadingContext context) {
        // Initialize logic here
        var modBus = context.getModEventBus();

        // ...
    }
}
