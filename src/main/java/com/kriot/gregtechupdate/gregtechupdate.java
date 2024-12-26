package com.kriot.gregtechupdate;

import java.util.Arrays;

import gregtech.api.enums.Element;
import com.teammetallurgy.metallurgy.Metallurgy;
import com.teammetallurgy.metallurgy.api.MetallurgyApi;
import com.teammetallurgy.metallurgycore.MetallurgyCore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Recipe.GT_Recipe_Map;
import gregtech.api.util.GT_Recipe.GT_Recipe_Map_FormingPress;
import gregtech.common.GT_Worldgen_GT_Ore_Layer;
import gregtech.common.GT_Worldgen_Stone;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Dyes;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialBuilder;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.enums.TC_Aspects;
import gregtech.api.enums.TextureSet;
import gregtech.api.interfaces.IMaterialHandler;
import gregtech.api.interfaces.ISubTagContainer;
import gregtech.api.objects.MaterialStack;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

@Mod(modid = gregtechupdate.MODID, name = gregtechupdate.NAME, version = gregtechupdate.VERSION)
public class gregtechupdate 
{

	    public static final String MODID = "gregtechupdate";
	    public static final String NAME = "GT Update";
	    public static final String VERSION = "1.0";
	    public static Block blueMarble;
	    public static Block blackMarble;
	    public static Block beigeMarble;
	    public static Block redMarble;
	    public static Block brownMarble;
	    public static Block greenMarble;
	    public static ExtendedMaterials Rhenium = new ExtendedMaterials(//ReMoW- ракетные двигатели
	            204,                                   // Уникальный ID материала
	            TextureSet.SET_METALLIC,               // Текстура: металлическая
	            2.0F,                                  // Скорость инструментов
	            0,                                     // Прочность (по умолчанию)
	            3,                                     // Качество инструментов
	            50,                                    // Типы объектов
	            70,                                    // Красный компонент цвета
	            70,                                    // Зеленый компонент цвета
	            90,                                    // Синий компонент цвета
	            0,                                     // Прозрачность (0 = непрозрачно)
	            "Rhenium",                             // Внутреннее имя
	            "Rhenium",                             // Локализованное имя
	            0,                                     // Тип топлива (не является топливом)
	            0,                                     // Энергетическая мощность топлива
	            3459,                                  // Температура плавления (в Кельвинах)
	            5900,                                  // Температура кипения (в Кельвинах)
	            true,                                  // Требуется ли доменная печь
	            false,                                 // Прозрачность
	            2,                                     // Ценность руды
	            1,                                     // Множитель плотности
	            1,                                     // Делитель плотности
	            Dyes.dyeGray,                          // Цвет материала
	            Element.Re,                            // Химический элемент (Рений)
	            Arrays.asList(                         // Thaumcraft аспекты
	                new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4L),
	                new TC_Aspects.TC_AspectStack(TC_Aspects.LUX, 1L)
	            )
	    );

	    


	    
	    public static Materials Bitumen = new Materials(
	    	    200,                                    // Уникальный ID материала
	    	    TextureSet.SET_DULL,                   // Набор текстур
	    	    1.5F,                                   // Скорость инструментов
	    	    0,                                      // Прочность
	    	    1,                                      // Твердость
	    	    50,                                     // Прочность
	    	    50,                                     // Качество инструментов
	    	    50,                                     // Типы объектов
	    	    50,                                     // Магнитная проводимость
	    	    0,                                      // Блеск
	    	    "Bitumen",                              // Локализованное имя
	    	    "Bitumen",                              // Имя материала
	    	    0,                                      // Категория брони
	    	    0,                                      // Мягкость
	    	    120,                                    // Температура плавления (в Кельвинах)
	    	    0,                                      // Температура кипения
	    	    false,                                  // Может ли быть жидкостью
	    	    false,                                  // Может ли быть радиоактивным
	    	    2,                                      // Уровень добычи
	    	    1,                                      // Уровень сопротивления
	    	    1,                                      // Категория инвентаря
	    	    Dyes.dyeBlack,                          // Цвет материала
	    	    Element.C,                              // Химический элемент (углерод)
	    	    Arrays.asList(                          // Аспекты для Thaumcraft
	    	        new TC_Aspects.TC_AspectStack(TC_Aspects.TERRA, 2L), 
	    	        new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 1L)
	    	    )
	    	);

	    	public static Materials SamariumCobalt = new Materials(
	    	    202,                                   // Уникальный ID материала
	    	    TextureSet.SET_METALLIC,               // Текстура: металлическая
	    	    2.0F,                                  // Скорость инструментов
	    	    256,                                   // Прочность
	    	    3,                                     // Качество инструментов
	    	    235,                                   // Типы объектов (все типы)
	    	    100,                                   // Красный компонент цвета
	    	    130,                                   // Зеленый компонент цвета
	    	    160,                                   // Синий компонент цвета
	    	    0,                                     // Прозрачность (0 = непрозрачно)
	    	    "SamariumCobaltAlloy",                  // Внутреннее имя
	    	    "Samarium Cobalt Alloy",                // Локализованное имя
	    	    0,                                     // Тип топлива (не является топливом)
	    	    0,                                     // Энергетическая мощность топлива
	    	    1450,                                  // Температура плавления (Кельвины)
	    	    1800,                                  // Температура обработки в доменной печи
	    	    true,                                  // Требуется ли доменная печь
	    	    false,                                 // Прозрачность (непрозрачный)
	    	    4,                                     // Ценность руды
	    	    1,                                     // Множитель плотности
	    	    1,                                     // Делитель плотности
	    	    Dyes.dyeBlue,                          // Цвет (на основе серо-синего оттенка)
	    	    0,                                     // Дополнительные данные
	    	    Arrays.asList(                         // Составные элементы
	    	        new MaterialStack(Materials.Samarium, 1L), // 1 часть самария
	    	        new MaterialStack(Materials.Cobalt, 4L)   // 4 части кобальта
	    	    ),
	    	    Arrays.asList(                         // Thaumcraft аспекты
	    	        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L),
	    	        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 2L)
	    	    )
	    	);
	    	public static Materials SamariumCobaltMagnetic = new Materials(
		    	    201,                                   // Уникальный ID материала
		    	    TextureSet.SET_MAGNETIC,               // Текстура: магнитная
		    	    4.0F,                                  // Скорость инструментов
		    	    512,                                   // Прочность
		    	    3,                                     // Качество инструментов
		    	    195,                                   // Типы объектов
		    	    100,                                   // Красный компонент цвета
		    	    130,                                   // Зеленый компонент цвета
		    	    160,                                   // Синий компонент цвета
		    	    0,                                     // Прозрачность
		    	    "SamariumCobaltMagneticAlloy",          // Внутреннее имя
		    	    "Samarium-Cobalt Magnetic Alloy",       // Локализованное имя
		    	    0,                                     // Тип топлива
		    	    0,                                     // Энергетическая мощность
		    	    1450,                                  // Температура плавления
		    	    1800,                                  // Температура обработки в доменной печи
		    	    true,                                  // Требуется ли доменная печь
		    	    false,                                 // Прозрачность
		    	    4,                                     // Ценность руды
		    	    51,                                    // Множитель плотности
		    	    50,                                    // Делитель плотности
		    	    Dyes.dyeBlue,                          // Цвет
		    	    1,                                     // Дополнительные данные
		    	    Arrays.asList(                         // Составные элементы
		    	        new MaterialStack(Materials.Samarium, 1L),
		    	        new MaterialStack(Materials.Cobalt, 4L)
		    	    ),
		    	    Arrays.asList(                         // Thaumcraft аспекты
		    	        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L),
		    	        new TC_Aspects.TC_AspectStack(TC_Aspects.MAGNETO, 3L)
		    	    )
		    	);
	    	public static Materials Germanium = new Materials(// Ge - полупроводники, оптоволокно
	                218,                                   // Уникальный ID материала
	                TextureSet.SET_METALLIC,               // Текстура: металлическая
	                1.0F,                                  // Скорость инструментов (немного ниже, так как германий - полуметалл)
	                0,                                     // Прочность (по умолчанию)
	                3,                                     // Качество инструментов
	                50,                                    // Типы объектов
	                50,                                    // Красный компонент цвета
	                50,                                    // Зеленый компонент цвета
	                50,                                    // Синий компонент цвета
	                0,                                     // Прозрачность (0 = непрозрачно)
	                "Germanium",                           // Внутреннее имя
	                "Germanium",                           // Локализованное имя
	                0,                                     // Тип топлива (не является топливом)
	                0,                                     // Энергетическая мощность топлива
	                1211,                                  // Температура плавления (в Кельвинах)
	                2833,                                  // Температура кипения (в Кельвинах)
	                true,                                  // Требуется ли доменная печь
	                false,                                 // Прозрачность
	                3,                                     // Ценность руды (учитывая, что германий добывается в следовых количествах)
	                5,                                     // Множитель плотности (где германий относительно более плотный)
	                2,                                     // Делитель плотности
	                Dyes.dyeGray,                          // Цвет материала
	                Element.Ge,                            // Химический элемент (Германий)
	                Arrays.asList(                         // Thaumcraft аспекты
	                    new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L),
	                    new TC_Aspects.TC_AspectStack(TC_Aspects.LUX, 2L),
	                    new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1L)  // Германий используется в оптоволокне, добавлен аспект Vitreus
	                )
	        );

	    	public static Materials RareEarthDyErHoTmYtLu = new Materials(
    			    214,                                   // Уникальный ID материала
    			    TextureSet.SET_FINE,                  // Текстура: мелкая структура
    			    1.0F,                                 // Скорость инструментов
    			    0,                                    // Прочность (по умолчанию)
    			    0,                                    // Качество инструментов
    			    1,                                    // Типы объектов
    			    128,                                  // Красный компонент цвета
    			    100,                                  // Зеленый компонент цвета
    			    150,                                  // Синий компонент цвета
    			    0,                                    // Прозрачность (0 = непрозрачно)
    			    "RareEarthDyErHoTmYtLu",            // Внутреннее имя
    			    "Rare Earth Dy Er Ho Tm Yt Lu",     // Локализованное имя
    			    0,                                    // Тип топлива (не является топливом)
    			    0,                                    // Энергетическая мощность топлива
    			    -1,                                   // Температура плавления (не плавится)
    			    0,                                    // Температура кипения (не кипит)
    			    false,                                // Требуется ли доменная печь
    			    false,                                // Прозрачность
    			    1,                                    // Ценность руды
    			    1,                                    // Множитель плотности
    			    1,                                    // Делитель плотности
    			    Dyes.dyeGray,                         // Цвет материала
    			    Arrays.asList(                        // Thaumcraft аспекты
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 2L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 1L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L)
    			    )
    			);
	    	public static Materials RareEarthDySmEuGd = new Materials(
	    		    215, // Уникальный ID материала
	    		    TextureSet.SET_FINE, // Текстура: мелкая
	    		    1.0F, // Скорость инструментов
	    		    0, // Прочность (по умолчанию)
	    		    0, // Качество инструментов
	    		    1, // Типы объектов
	    		    130, // Красный компонент цвета
	    		    130, // Зеленый компонент цвета
	    		    110, // Синий компонент цвета
	    		    0, // Прозрачность (0 = непрозрачно)
	    		    "RareEarthDySmEuGd", // Внутреннее имя
	    		    "Rare Earth Dy Sm Eu Gd", // Локализованное имя
	    		    0, // Тип топлива (не является топливом)
	    		    0, // Энергетическая мощность топлива
	    		    -1, // Температура плавления (не плавится)
	    		    0, // Температура кипения (не кипит)
	    		    false, // Не требует доменной печи
	    		    false, // Прозрачность
	    		    1, // Ценность руды
	    		    1, // Множитель плотности
	    		    1, // Делитель плотности
	    		    Dyes.dyeGray, // Цвет материала
	    		    Arrays.asList( // Thaumcraft аспекты
	    		        new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1L),
	    		        new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 1L)
	    		    )
	    		);
	    	public static Materials RareEarthGdCeYDyTb = new Materials(
    			    216,                                   // Уникальный ID материала
    			    TextureSet.SET_FINE,                  // Текстура: мелкая структура
    			    1.0F,                                 // Скорость инструментов
    			    0,                                    // Прочность (по умолчанию)
    			    0,                                    // Качество инструментов
    			    1,                                    // Типы объектов
    			    128,                                  // Красный компонент цвета
    			    100,                                  // Зеленый компонент цвета
    			    130,                                  // Синий компонент цвета
    			    0,                                    // Прозрачность (0 = непрозрачно)
    			    "RareEarthGdCeYDyTb",            // Внутреннее имя
    			    "Rare Earth Gd Ce Y Dy Tb",     // Локализованное имя
    			    0,                                    // Тип топлива (не является топливом)
    			    0,                                    // Энергетическая мощность топлива
    			    -1,                                   // Температура плавления (не плавится)
    			    0,                                    // Температура кипения (не кипит)
    			    false,                                // Требуется ли доменная печь
    			    false,                                // Прозрачность
    			    1,                                    // Ценность руды
    			    1,                                    // Множитель плотности
    			    1,                                    // Делитель плотности
    			    Dyes.dyeGray,                         // Цвет материала
    			    Arrays.asList(                        // Thaumcraft аспекты
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 2L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 1L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L)
    			    )
    			);
	    	//RareEarthEuScZr
	    	public static Materials RareEarthEuScZr = new Materials(
    			    217,                                   // Уникальный ID материала
    			    TextureSet.SET_FINE,                  // Текстура: мелкая структура
    			    1.0F,                                 // Скорость инструментов
    			    0,                                    // Прочность (по умолчанию)
    			    0,                                    // Качество инструментов
    			    1,                                    // Типы объектов
    			    128,                                  // Красный компонент цвета
    			    110,                                  // Зеленый компонент цвета
    			    130,                                  // Синий компонент цвета
    			    0,                                    // Прозрачность (0 = непрозрачно)
    			    "RareEarthEuScZr",            // Внутреннее имя
    			    "Rare Earth Eu Sc Zr",     // Локализованное имя
    			    0,                                    // Тип топлива (не является топливом)
    			    0,                                    // Энергетическая мощность топлива
    			    -1,                                   // Температура плавления (не плавится)
    			    0,                                    // Температура кипения (не кипит)
    			    false,                                // Требуется ли доменная печь
    			    false,                                // Прозрачность
    			    1,                                    // Ценность руды
    			    1,                                    // Множитель плотности
    			    1,                                    // Делитель плотности
    			    Dyes.dyeGray,                         // Цвет материала
    			    Arrays.asList(                        // Thaumcraft аспекты
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 2L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 1L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L)
    			    )
    			);
	    	//RareEarthEuScZr
	    	public static Materials RareEarthGeInGa = new Materials(
    			    222,                                   // Уникальный ID материала
    			    TextureSet.SET_FINE,                  // Текстура: мелкая структура
    			    1.0F,                                 // Скорость инструментов
    			    0,                                    // Прочность (по умолчанию)
    			    0,                                    // Качество инструментов
    			    1,                                    // Типы объектов
    			    128,                                  // Красный компонент цвета
    			    110,                                  // Зеленый компонент цвета
    			    140,                                  // Синий компонент цвета
    			    0,                                    // Прозрачность (0 = непрозрачно)
    			    "RareEarthGeInGa",            // Внутреннее имя
    			    "Rare Earth Ge In Ga",     // Локализованное имя
    			    0,                                    // Тип топлива (не является топливом)
    			    0,                                    // Энергетическая мощность топлива
    			    -1,                                   // Температура плавления (не плавится)
    			    0,                                    // Температура кипения (не кипит)
    			    false,                                // Требуется ли доменная печь
    			    false,                                // Прозрачность
    			    1,                                    // Ценность руды
    			    1,                                    // Множитель плотности
    			    1,                                    // Делитель плотности
    			    Dyes.dyeGray,                         // Цвет материала
    			    Arrays.asList(                        // Thaumcraft аспекты
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 2L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 1L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L)
    			    )
    			);
	    	public static Materials Rheniite = new Materials(
	    		    203, 
	    		    TextureSet.SET_FINE, 
	    		    1.0F, 0, 2, 9, 
	    		    300, 120, 50, 0, 
	    		    "Rheniite", "Rheniite", 
	    		    0, 0, -1, 0, 
	    		    false, false, 
	    		    1, 1, 1, 
	    		    Dyes._NULL, 
	    		    1, 
	    		    Arrays.asList(
	    		        new MaterialStack(Rhenium, 1L), 
	    		        new MaterialStack(Materials.Sulfur, 2L)
	    		    )
	    		);

	    		public static Materials Xenotime = new Materials(
	    		    207, 
	    		    TextureSet.SET_FINE, 
	    		    1.0F, 0, 2, 9, 
	    		    250, 100, 45, 0, 
	    		    "Xenotime", "Xenotime", 
	    		    0, 0, -1, 0, 
	    		    false, false, 
	    		    1, 1, 1, 
	    		    Dyes._NULL, 
	    		    1, 
	    		    Arrays.asList(
	    		        new MaterialStack(Materials.Yttrium, 1L), 
	    		        new MaterialStack(Materials.Phosphorus, 1L), 
	    		        new MaterialStack(Materials.Oxygen, 4L),
	    		        new MaterialStack(RareEarthDyErHoTmYtLu, 1L),
	    		        new MaterialStack(RareEarthEuScZr, 1L)
	    		    )
	    		);

	    		public static Materials Samarskite = new Materials(//YFe3+Fe2+U,Th,Ca)2(Nb,Ta)2O8
	    		    208, 
	    		    TextureSet.SET_FINE, 
	    		    1.0F, 0, 2, 9, 
	    		    270, 115, 50, 0, 
	    		    "Samarskite", "Samarskite", 
	    		    0, 0, -1, 0, 
	    		    false, false, 
	    		    1, 1, 1, 
	    		    Dyes._NULL, 
	    		    1, 
	    		    Arrays.asList(
	    		        new MaterialStack(Materials.Yttrium, 2L), 
	    		        new MaterialStack(Materials.Iron, 10L), 
	    		        new MaterialStack(Materials.Uranium, 2L), 
	    		        new MaterialStack(Materials.Thorium, 2L), 
	    		        new MaterialStack(Materials.Oxygen, 8L),
	    		        new MaterialStack(RareEarthDySmEuGd, 1L)
	    		    )
	    		);

	    		public static Materials Parisite = new Materials(
	    		    209, 
	    		    TextureSet.SET_FINE, 
	    		    1.0F, 0, 2, 9, 
	    		    280, 125, 50, 0, 
	    		    "Parisite", "Parisite", 
	    		    0, 0, -1, 0, 
	    		    false, false, 
	    		    1, 1, 1, 
	    		    Dyes._NULL, 
	    		    1, 
	    		    Arrays.asList(
	    		        new MaterialStack(Materials.Cerium, 1L), 
	    		        new MaterialStack(Materials.Calcium, 1L), 
	    		        new MaterialStack(Materials.Carbon, 3L), 
	    		        new MaterialStack(Materials.Oxygen, 9L),
	    		        new MaterialStack(Materials.Fluorine, 2L),
	    		        new MaterialStack(Materials.RareEarth, 1L)
	    		    )
	    		);

	    		public static Materials Corundum = new Materials(
	    		    210, 
	    		    TextureSet.SET_FINE, 
	    		    1.0F, 0, 2, 9, 
	    		    290, 130, 55, 0, 
	    		    "Corundum", "Corundum", 
	    		    0, 0, -1, 0, 
	    		    false, false, 
	    		    1, 1, 1, 
	    		    Dyes._NULL, 
	    		    1, 
	    		    Arrays.asList(
	    		        new MaterialStack(Materials.Aluminium, 2L), 
	    		        new MaterialStack(Materials.Oxygen, 3L)
	    		    )
	    		);

	    		public static Materials Gadolinite = new Materials(
	    		    211, 
	    		    TextureSet.SET_FINE, 
	    		    1.0F, 0, 2, 9, 
	    		    300, 140, 60, 0, 
	    		    "Gadolinite", "Gadolinite", 
	    		    0, 0, -1, 0, 
	    		    false, false, 
	    		    1, 1, 1, 
	    		    Dyes._NULL, 
	    		    1, 
	    		    Arrays.asList(
	    		        new MaterialStack(Materials.Iron, 1L), 
	    		        new MaterialStack(Materials.Silicon, 2L), 
	    		        new MaterialStack(RareEarthGdCeYDyTb, 2L), 
	    		        new MaterialStack(Materials.Oxygen, 2L)
	    		    )
	    		);

	    		public static Materials Euxenite = new Materials(
	    		    212, 
	    		    TextureSet.SET_FINE, 
	    		    1.0F, 0, 2, 9, 
	    		    310, 150, 60, 0, 
	    		    "Euxenite", "Euxenite", 
	    		    0, 0, -1, 0, 
	    		    false, false, 
	    		    1, 1, 1, 
	    		    Dyes._NULL, 
	    		    1, 
	    		    Arrays.asList(
	    		        new MaterialStack(RareEarthGdCeYDyTb, 2L), 
	    		        new MaterialStack(Materials.Titanium, 2L), 
	    		        new MaterialStack(Materials.Niobium, 2L),
	    		        new MaterialStack(Materials.Oxygen, 6L)
	    		    )
	    		);

	    		public static Materials Loparite = new Materials(
	    		    213, 
	    		    TextureSet.SET_FINE, 
	    		    1.0F, 0, 2, 9, 
	    		    320, 160, 65, 0, 
	    		    "Loparite", "Loparite", 
	    		    0, 0, -1, 0, 
	    		    false, false, 
	    		    1, 1, 1, 
	    		    Dyes._NULL, 
	    		    1, 
	    		    Arrays.asList(
	    		        new MaterialStack(Materials.Titanium, 1L), 
	    		        new MaterialStack(Materials.Sodium, 1L), 
	    		        new MaterialStack(Materials.Cerium, 1L),
	    		        new MaterialStack(Materials.Calcium, 1L),
	    		        new MaterialStack(Materials.Niobium, 1L),
	    		        new MaterialStack(Materials.Oxygen, 3L),
	    		        new MaterialStack(RareEarthDySmEuGd, 1L)
	    		    )
	    		);
	    		public static ExtendedMaterials Zirconium = new ExtendedMaterials( // Zr — ядерная промышленность
	    		        205,                                   // Уникальный ID материала
	    		        TextureSet.SET_METALLIC,               // Текстура: металлическая
	    		        1.5F,                                  // Скорость инструментов
	    		        0,                                     // Прочность (по умолчанию)
	    		        2,                                     // Качество инструментов
	    		        40,                                    // Типы объектов
	    		        180,                                   // Красный компонент цвета
	    		        180,                                   // Зеленый компонент цвета
	    		        200,                                   // Синий компонент цвета
	    		        0,                                     // Прозрачность (0 = непрозрачно)
	    		        "Zirconium",                           // Внутреннее имя
	    		        "Zirconium",                           // Локализованное имя
	    		        0,                                     // Тип топлива (не является топливом)
	    		        0,                                     // Энергетическая мощность топлива
	    		        2128,                                  // Температура плавления (в Кельвинах)
	    		        4682,                                  // Температура кипения (в Кельвинах)
	    		        true,                                  // Требуется ли доменная печь
	    		        false,                                 // Прозрачность
	    		        2,                                     // Ценность руды
	    		        1,                                     // Множитель плотности
	    		        1,                                     // Делитель плотности
	    		        Dyes.dyeLightGray,                     // Цвет материала
	    		        Element.Zr,                            // Химический элемент (Цирконий)
	    		        Arrays.asList(                         // Thaumcraft аспекты
	    		            new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L)
	    		        )
	    		);
	    		public static ExtendedMaterials Hafnium = new ExtendedMaterials( // Hf — ядерная промышленность
	    		        206,                                   // Уникальный ID материала
	    		        TextureSet.SET_METALLIC,               // Текстура: металлическая
	    		        1.5F,                                  // Скорость инструментов
	    		        0,                                     // Прочность (по умолчанию)
	    		        3,                                     // Качество инструментов
	    		        45,                                    // Типы объектов
	    		        150,                                   // Красный компонент цвета
	    		        150,                                   // Зеленый компонент цвета
	    		        170,                                   // Синий компонент цвета
	    		        0,                                     // Прозрачность (0 = непрозрачно)
	    		        "Hafnium",                             // Внутреннее имя
	    		        "Hafnium",                             // Локализованное имя
	    		        0,                                     // Тип топлива (не является топливом)
	    		        0,                                     // Энергетическая мощность топлива
	    		        2506,                                  // Температура плавления (в Кельвинах)
	    		        4876,                                  // Температура кипения (в Кельвинах)
	    		        true,                                  // Требуется ли доменная печь
	    		        false,                                 // Прозрачность
	    		        2,                                     // Ценность руды
	    		        2,                                     // Множитель плотности
	    		        1,                                     // Делитель плотности
	    		        Dyes.dyeGray,                          // Цвет материала
	    		        Element.Hf,                            // Химический элемент (Гафний)
	    		        Arrays.asList(                         // Thaumcraft аспекты
	    		            new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4L)
	    		        )
	    		);
	    		// Arsenopyrite: FeAsS
	    		public static Materials Arsenopyrite = new Materials(
	    		        223,
	    		        TextureSet.SET_FINE,
	    		        1.5F, 0, 2, 9,
	    		        200, 200, 170, 0,
	    		        "Arsenopyrite", "Arsenopyrite",
	    		        0, 0, -1, 0,
	    		        false, false,
	    		        1, 1, 1,
	    		        Dyes._NULL,
	    		        1,
	    		        Arrays.asList(
	    		            new MaterialStack(Materials.Iron, 1L),
	    		            new MaterialStack(Materials.Arsenic, 1L),
	    		            new MaterialStack(Materials.Sulfur, 1L)
	    		        )
	    		);


	    		// Sphalerite: ZnS
	    		public static Materials SphaleriteGeIn = new Materials(
	    		        219,
	    		        TextureSet.SET_FINE,
	    		        1.0F, 0, 2, 9,
	    		        230, 215, 150, 0,
	    		        "Sphalerite Ge In", "Sphalerite Ge In",
	    		        0, 0, -1, 0,
	    		        false, false,
	    		        1, 1, 1,
	    		        Dyes._NULL,
	    		        1,
	    		        Arrays.asList(
	    		            new MaterialStack(Materials.Zinc, 1L),
	    		            new MaterialStack(Materials.Sulfur, 1L),
	    		            new MaterialStack(RareEarthGeInGa, 1L)
	    		        )
	    		);


	    		// Baddeleyite: ZrO2
	    		public static Materials Baddeleyite = new Materials(
	    		        220,
	    		        TextureSet.SET_FINE,
	    		        2.0F, 0, 2, 9,
	    		        240, 250, 255, 0,
	    		        "Baddeleyite", "Baddeleyite",
	    		        0, 0, 2950, 4300,
	    		        false, false,
	    		        1, 1, 1,
	    		        Dyes.dyeWhite,
	    		        1,
	    		        Arrays.asList(
	    		            new MaterialStack(Zirconium, 1L),
	    		            new MaterialStack(Materials.Oxygen, 2L)
	    		        )
	    		);


	    		// Thortveitite: Sc2Si2O7
	    		public static Materials Thortveitite = new Materials(
	    		        221,
	    		        TextureSet.SET_FINE,
	    		        1.8F, 0, 2, 9,
	    		        200, 200, 220, 0,
	    		        "Thortveitite", "Thortveitite",
	    		        0, 0, -1, 0,
	    		        false, false,
	    		        1, 1, 1,
	    		        Dyes._NULL,
	    		        1,
	    		        Arrays.asList(
	    		            new MaterialStack(Materials.Scandium, 2L),
	    		            new MaterialStack(Materials.Silicon, 2L),
	    		            new MaterialStack(RareEarthGdCeYDyTb, 1L),
	    		            new MaterialStack(Materials.Oxygen, 7L)
	    		        )
	    		);
	    		public static Materials Violan = new Materials(
	    			    856,                                  // Уникальный ID материала
	    			    TextureSet.SET_FINE,                  // Текстура: мелкая структура
	    			    1.0F,                                 // Скорость инструментов
	    			    0,                                    // Прочность (по умолчанию)
	    			    2,                                    // Качество инструментов
	    			    10,                                   // Типы объектов
	    			    85,                                   // Красный компонент цвета
	    			    120,                                  // Зеленый компонент цвета
	    			    190,                                  // Синий компонент цвета
	    			    0,                                    // Прозрачность (0 = непрозрачно)
	    			    "Violan",                            // Внутреннее имя
	    			    "Violan",                            // Локализованное имя
	    			    0,                                    // Тип топлива (не является топливом)
	    			    0,                                    // Энергетическая мощность топлива
	    			    1780,                                 // Температура плавления (в Кельвинах)
	    			    -1,                                   // Температура кипения (не используется)
	    			    false,                                // Требуется ли доменная печь
	    			    false,                                // Прозрачность
	    			    1,                                    // Ценность руды
	    			    1,                                    // Множитель плотности
	    			    1,                                    // Делитель плотности
	    			    Dyes.dyeBlue,                         // Цвет материала
	    			    2,                                    // Радиоактивность (0 = нет радиоактивности)
	    			    Arrays.asList(
	    			        new MaterialStack(Materials.Calcium, 1L),        // Основной компонент
	    			        new MaterialStack(Materials.Magnesium, 1L),      // Примесь магния
	    			        new MaterialStack(Materials.Silicon, 2L),        // Примесь кремния
	    			        new MaterialStack(Materials.Aluminium, 1L)        // Примесь алюминия
	    			    ),
	    			    Arrays.asList(
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.PERFODIO, 2L),
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.LUX, 1L)         // Магические аспекты для Thaumcraft
	    			    )
	    			);
	    		public static Materials BlueMarble = new Materials(
	    			    224,                                      // Уникальный ID материала 897
	    			    TextureSet.SET_ROUGH,                      // Текстура: мелкозернистая
	    			    1.0F, 0, 1, 193,                            // Инструментальные характеристики
	    			    50, 50, 200, 0,                           // Цвет (синий)
	    			    "BlueMarble", "Blue Marble",              // Имена материала
	    			    0, 0, -1, 0,                              // Параметры топлива и температуры
	    			    false, false,                             // Не требует печи, непрозрачен
	    			    1, 1, 1,                                  // Ценность и плотность
	    			    Dyes.dyeBlue,                             // Цвет красителя (синий)
	    			    2,                                        // Тип материала
	    			    Arrays.asList(                            // Состав материала
	    			        new MaterialStack(Violan, 5L),      // Голубой диопсид
	    			        new MaterialStack(Materials.Calcite, 5L)
	    			    ),
	    			    Arrays.asList(                            // Thaumcraft аспекты
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.PERFODIO, 1L)
	    			    )
	    			);
	    		

	    			public static Materials BlackMarble = new Materials(
	    			    898,
	    			    TextureSet.SET_FINE,
	    			    1.0F, 0, 1, 193,
	    			    20, 20, 20, 0,                            // Цвет (черный)
	    			    "BlackMarble", "Black Marble",
	    			    0, 0, -1, 0,
	    			    false, false,
	    			    1, 1, 1,
	    			    Dyes.dyeBlack,                            // Цвет красителя (черный)
	    			    2,
	    			    Arrays.asList(
	    			        new MaterialStack(Bitumen, 3L),       // Битум
	    			        new MaterialStack(Materials.Graphite, 2L),      // Графит
	    			        new MaterialStack(Materials.Pyrite, 1L),        // Сульфиды железа
	    			        new MaterialStack(Materials.Calcite, 4L)
	    			    ),
	    			    Arrays.asList(
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.PERFODIO, 1L)
	    			    )
	    			);

	    			public static Materials BeigeMarble = new Materials(
	    			    899,
	    			    TextureSet.SET_FINE,
	    			    1.0F, 0, 1, 193,
	    			    220, 200, 180, 0,                         // Цвет (бежевый)
	    			    "BeigeMarble", "Beige Marble",
	    			    0, 0, -1, 0,
	    			    false, false,
	    			    1, 1, 1,
	    			    Dyes.dyeBrown,                            // Цвет красителя (бежевый)
	    			    2,
	    			    Arrays.asList(
	    			        new MaterialStack(Materials.Manganese, 2L),     // Марганец
	    			        new MaterialStack(Materials.BrownLimonite, 3L),      // Лимонит
	    			        new MaterialStack(Materials.Calcite, 5L)
	    			    ),
	    			    Arrays.asList(
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.PERFODIO, 1L)
	    			    )
	    			);

	    			public static Materials RedMarble = new Materials(
	    			    967,
	    			    TextureSet.SET_FINE,
	    			    1.0F, 0, 1, 193,
	    			    200, 50, 50, 0,                           // Цвет (красный)
	    			    "RedMarble", "Red Marble",
	    			    0, 0, -1, 0,
	    			    false, false,
	    			    1, 1, 1,
	    			    Dyes.dyeRed,                              // Цвет красителя (красный)
	    			    2,
	    			    Arrays.asList(
	    			        new MaterialStack(Materials.Iron, 1L),     // Оксиды железа
	    			        new MaterialStack(Materials.Calcite, 3L)
	    			    ),
	    			    Arrays.asList(
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.PERFODIO, 1L)
	    			    )
	    			);

	    			public static Materials BrownMarble = new Materials(
	    			    968,
	    			    TextureSet.SET_FINE,
	    			    1.0F, 0, 1, 193,
	    			    150, 100, 50, 0,                          // Цвет (коричневый)
	    			    "BrownMarble", "Brown Marble",
	    			    0, 0, -1, 0,
	    			    false, false,
	    			    1, 1, 1,
	    			    Dyes.dyeBrown,                            // Цвет красителя (коричневый)
	    			    2,
	    			    Arrays.asList(
	    			        new MaterialStack(Materials.Manganese, 3L),     // Марганец
	    			        new MaterialStack(Materials.Iron, 4L),      // Карбонат железа
	    			        new MaterialStack(Materials.Calcite, 3L)
	    			    ),
	    			    Arrays.asList(
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.PERFODIO, 1L)
	    			    )
	    			);

	    			public static Materials GreenMarble = new Materials(
	    			    969,
	    			    TextureSet.SET_FINE,
	    			    1.0F, 0, 1, 193,
	    			    50, 200, 50, 0,                           // Цвет (зеленый)
	    			    "GreenMarble", "Green Marble",
	    			    0, 0, -1, 0,
	    			    false, false,
	    			    1, 1, 1,
	    			    Dyes.dyeGreen,                            // Цвет красителя (зеленый)
	    			    2,
	    			    Arrays.asList(
	    			        new MaterialStack(Materials.Chlorine, 5L),      // Хлориты
	    			        new MaterialStack(Materials.Calcite, 5L)
	    			    ),
	    			    Arrays.asList(
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.PERFODIO, 1L)
	    			    )
	    			);




	    	

	    	
	   
	    @Mod.EventHandler
	    public void preInit(FMLPreInitializationEvent event) {
	        // Код для ранней инициализации
	    	// Добавление вашего рецепта Vacuum Tube
	    	// Инициализация материалов
	    	ModBlocks.init();
	    	registerOreVeins();
	    	addMaceratorRecipes();
	    	addShapedRecipes();
	    	addVacuumTubeReceipt();
	    	addDiodeRecipe();
	    	addSMDDiodeRecipe();
	    	Materials.DeepIron.mOreReRegistrations.add(Materials.AnyIron);//глубинное железо
	    	Materials.ShadowIron.mOreReRegistrations.add(Materials.AnyIron);//глубинное железо
	    	Materials.DarkIron.mOreReRegistrations.add(Materials.AnyIron);//глубинное железо
	    	SubTag.METAL.addTo(new ISubTagContainer[] { 
	    		    SamariumCobalt, 
	    		    SamariumCobaltMagnetic, 
	    		    Rhenium,
	    		    Germanium,
	    		    Zirconium
	    		});
	    	SamariumCobaltMagnetic.setSmeltingInto(SamariumCobalt).setMaceratingInto(SamariumCobalt).setArcSmeltingInto(SamariumCobalt);
	    }

	    @Mod.EventHandler
	    public void init(FMLInitializationEvent event) {
	    	GameRegistry.registerWorldGenerator(new MarbleWorldGen(), 0);
	    	
	        // Код для добавления рецептов
	    }

	    @Mod.EventHandler
	    public void postInit(FMLPostInitializationEvent event) {
	        // Код, зависящий от других модов
	    	addSamariumCobaltDust();
	    	addPolarizerRecipesForSamariumCobalt();
	    	addCentrifugeRecipes();
	    	addCompressorRecipes();
	    	
	        //addGregTechRecipes();
	    }
	    public static void registerOreVeins() {
	    	// Жила RareEarth1
	    	GT_Worldgen_GT_Ore_Layer rareEarth1 = new GT_Worldgen_GT_Ore_Layer(
	    	        "ore.mix.rareearth1", // Имя жилы
	    	        true,                 // Использовать значение по умолчанию
	    	        10,                   // Минимальная высота
	    	        50,                   // Максимальная высота
	    	        80,                   // Вес
	    	        8,                    // Плотность
	    	        35,                   // Размер
	    	        true,                 // В верхнем мире
	    	        false,                // Не появляется в аду
	    	        false,                // Не появляется в крае
	    	        true,                 // На Луне
	    	        true,                 // На Марсе
	    	        true,                 // В астероидах
	    	        Xenotime,             // Основной материал (Ксенотим)
	    	        Rheniite,             // Вторичный материал (Рениит)
	    	        Samarskite,           // Промежуточный материал (Самарскит)
	    	        Parisite              // Случайный материал (Паризит)
	    	);


         // Жила RareEarth2
            GT_Worldgen_GT_Ore_Layer rareEarth2 = new GT_Worldgen_GT_Ore_Layer(
                    "ore.mix.rareearth2", // Имя жилы
                    true,                 // Использовать значение по умолчанию
                    10,                   // Минимальная высота
                    40,                   // Максимальная высота
                    100,                  // Вес
                    12,                   // Плотность
                    45,                   // Размер
                    true,                 // В верхнем мире
                    false,                // Не появляется в аду
                    false,                // Не появляется в крае
                    true,                 // На Луне
                    true,                 // На Марсе
                    true,                 // В астероидах
                    Corundum,             // Основной материал (Корунд)
                    Gadolinite,           // Вторичный материал (Гадолинит)
                    Euxenite,             // Промежуточный материал (Эвксенит)
                    Loparite              // Случайный материал (Лопарит)
            );

            // Жила RareEarth3
            GT_Worldgen_GT_Ore_Layer rareEarth3 = new GT_Worldgen_GT_Ore_Layer(
                    "ore.mix.rareearth3", // Имя жилы
                    true,                 // Использовать значение по умолчанию
                    10,                   // Минимальная высота
                    50,                   // Максимальная высота
                    100,                  // Вес (более сбалансированное значение)
                    15,                   // Плотность
                    40,                   // Размер жилы
                    true,                 // В верхнем мире
                    false,                // Не появляется в аду
                    false,                // Не появляется в крае
                    true,                 // На Луне
                    true,                 // На Марсе
                    true,                 // В астероидах
                    SphaleriteGeIn,       // Основной материал (наиболее распространенный)
                    Arsenopyrite,         // Вторичный материал
                    Baddeleyite,          // Третичный материал
                    Thortveitite          // Вкрапления
            );

         // Жила VolcanicDeposits
        //    GT_Worldgen_GT_Ore_Layer volcanicDeposits = new GT_Worldgen_GT_Ore_Layer(
         //           "ore.mix.volcanicdeposits", // Имя жилы
         //           true,                       // Использовать значение по умолчанию
         //           40,                         // Минимальная высота
         //           120,                        // Максимальная высота
          //          150,                        // Вес
          //          18,                         // Плотность
          //          60,                         // Размер
          //          true,                       // В верхнем мире
          //          false,                      // Не появляется в аду
          //          false,                      // Не появляется в крае
           //         false,                      // Не появляется на Луне
           //         false,                      // Не появляется на Марсе
           //         true,                       // В астероидах
           //         Materials.Alunite,                    // Основной материал (Алюнит)
            //        Materials.VolcanicAsh,                // Вторичный материал (Вулканический пепел)
            //        Materials.Pumice,                     // Промежуточный материал (Пемза)
           //         Materials.Zeolite                     // Случайный материал (Цеолит)
          //  );
         // Жила SerpentineVeins с Танталитом вместо хризотила
            GT_Worldgen_GT_Ore_Layer serpentineVeins = new GT_Worldgen_GT_Ore_Layer(
                    "ore.mix.serpentineveins", // Имя жилы
                    true,                      // Использовать значение по умолчанию
                    5,                         // Минимальная высота
                    35,                        // Максимальная высота
                    90,                        // Вес
                    10,                        // Плотность
                    30,                        // Размер
                    true,                      // В верхнем мире
                    false,                     // Не появляется в аду
                    false,                     // Не появляется в крае
                    true,                     // Не появляется на Луне
                    true,                     // Не появляется на Марсе
                    true,                     // Не появляется в астероидах
                    Materials.Chromite,        // Основной материал (Хромит)
                    Materials.Soapstone,       // Вторичный материал (Тальковый камень)
                    Materials.Magnesite,       // Промежуточный материал (Магнезит)
                    Materials.Tantalite        // Случайный материал (Танталит — редкий минерал с танталом)
            );

         // Жила EvaporiteDeposits
          //  GT_Worldgen_GT_Ore_Layer evaporiteDeposits = new GT_Worldgen_GT_Ore_Layer(
             //       "ore.mix.evaporitedeposits", // Имя жилы
             //       true,                        // Использовать значение по умолчанию
             //       50,                          // Минимальная высота
              //      90,                          // Максимальная высота
              //      180,                         // Вес
              //      25,                          // Плотность
              //      80,                          // Размер
              //      true,                        // В верхнем мире
             //       false,                       // Не появляется в аду
             //       false,                       // Не появляется в крае
              //      false,                       // Не появляется на Луне
             //       false,                       // Не появляется на Марсе
              //      true,                        // В астероидах
                    
             //       Materials.Gypsum,                      // Основной материал (Гипс)
             //       Materials.RockSalt,                    // Вторичный материал (Каменная соль)
             //       Materials.RockSalt,                        // Промежуточный материал (не требуется)
             //       Materials.RockSalt                       // Случайный материал (не требуется)
          //  );
         // Жила MineralClayDeposits
        //    GT_Worldgen_GT_Ore_Layer mineralClayDeposits = new GT_Worldgen_GT_Ore_Layer(
             //       "ore.mix.mineralclaydeposits", // Имя жилы
            //        true,                          // Использовать значение по умолчанию
            //        60,                            // Минимальная высота
             //       120,                           // Максимальная высота
             //       100,                           // Вес
             //       15,                            // Плотность
             //       50,                            // Размер
             //       true,                          // В верхнем мире
            //        false,                         // Не появляется в аду
            //        false,                         // Не появляется в крае
           //         false,                         // Не появляется на Луне
           //         false,                         // Не появляется на Марсе
           //         false,                         // Не появляется в астероидах
            //        Materials.FullersEarth,                  // Основной материал (Fuller's Earth)
          //          Materials.Bentonite,                     // Вторичный материал (Bentonite)
          //          Materials.Kaolinite,                     // Промежуточный материал (Kaolinite)
         //           Materials.Kaolinite                           // Случайный материал (не требуется)
         //   );
            //Жилы мрамора
            new GT_Worldgen_Stone("overworld.stone.blueMarble.tiny", true, GregTech_API.sBlockStones, 0, 0, 1, 50, 48, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.blueMarble.small", true, GregTech_API.sBlockStones, 0, 0, 1, 100, 96, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.blueMarble.medium", true, GregTech_API.sBlockStones, 0, 0, 1, 200, 144, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.blueMarble.large", true, GregTech_API.sBlockStones, 0, 0, 1, 300, 192, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.blueMarble.huge", true, GregTech_API.sBlockStones, 0, 0, 1, 400, 240, 0, 120, null, false);

            new GT_Worldgen_Stone("overworld.stone.blackMarble.tiny", true, GregTech_API.sBlockStones, 0, 0, 1, 50, 48, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.blackMarble.small", true, GregTech_API.sBlockStones, 0, 0, 1, 100, 96, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.blackMarble.medium", true, GregTech_API.sBlockStones, 0, 0, 1, 200, 144, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.blackMarble.large", true, GregTech_API.sBlockStones, 0, 0, 1, 300, 192, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.blackMarble.huge", true, GregTech_API.sBlockStones, 0, 0, 1, 400, 240, 0, 120, null, false);

            new GT_Worldgen_Stone("overworld.stone.beigeMarble.tiny", true, GregTech_API.sBlockStones, 0, 0, 1, 50, 48, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.beigeMarble.small", true, GregTech_API.sBlockStones, 0, 0, 1, 100, 96, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.beigeMarble.medium", true, GregTech_API.sBlockStones, 0, 0, 1, 200, 144, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.beigeMarble.large", true, GregTech_API.sBlockStones, 0, 0, 1, 300, 192, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.beigeMarble.huge", true, GregTech_API.sBlockStones, 0, 0, 1, 400, 240, 0, 120, null, false);

            new GT_Worldgen_Stone("overworld.stone.redMarble.tiny", true, GregTech_API.sBlockStones, 0, 0, 1, 50, 48, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.redMarble.small", true, GregTech_API.sBlockStones, 0, 0, 1, 100, 96, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.redMarble.medium", true, GregTech_API.sBlockStones, 0, 0, 1, 200, 144, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.redMarble.large", true, GregTech_API.sBlockStones, 0, 0, 1, 300, 192, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.redMarble.huge", true, GregTech_API.sBlockStones, 0, 0, 1, 400, 240, 0, 120, null, false);

            new GT_Worldgen_Stone("overworld.stone.brownMarble.tiny", true, GregTech_API.sBlockStones, 0, 0, 1, 50, 48, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.brownMarble.small", true, GregTech_API.sBlockStones, 0, 0, 1, 100, 96, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.brownMarble.medium", true, GregTech_API.sBlockStones, 0, 0, 1, 200, 144, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.brownMarble.large", true, GregTech_API.sBlockStones, 0, 0, 1, 300, 192, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.brownMarble.huge", true, GregTech_API.sBlockStones, 0, 0, 1, 400, 240, 0, 120, null, false);

            new GT_Worldgen_Stone("overworld.stone.greenMarble.tiny", true, GregTech_API.sBlockStones, 0, 0, 1, 50, 48, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.greenMarble.small", true, GregTech_API.sBlockStones, 0, 0, 1, 100, 96, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.greenMarble.medium", true, GregTech_API.sBlockStones, 0, 0, 1, 200, 144, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.greenMarble.large", true, GregTech_API.sBlockStones, 0, 0, 1, 300, 192, 0, 120, null, false);
            new GT_Worldgen_Stone("overworld.stone.greenMarble.huge", true, GregTech_API.sBlockStones, 0, 0, 1, 400, 240, 0, 120, null, false);





	        
	        Rheniite.addOreByProducts(Materials.Molybdenum, Materials.Sulfur, Materials.Iron);
	        Corundum.addOreByProducts(Materials.Aluminium, Materials.Titanium, Materials.Iron);
	        Xenotime.addOreByProducts(Materials.Europium, RareEarthDyErHoTmYtLu, RareEarthEuScZr);
	        Samarskite.addOreByProducts(RareEarthDySmEuGd, Materials.Tantalum, Materials.Niobium);//+Yt&Tm
	        Parisite.addOreByProducts(Materials.RareEarth, Materials.Praseodymium, Materials.Samarium);
	        Gadolinite.addOreByProducts(Materials.Beryllium, RareEarthGdCeYDyTb, Materials.Silicon);//RareEarthGdCeYDyTb
	        Euxenite.addOreByProducts(RareEarthGdCeYDyTb, Materials.Niobium, Materials.Tantalum);
	        Loparite.addOreByProducts(Materials.RareEarth, RareEarthDySmEuGd, Materials.Calcium);
    		Arsenopyrite.addOreByProducts(Materials.Gold, Materials.Cobalt, Materials.Nickel);
    		SphaleriteGeIn.addOreByProducts(Materials.Cadmium, RareEarthGeInGa,Materials.Gallium);
    		Baddeleyite.addOreByProducts(Hafnium, Materials.Titanium,Materials.Iron );
    		Thortveitite.addOreByProducts(Materials.Scandium, RareEarthGdCeYDyTb, Zirconium);
    		BlueMarble.addOreByProducts(new Materials[] { Materials.Calcite });
    		BlackMarble.addOreByProducts(new Materials[] { Materials.Calcite });
    		BeigeMarble.addOreByProducts(new Materials[] { Materials.Calcite });
    		RedMarble.addOreByProducts(new Materials[] { Materials.Calcite });
    		//PinkMarble.addOreByProducts(new Materials[] { Materials.Calcite });
    		BrownMarble.addOreByProducts(new Materials[] { Materials.Calcite });
    		GreenMarble.addOreByProducts(new Materials[] { Materials.Calcite });
    		
    		BlueMarble.add(new SubTag[] { SubTag.STONE, SubTag.NO_SMASHING });
    		BlackMarble.add(new SubTag[] { SubTag.STONE, SubTag.NO_SMASHING });
    		BeigeMarble.add(new SubTag[] { SubTag.STONE, SubTag.NO_SMASHING });
    		RedMarble.add(new SubTag[] { SubTag.STONE, SubTag.NO_SMASHING });
    		BrownMarble.add(new SubTag[] { SubTag.STONE, SubTag.NO_SMASHING });
    		GreenMarble.add(new SubTag[] { SubTag.STONE, SubTag.NO_SMASHING });
    		OrePrefixes.ore.mNotGeneratedItems.add(BlueMarble);
    		OrePrefixes.ore.mGeneratedItems.add(BlueMarble);
    		OrePrefixes.block.mNotGeneratedItems.add(BlueMarble);
    		OrePrefixes.stair.mNotGeneratedItems.add(BlueMarble);
    		//block.mNotGeneratedItems.add(Materials.Lapis);

	        
           // GregTech_API.sWorldgenList.add(rareEarth1);
          //  GregTech_API.sWorldgenList.add(rareEarth2);

	    }

        public static void addCentrifugeRecipes()
        {
        	GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes.addRecipe(
        		    true, // Активировать рецепт
        		    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, RareEarthDyErHoTmYtLu, 1) }, // Входящий материал (пыль)
        		    new ItemStack[] { 
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Dysprosium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Erbium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Holmium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thulium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ytterbium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lutetium, 1)
        		    }, // Выходящие материалы
        		    null, // Нет дополнительных предметов
        		    new FluidStack[] {}, // Нет жидкостей на входе
        		    null, // Нет жидкостей на выходе
        		    500, // Длительность: 500 тиков
        		    120 // Энергопотребление: 120 EU/t
