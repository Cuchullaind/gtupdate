package com.kriot.gregtechupdate;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class MarbleWorldGen implements IWorldGenerator{
	  @Override
	    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	        // Только для Overworld
	        if (world.provider.dimensionId == 0) {
	            generateOverworld(random, chunkX, chunkZ, world);
	        }
	    }


	    private void generateOverworld(Random random, int chunkX, int chunkZ, World world) {
	        // Генерация мраморов с природным распределением
	        addMarbleSpawn(ModBlocks.blueMarble, world, random, chunkX, chunkZ, 16, 16, 8, 15, 5, 20); // Голубой: нижние уровни
	        //Высота: 5–20 (нижние уровни, близко к лаве).Размер жилы: 8 блоков. Шанс: 15 жил на чанк.        
	        addMarbleSpawn(ModBlocks.blackMarble, world, random, chunkX, chunkZ, 16, 16, 10, 10, 5, 20); // Чёрный: нижние уровни
	        addMarbleSpawn(ModBlocks.beigeMarble, world, random, chunkX, chunkZ, 16, 16, 6, 20, 20, 50); // Бежевый: средние уровни
	        addMarbleSpawn(ModBlocks.redMarble, world, random, chunkX, chunkZ, 16, 16, 5, 8, 30, 64); // Красный: средние и верхние уровни
	        addMarbleSpawn(ModBlocks.brownMarble, world, random, chunkX, chunkZ, 16, 16, 4, 5, 20, 40); // Коричневый: редкий, средние уровни
	        addMarbleSpawn(ModBlocks.greenMarble, world, random, chunkX, chunkZ, 16, 16, 3, 3, 40, 64); // Зелёный: верхние уровни
	    }


	    private void addMarbleSpawn(Block block, World world, Random random, int chunkX, int chunkZ, 
	                                int maxX, int maxZ, int veinSize, int chancesToSpawn, int minY, int maxY) {
	        int heightRange = maxY - minY;
	        WorldGenMinable generator = new WorldGenMinable(block, veinSize);

	        for (int i = 0; i < chancesToSpawn; i++) {
	            int x = chunkX * 16 + random.nextInt(maxX);
	            int y = minY + random.nextInt(heightRange);
	            int z = chunkZ * 16 + random.nextInt(maxZ);
	            generator.generate(world, random, x, y, z);
	        }
	    }

}
