package com.hollingsworth.craftedmagic.capability;

import com.hollingsworth.craftedmagic.ArsNouveau;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ArsNouveau.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class ModCapabilities {

    @SubscribeEvent
    public static void registerCapabilities(final FMLCommonSetupEvent event){
        ManaCapability.register();
    }
}