, 0
        		);
        	GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes.addRecipe(
        		    true, // Активировать рецепт
        		    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, RareEarthDySmEuGd, 1) }, // Входящий материал (пыль)
        		    new ItemStack[] { 
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Dysprosium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Europium, 2),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Samarium, 2),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gadolinium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Praseodymium, 1)
        		    }, // Выходящие материалы
        		    null, // Нет дополнительных предметов
        		    new FluidStack[] {}, // Нет жидкостей на входе
        		    null, // Нет жидкостей на выходе
        		    500, // Длительность: 500 тиков
        		    120 // Энергопотребление: 120 EU/t
, 0
        		);
        	//RareEarthGdCeYDyTb
        	GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes.addRecipe(
        		    true, // Активировать рецепт
        		    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, RareEarthGdCeYDyTb, 1) }, // Входящий материал (пыль)
        		    new ItemStack[] { 
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Cerium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Yttrium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Dysprosium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gadolinium, 2),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Terbium, 1)
        		    }, // Выходящие материалы
        		    null, // Нет дополнительных предметов
        		    new FluidStack[] {}, // Нет жидкостей на входе
        		    null, // Нет жидкостей на выходе
        		    500, // Длительность: 500 тиков
        		    120 // Энергопотребление: 120 EU/t
, 0
        		);
        	//RareEarthGeInGa
        	GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes.addRecipe(
        		    true, // Активировать рецепт
        		    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, RareEarthGeInGa, 1) }, // Входящий материал (пыль)
        		    new ItemStack[] { 
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Germanium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Indium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gallium, 1),

        		    }, // Выходящие материалы
        		    null, // Нет дополнительных предметов
        		    new FluidStack[] {}, // Нет жидкостей на входе
        		    null, // Нет жидкостей на выходе
        		    500, // Длительность: 500 тиков
        		    120 // Энергопотребление: 120 EU/t
