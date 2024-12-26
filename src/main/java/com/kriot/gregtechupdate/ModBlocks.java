package com.kriot.gregtechupdate;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
    public static Block blueMarble;
    public static Block blackMarble;
    public static Block beigeMarble;
    public static Block redMarble;
    public static Block brownMarble;
    public static Block greenMarble;

    public static void init() {
        // Инициализация блоков
        blueMarble = new BlockMarble(Material.rock).setBlockName("blueMarble").setBlockTextureName("gregtechupdate:BlueMarble");
        blackMarble = new BlockMarble(Material.rock).setBlockName("blackMarble").setBlockTextureName("gregtechupdate:BlackMarble");
        beigeMarble = new BlockMarble(Material.rock).setBlockName("beigeMarble").setBlockTextureName("gregtechupdate:BeigeMarble");
        redMarble = new BlockMarble(Material.rock).setBlockName("redMarble").setBlockTextureName("gregtechupdate:RedMarble");
        brownMarble = new BlockMarble(Material.rock).setBlockName("brownMarble").setBlockTextureName("gregtechupdate:BrownMarble");
        greenMarble = new BlockMarble(Material.rock).setBlockName("greenMarble").setBlockTextureName("gregtechupdate:GreenMarble");

        // Регистрация блоков
        GameRegistry.registerBlock(blueMarble, "blueMarble");
        GameRegistry.registerBlock(blackMarble, "blackMarble");
        GameRegistry.registerBlock(beigeMarble, "beigeMarble");
        GameRegistry.registerBlock(redMarble, "redMarble");
        GameRegistry.registerBlock(brownMarble, "brownMarble");
        GameRegistry.registerBlock(greenMarble, "greenMarble");
    }
}
