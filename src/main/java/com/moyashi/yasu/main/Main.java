package com.moyashi.yasu.main;

import com.moyashi.yasu.PerBlock.ChangePerMoney;
import com.moyashi.yasu.PerBlock.PerSystem;
import com.moyashi.yasu.bigportion.init.BigModMobEffects;
import com.moyashi.yasu.bigportion.init.BigModPotions;
import com.moyashi.yasu.config.ConfigReload;
import com.moyashi.yasu.event.*;
import com.moyashi.yasu.grappling.entity.GrapplingHookEntity;
import com.moyashi.yasu.grappling.init.GrapplingModEntities;
import com.moyashi.yasu.grappling.init.GrapplingModItems;
import com.moyashi.yasu.hud.TextHUD;
import com.moyashi.yasu.init.IroiroModBlocks;
import com.moyashi.yasu.init.IroiroModItems;
import com.moyashi.yasu.init.IroiroModModels;
import com.moyashi.yasu.init.IroiroModTabs;
import com.moyashi.yasu.item.QuantumItem;
import com.moyashi.yasu.item.SonicdashItem;
import com.moyashi.yasu.jumping.init.TrampModBlocks;
import com.moyashi.yasu.jumping.init.TrampModItems;
import com.moyashi.yasu.keybind.FlyupMessage;
import com.moyashi.yasu.keybind.KeyBind;
import com.moyashi.yasu.keybind.init.KeybindModKeyMappings;
import com.moyashi.yasu.particc.init.ParticcModParticleTypes;
import com.moyashi.yasu.porrr.init.PorrrModItems;
import com.moyashi.yasu.porrr.item.EnergydrinkItem;
import com.moyashi.yasu.porrr.item.OmegapotionItem;
import com.moyashi.yasu.shop.ShopSystem;
import com.moyashi.yasu.shop.command;
import com.moyashi.yasu.shop.init.ShopModBlocks;
import com.moyashi.yasu.shop.init.ShopModItems;
import com.moyashi.yasu.shop.init.ShopModTabs;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.moyashi.yasu.config.Config.generateConfigFile;
import static com.moyashi.yasu.config.MoneyLoad.extractDoubleFromTextFile;
import static com.moyashi.yasu.config.speed.Speed.SPgenerateConfigFile;
import static com.moyashi.yasu.config.speed.SpeedLoad.SPextractDoubleFromTextFile;

@Mod(Reference.MOD_ID)

public class Main {
    public Main() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        generateConfigFile();
        NomalJump.register();
        NomalWalk.register();
        TextHUD.register();
        FaltRunning.register();
        MuscleLeg.register();
        Sneaking.register();
        EnergyDrink.register();
        BigModMobEffects.REGISTRY.register(bus);
        BigModPotions.REGISTRY.register(bus);
        IroiroModBlocks.REGISTRY.register(bus);
        IroiroModItems.REGISTRY.register(bus);
        IroiroModTabs.REGISTRY.register(bus);
        NetherTrav.register();
        KeyNether.register();
        TrampModItems.REGISTRY.register(bus);
        TrampModBlocks.REGISTRY.register(bus);
        JumpBoost.register();
        mph.register();
        SonicDash.register();
        ShopModBlocks.REGISTRY.register(bus);
        ShopModItems.REGISTRY.register(bus);
        ShopModTabs.REGISTRY.register(bus);
        ShopSystem.register();
        ParticcModParticleTypes.REGISTRY.register(bus);
        ShopModBlocks.ClientSideHandler.register();
        PerSystem.register();
        ChangePerMoney.register();
        QuantumItem.register();
        KeybindModKeyMappings.register();
        KeyBind.register();
        extractDoubleFromTextFile();
        SPextractDoubleFromTextFile();
        SPgenerateConfigFile();
        IroiroModModels.register();
        command.register();
        SonicdashItem.register();
        CoolDown.register();
        ConfigReload.register();
        PorrrModItems.REGISTRY.register(bus);
        EnergydrinkItem.register();
        OmegapotionItem.register();
        GrapplingModItems.REGISTRY.register(bus);
        GrapplingModEntities.REGISTRY.register(bus);
        GrapplingHookEntity.register();
        bus.addListener(this::onClientSetup);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event){
        extractDoubleFromTextFile();

        generateConfigFile();

        SPextractDoubleFromTextFile();

        SPgenerateConfigFile();
    }
    private void onClientSetup(FMLClientSetupEvent event) {


    }
}