, 0
        		);
        }
	    private void addGregTechRecipes() {
	        // Добавление рецептов (код будет ниже)
	    }
	    private static void addMaceratorRecipes() {
	    	  // Массив блоков мрамора и соответствующих им пылей
	        Object[][] marbleData = {
	            {ModBlocks.blueMarble, OrePrefixes.dust, "BlueMarble"},
	            {ModBlocks.blackMarble, OrePrefixes.dust, "BlackMarble"},
	            {ModBlocks.beigeMarble, OrePrefixes.dust, "BeigeMarble"},
	            {ModBlocks.redMarble, OrePrefixes.dust, "RedMarble"},
	            {ModBlocks.brownMarble, OrePrefixes.dust, "BrownMarble"},
	            {ModBlocks.greenMarble, OrePrefixes.dust, "GreenMarble"}
	        };

	        // Цикл для добавления рецептов
	        for (Object[] entry : marbleData) {
	            ItemStack input = new ItemStack((Block) entry[0]); // Блок мрамора
	            ItemStack output = GT_OreDictUnificator.get((OrePrefixes) entry[1], entry[2], 1L); // Пыль

	            // Добавление рецепта в дробитель
	            GT_Recipe.GT_Recipe_Map.sMaceratorRecipes.addRecipe(
	                true,                        // Активен ли рецепт
	                new ItemStack[]{input},      // Входной материал
	                new ItemStack[]{output},     // Выходной материал
	                null,                        // Дополнительные материалы
	                null,                        // Дополнительные выходы
	                null,                        // Жидкости, требуемые для рецепта
	                null,                        // Жидкости, производимые рецептом
	                200,                         // Время обработки (тик)
	                2,                           // Энергопотребление (EU/t)
	                0                            // Специальный параметр (обычно не используется)
	            );
	        }
	    }
	    private static void addCompressorRecipes() {
	        // Данные о пыли и соответствующих блоках мрамора
	        Object[][] marbleData = {
	            {OrePrefixes.dust, "BlueMarble", ModBlocks.blueMarble},
	            {OrePrefixes.dust, "BlackMarble", ModBlocks.blackMarble},
	            {OrePrefixes.dust, "BeigeMarble", ModBlocks.beigeMarble},
	            {OrePrefixes.dust, "RedMarble", ModBlocks.redMarble},
	            {OrePrefixes.dust, "BrownMarble", ModBlocks.brownMarble},
	            {OrePrefixes.dust, "GreenMarble", ModBlocks.greenMarble}
	        };

	        // Цикл добавления рецептов
	        for (Object[] entry : marbleData) {
	            ItemStack input = GT_OreDictUnificator.get((OrePrefixes) entry[0], entry[1], 1L); // 1
	            ItemStack output = new ItemStack((Block) entry[2]); // Блок мрамора

	            // Добавление рецепта
	            GT_Recipe.GT_Recipe_Map.sCompressorRecipes.addRecipe(
	                true,                        // Активен ли рецепт
	                new ItemStack[]{input},      // Входной материал
	                new ItemStack[]{output},     // Выходной материал
	                null,                        // Дополнительные материалы
	                null,                        // Дополнительные выходы
	                null,                        // Жидкости, требуемые для рецепта
	                null,                        // Жидкости, производимые рецептом
	                200,                         // Время обработки (тик)
	                2,                           // Энергопотребление (EU/t)
	                0                            // Специальный параметр (обычно не используется)
	            );
	        }
	    }

	    private void addShapedRecipes() {
	    	 GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[] { 
	 	            "CWR", "WIW", "RWC", Character.valueOf('I'), OrePrefixes.stick.get(SamariumCobaltMagnetic), Character.valueOf('R'), OrePrefixes.stick.get(Materials.Titanium), Character.valueOf('W'), OrePrefixes.wireGt08.get(Materials.AnnealedCopper), Character.valueOf('C'), 
	 	            OrePrefixes.cableGt01.get(Materials.Aluminium) });
	 	      GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[] { 
	 	            "CWR", "WIW", "RWC", Character.valueOf('I'), OrePrefixes.stick.get(SamariumCobaltMagnetic), Character.valueOf('R'), OrePrefixes.stick.get(Materials.TungstenSteel), Character.valueOf('W'), OrePrefixes.wireGt16.get(Materials.AnnealedCopper), Character.valueOf('C'), 
	 	            OrePrefixes.cableGt01.get(Materials.Tungsten) });
	    }
	   
	    public static void addDiodeRecipe() {
	    	GT_Values.RA.addAssemblerRecipe(
		    	    new ItemStack[]{
		    	        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gallium, 1L), //
		    	        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4L), // 
		    	        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Caesium, 1L), // 1 фольгa из цезия
		    	    },
		    	    Materials.Plastic.getMolten(288), // 288 мБ жидкой меди (2 слитка)
		    	    ItemList.Circuit_Parts_Diode.get(32L, new Object[0]), // На выходе 4 лампы
		    	    400, // Время изготовления: 400 тиков (20 секунд)
		    	    48  // Потребление энергии: 48 EU/t
		    	);
	    }
	    public static void addSMDDiodeRecipe() {
	    	GT_Values.RA.addAssemblerRecipe(
		    	    new ItemStack[]{
		    	        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gallium, 1L), //
		    	        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 4L), // 
		    	        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Caesium, 1L), // 1 фольгa из цезия
		    	    },
		    	    Materials.Plastic.getMolten(288), // 288 мБ жидкой меди (2 слитка)
		    	    ItemList.Circuit_Parts_DiodeSMD.get(64L, new Object[0]), // На выходе 4 лампы
		    	    400, // Время изготовления: 400 тиков (20 секунд)
		    	    120  // Потребление энергии: 48 EU/t
		    	);
	    }
	  
	    public static void addSamariumCobaltDust() 
	    {
	    
	    	   // Определяем выходной предмет
	        ItemStack samariumCobaltDust = GT_OreDictUnificator.get(OrePrefixes.dust, SamariumCobalt, 5L);

	        // Добавляем shapeless рецепт через GT_ModHandler
	        GT_ModHandler.addShapelessCraftingRecipe(
	            samariumCobaltDust, // Выходной предмет
	            GT_ModHandler.RecipeBits.NOT_REMOVABLE, // Флаги (например, рецепт нельзя удалить)
	            new Object[]{
	                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Samarium, 1L), // 1x пыль самария
	                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L) ,  // 4x пыль кобальта
	                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L) ,  // 4x пыль кобальта
	                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L) ,  // 4x пыль кобальта
	                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L)   // 4x пыль кобальта
	            }
	        );
	    }
	    
	
	 
	    public void addPolarizerRecipesForSamariumCobalt() {
	        // Префиксы для входных и выходных материалов
	        OrePrefixes[] prefixes = {
	            OrePrefixes.dust,
	            OrePrefixes.stick,
	            OrePrefixes.plate,
	            OrePrefixes.nugget,
	            OrePrefixes.ingot
	        };

	        // Цикл по каждому префиксу
	        for (OrePrefixes prefix : prefixes) {
	            // Входной материал
	            ItemStack input = GT_OreDictUnificator.get(prefix, SamariumCobalt, 1L);

	            // Выходной материал
	            ItemStack output = GT_OreDictUnificator.get(prefix, SamariumCobaltMagnetic, 1L);

	            // Добавление рецепта
	            if (input != null && output != null) {
	                GT_Recipe.GT_Recipe_Map.sPolarizerRecipes.addRecipe(
	                    true,                          // Разрешение добавления
	                    new ItemStack[] { input },     // Входной предмет
	                    new ItemStack[] { output },    // Выходной предмет
	                    null,                          // Нет дополнительных входов/выходов
	                    null,                          // Нет жидкости
	                    null,                          // Нет дополнительных данных
	                    16,                            // Длительность: 16 тиков
	                    256,                           // Потребление энергии: 256 EU/t
	                    0                              // Дополнительные параметры: не используются
	                );
	            } else {
	                System.err.println("Failed to add Polarizer recipe for " + prefix.name() + ": Input or output is null.");
	            }
	        }
	    }


	    public static void addVacuumTubeReceipt() {
	    GT_Values.RA.addAssemblerRecipe(
	    	    new ItemStack[]{
	    	        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Caesium, 1L), // 2 фольги из цезия
	    	        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L), // 2 фольги из меди
	    	        //GT_OreDictUnificator.get(ItemList.Circuit_Parts_Glass_Tube, 1L),   // 1 стеклянная трубка
	    	        ItemList.Circuit_Parts_Glass_Tube.get(4L, new Object[0])
	    	    },
	    	    null, // Если катализатор не требуется, передаем null
	    	    ItemList.Circuit_Parts_Vacuum_Tube.get(4L, new Object[0]), // На выходе 4 лампы
	    	    200, // Время изготовления: 200 тиков (10 секунд)
	    	    12  // Потребление энергии: 32 EU/t
	    	    //ItemList.Circuit_Parts_Vacuum_Tube.get(4L, new Object[0]), // На выходе 4 лампы
	    	);
	    }
	  
	   
	        
	        //Neodymium.addOreByProducts(new Materials[] { Monazite, RareEarth });
	        static void addAsphaltRecipe() {
	        GT_ModHandler.addCraftingRecipe(
	        	    //new ItemStack(ModItems.asphalt, 1), // Результат: 1 единица асфальта
	        		ItemList.Circuit_Parts_Vacuum_Tube.get(4L, new Object[0]), // На выходе 4 лампы
	        	    GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
	        	    new Object[] {
	        	        "BB ",
	        	        "AA ",
	        	        "BB ",
	        	        Character.valueOf('B'), GT_OreDictUnificator.get(OrePrefixes.dust, Bitumen, 1L) // Символ 'C' для цезиевого слитка
	        	        //Character.valueOf('B'), new ItemStack(OreDictionary.getOres("dustBitumen").get(0)) // Используем битум из OreDict
	        	        //Character.valueOf('B'), new ItemStack(OreDictionary.doesOreNameExist("dustBitumen"))
	        	    }
	        	);
	      //  GT//_Values.RA.addAssemblerRecipe(
	        	  //  new ItemStack[]{
	        	   //     new ItemStack(Metallurgy, 2), // 2 битума из Metallurgy 4
	        	 //       new ItemStack(Blocks.GRAVEL, 4),          // 4 гравия
	        	 //       new ItemStack(Blocks.SAND, 2)            // 2 песка
	        	  //  },
	        	  //  Materials.Water.getFluid(1000), // 1000 мБ воды
	        	  //  new ItemStack(ChiselBlocks.ASPHALT, 8), // 8 блоков асфальта
	        	  //  400, // Время: 400 тиков (20 секунд)
	        	 //   50   // Энергия: 50 EU/t
	        	//);
	    };


}
