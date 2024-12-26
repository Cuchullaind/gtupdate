package com.kriot.gregtechupdate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMarble extends Block {
    public BlockMarble(Material material) {
        super(material);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeStone);
    }
}
