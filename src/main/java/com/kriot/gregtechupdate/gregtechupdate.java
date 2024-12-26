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
	    public static ExtendedMaterials Rhenium = new ExtendedMaterials(//ReMoW- �������� ���������
	            204,                                   // ���������� ID ���������
	            TextureSet.SET_METALLIC,               // ��������: �������������
	            2.0F,                                  // �������� ������������
	            0,                                     // ��������� (�� ���������)
	            3,                                     // �������� ������������
	            50,                                    // ���� ��������
	            70,                                    // ������� ��������� �����
	            70,                                    // ������� ��������� �����
	            90,                                    // ����� ��������� �����
	            0,                                     // ������������ (0 = �����������)
	            "Rhenium",                             // ���������� ���
	            "Rhenium",                             // �������������� ���
	            0,                                     // ��� ������� (�� �������� ��������)
	            0,                                     // �������������� �������� �������
	            3459,                                  // ����������� ��������� (� ���������)
	            5900,                                  // ����������� ������� (� ���������)
	            true,                                  // ��������� �� �������� ����
	            false,                                 // ������������
	            2,                                     // �������� ����
	            1,                                     // ��������� ���������
	            1,                                     // �������� ���������
	            Dyes.dyeGray,                          // ���� ���������
	            Element.Re,                            // ���������� ������� (�����)
	            Arrays.asList(                         // Thaumcraft �������
	                new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4L),
	                new TC_Aspects.TC_AspectStack(TC_Aspects.LUX, 1L)
	            )
	    );

	    


	    
	    public static Materials Bitumen = new Materials(
	    	    200,                                    // ���������� ID ���������
	    	    TextureSet.SET_DULL,                   // ����� �������
	    	    1.5F,                                   // �������� ������������
	    	    0,                                      // ���������
	    	    1,                                      // ���������
	    	    50,                                     // ���������
	    	    50,                                     // �������� ������������
	    	    50,                                     // ���� ��������
	    	    50,                                     // ��������� ������������
	    	    0,                                      // �����
	    	    "Bitumen",                              // �������������� ���
	    	    "Bitumen",                              // ��� ���������
	    	    0,                                      // ��������� �����
	    	    0,                                      // ��������
	    	    120,                                    // ����������� ��������� (� ���������)
	    	    0,                                      // ����������� �������
	    	    false,                                  // ����� �� ���� ���������
	    	    false,                                  // ����� �� ���� �������������
	    	    2,                                      // ������� ������
	    	    1,                                      // ������� �������������
	    	    1,                                      // ��������� ���������
	    	    Dyes.dyeBlack,                          // ���� ���������
	    	    Element.C,                              // ���������� ������� (�������)
	    	    Arrays.asList(                          // ������� ��� Thaumcraft
	    	        new TC_Aspects.TC_AspectStack(TC_Aspects.TERRA, 2L), 
	    	        new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 1L)
	    	    )
	    	);

	    	public static Materials SamariumCobalt = new Materials(
	    	    202,                                   // ���������� ID ���������
	    	    TextureSet.SET_METALLIC,               // ��������: �������������
	    	    2.0F,                                  // �������� ������������
	    	    256,                                   // ���������
	    	    3,                                     // �������� ������������
	    	    235,                                   // ���� �������� (��� ����)
	    	    100,                                   // ������� ��������� �����
	    	    130,                                   // ������� ��������� �����
	    	    160,                                   // ����� ��������� �����
	    	    0,                                     // ������������ (0 = �����������)
	    	    "SamariumCobaltAlloy",                  // ���������� ���
	    	    "Samarium Cobalt Alloy",                // �������������� ���
	    	    0,                                     // ��� ������� (�� �������� ��������)
	    	    0,                                     // �������������� �������� �������
	    	    1450,                                  // ����������� ��������� (��������)
	    	    1800,                                  // ����������� ��������� � �������� ����
	    	    true,                                  // ��������� �� �������� ����
	    	    false,                                 // ������������ (������������)
	    	    4,                                     // �������� ����
	    	    1,                                     // ��������� ���������
	    	    1,                                     // �������� ���������
	    	    Dyes.dyeBlue,                          // ���� (�� ������ ����-������ �������)
	    	    0,                                     // �������������� ������
	    	    Arrays.asList(                         // ��������� ��������
	    	        new MaterialStack(Materials.Samarium, 1L), // 1 ����� �������
	    	        new MaterialStack(Materials.Cobalt, 4L)   // 4 ����� ��������
	    	    ),
	    	    Arrays.asList(                         // Thaumcraft �������
	    	        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L),
	    	        new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 2L)
	    	    )
	    	);
	    	public static Materials SamariumCobaltMagnetic = new Materials(
		    	    201,                                   // ���������� ID ���������
		    	    TextureSet.SET_MAGNETIC,               // ��������: ���������
		    	    4.0F,                                  // �������� ������������
		    	    512,                                   // ���������
		    	    3,                                     // �������� ������������
		    	    195,                                   // ���� ��������
		    	    100,                                   // ������� ��������� �����
		    	    130,                                   // ������� ��������� �����
		    	    160,                                   // ����� ��������� �����
		    	    0,                                     // ������������
		    	    "SamariumCobaltMagneticAlloy",          // ���������� ���
		    	    "Samarium-Cobalt Magnetic Alloy",       // �������������� ���
		    	    0,                                     // ��� �������
		    	    0,                                     // �������������� ��������
		    	    1450,                                  // ����������� ���������
		    	    1800,                                  // ����������� ��������� � �������� ����
		    	    true,                                  // ��������� �� �������� ����
		    	    false,                                 // ������������
		    	    4,                                     // �������� ����
		    	    51,                                    // ��������� ���������
		    	    50,                                    // �������� ���������
		    	    Dyes.dyeBlue,                          // ����
		    	    1,                                     // �������������� ������
		    	    Arrays.asList(                         // ��������� ��������
		    	        new MaterialStack(Materials.Samarium, 1L),
		    	        new MaterialStack(Materials.Cobalt, 4L)
		    	    ),
		    	    Arrays.asList(                         // Thaumcraft �������
		    	        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L),
		    	        new TC_Aspects.TC_AspectStack(TC_Aspects.MAGNETO, 3L)
		    	    )
		    	);
	    	public static Materials Germanium = new Materials(// Ge - ��������������, �����������
	                218,                                   // ���������� ID ���������
	                TextureSet.SET_METALLIC,               // ��������: �������������
	                1.0F,                                  // �������� ������������ (������� ����, ��� ��� �������� - ����������)
	                0,                                     // ��������� (�� ���������)
	                3,                                     // �������� ������������
	                50,                                    // ���� ��������
	                50,                                    // ������� ��������� �����
	                50,                                    // ������� ��������� �����
	                50,                                    // ����� ��������� �����
	                0,                                     // ������������ (0 = �����������)
	                "Germanium",                           // ���������� ���
	                "Germanium",                           // �������������� ���
	                0,                                     // ��� ������� (�� �������� ��������)
	                0,                                     // �������������� �������� �������
	                1211,                                  // ����������� ��������� (� ���������)
	                2833,                                  // ����������� ������� (� ���������)
	                true,                                  // ��������� �� �������� ����
	                false,                                 // ������������
	                3,                                     // �������� ���� (��������, ��� �������� ���������� � �������� �����������)
	                5,                                     // ��������� ��������� (��� �������� ������������ ����� �������)
	                2,                                     // �������� ���������
	                Dyes.dyeGray,                          // ���� ���������
	                Element.Ge,                            // ���������� ������� (��������)
	                Arrays.asList(                         // Thaumcraft �������
	                    new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L),
	                    new TC_Aspects.TC_AspectStack(TC_Aspects.LUX, 2L),
	                    new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1L)  // �������� ������������ � �����������, �������� ������ Vitreus
	                )
	        );

	    	public static Materials RareEarthDyErHoTmYtLu = new Materials(
    			    214,                                   // ���������� ID ���������
    			    TextureSet.SET_FINE,                  // ��������: ������ ���������
    			    1.0F,                                 // �������� ������������
    			    0,                                    // ��������� (�� ���������)
    			    0,                                    // �������� ������������
    			    1,                                    // ���� ��������
    			    128,                                  // ������� ��������� �����
    			    100,                                  // ������� ��������� �����
    			    150,                                  // ����� ��������� �����
    			    0,                                    // ������������ (0 = �����������)
    			    "RareEarthDyErHoTmYtLu",            // ���������� ���
    			    "Rare Earth Dy Er Ho Tm Yt Lu",     // �������������� ���
    			    0,                                    // ��� ������� (�� �������� ��������)
    			    0,                                    // �������������� �������� �������
    			    -1,                                   // ����������� ��������� (�� ��������)
    			    0,                                    // ����������� ������� (�� �����)
    			    false,                                // ��������� �� �������� ����
    			    false,                                // ������������
    			    1,                                    // �������� ����
    			    1,                                    // ��������� ���������
    			    1,                                    // �������� ���������
    			    Dyes.dyeGray,                         // ���� ���������
    			    Arrays.asList(                        // Thaumcraft �������
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 2L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 1L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L)
    			    )
    			);
	    	public static Materials RareEarthDySmEuGd = new Materials(
	    		    215, // ���������� ID ���������
	    		    TextureSet.SET_FINE, // ��������: ������
	    		    1.0F, // �������� ������������
	    		    0, // ��������� (�� ���������)
	    		    0, // �������� ������������
	    		    1, // ���� ��������
	    		    130, // ������� ��������� �����
	    		    130, // ������� ��������� �����
	    		    110, // ����� ��������� �����
	    		    0, // ������������ (0 = �����������)
	    		    "RareEarthDySmEuGd", // ���������� ���
	    		    "Rare Earth Dy Sm Eu Gd", // �������������� ���
	    		    0, // ��� ������� (�� �������� ��������)
	    		    0, // �������������� �������� �������
	    		    -1, // ����������� ��������� (�� ��������)
	    		    0, // ����������� ������� (�� �����)
	    		    false, // �� ������� �������� ����
	    		    false, // ������������
	    		    1, // �������� ����
	    		    1, // ��������� ���������
	    		    1, // �������� ���������
	    		    Dyes.dyeGray, // ���� ���������
	    		    Arrays.asList( // Thaumcraft �������
	    		        new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1L),
	    		        new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 1L)
	    		    )
	    		);
	    	public static Materials RareEarthGdCeYDyTb = new Materials(
    			    216,                                   // ���������� ID ���������
    			    TextureSet.SET_FINE,                  // ��������: ������ ���������
    			    1.0F,                                 // �������� ������������
    			    0,                                    // ��������� (�� ���������)
    			    0,                                    // �������� ������������
    			    1,                                    // ���� ��������
    			    128,                                  // ������� ��������� �����
    			    100,                                  // ������� ��������� �����
    			    130,                                  // ����� ��������� �����
    			    0,                                    // ������������ (0 = �����������)
    			    "RareEarthGdCeYDyTb",            // ���������� ���
    			    "Rare Earth Gd Ce Y Dy Tb",     // �������������� ���
    			    0,                                    // ��� ������� (�� �������� ��������)
    			    0,                                    // �������������� �������� �������
    			    -1,                                   // ����������� ��������� (�� ��������)
    			    0,                                    // ����������� ������� (�� �����)
    			    false,                                // ��������� �� �������� ����
    			    false,                                // ������������
    			    1,                                    // �������� ����
    			    1,                                    // ��������� ���������
    			    1,                                    // �������� ���������
    			    Dyes.dyeGray,                         // ���� ���������
    			    Arrays.asList(                        // Thaumcraft �������
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 2L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 1L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L)
    			    )
    			);
	    	//RareEarthEuScZr
	    	public static Materials RareEarthEuScZr = new Materials(
    			    217,                                   // ���������� ID ���������
    			    TextureSet.SET_FINE,                  // ��������: ������ ���������
    			    1.0F,                                 // �������� ������������
    			    0,                                    // ��������� (�� ���������)
    			    0,                                    // �������� ������������
    			    1,                                    // ���� ��������
    			    128,                                  // ������� ��������� �����
    			    110,                                  // ������� ��������� �����
    			    130,                                  // ����� ��������� �����
    			    0,                                    // ������������ (0 = �����������)
    			    "RareEarthEuScZr",            // ���������� ���
    			    "Rare Earth Eu Sc Zr",     // �������������� ���
    			    0,                                    // ��� ������� (�� �������� ��������)
    			    0,                                    // �������������� �������� �������
    			    -1,                                   // ����������� ��������� (�� ��������)
    			    0,                                    // ����������� ������� (�� �����)
    			    false,                                // ��������� �� �������� ����
    			    false,                                // ������������
    			    1,                                    // �������� ����
    			    1,                                    // ��������� ���������
    			    1,                                    // �������� ���������
    			    Dyes.dyeGray,                         // ���� ���������
    			    Arrays.asList(                        // Thaumcraft �������
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 2L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 1L),
    			        new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L)
    			    )
    			);
	    	//RareEarthEuScZr
	    	public static Materials RareEarthGeInGa = new Materials(
    			    222,                                   // ���������� ID ���������
    			    TextureSet.SET_FINE,                  // ��������: ������ ���������
    			    1.0F,                                 // �������� ������������
    			    0,                                    // ��������� (�� ���������)
    			    0,                                    // �������� ������������
    			    1,                                    // ���� ��������
    			    128,                                  // ������� ��������� �����
    			    110,                                  // ������� ��������� �����
    			    140,                                  // ����� ��������� �����
    			    0,                                    // ������������ (0 = �����������)
    			    "RareEarthGeInGa",            // ���������� ���
    			    "Rare Earth Ge In Ga",     // �������������� ���
    			    0,                                    // ��� ������� (�� �������� ��������)
    			    0,                                    // �������������� �������� �������
    			    -1,                                   // ����������� ��������� (�� ��������)
    			    0,                                    // ����������� ������� (�� �����)
    			    false,                                // ��������� �� �������� ����
    			    false,                                // ������������
    			    1,                                    // �������� ����
    			    1,                                    // ��������� ���������
    			    1,                                    // �������� ���������
    			    Dyes.dyeGray,                         // ���� ���������
    			    Arrays.asList(                        // Thaumcraft �������
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
	    		public static ExtendedMaterials Zirconium = new ExtendedMaterials( // Zr � ������� ��������������
	    		        205,                                   // ���������� ID ���������
	    		        TextureSet.SET_METALLIC,               // ��������: �������������
	    		        1.5F,                                  // �������� ������������
	    		        0,                                     // ��������� (�� ���������)
	    		        2,                                     // �������� ������������
	    		        40,                                    // ���� ��������
	    		        180,                                   // ������� ��������� �����
	    		        180,                                   // ������� ��������� �����
	    		        200,                                   // ����� ��������� �����
	    		        0,                                     // ������������ (0 = �����������)
	    		        "Zirconium",                           // ���������� ���
	    		        "Zirconium",                           // �������������� ���
	    		        0,                                     // ��� ������� (�� �������� ��������)
	    		        0,                                     // �������������� �������� �������
	    		        2128,                                  // ����������� ��������� (� ���������)
	    		        4682,                                  // ����������� ������� (� ���������)
	    		        true,                                  // ��������� �� �������� ����
	    		        false,                                 // ������������
	    		        2,                                     // �������� ����
	    		        1,                                     // ��������� ���������
	    		        1,                                     // �������� ���������
	    		        Dyes.dyeLightGray,                     // ���� ���������
	    		        Element.Zr,                            // ���������� ������� (��������)
	    		        Arrays.asList(                         // Thaumcraft �������
	    		            new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3L)
	    		        )
	    		);
	    		public static ExtendedMaterials Hafnium = new ExtendedMaterials( // Hf � ������� ��������������
	    		        206,                                   // ���������� ID ���������
	    		        TextureSet.SET_METALLIC,               // ��������: �������������
	    		        1.5F,                                  // �������� ������������
	    		        0,                                     // ��������� (�� ���������)
	    		        3,                                     // �������� ������������
	    		        45,                                    // ���� ��������
	    		        150,                                   // ������� ��������� �����
	    		        150,                                   // ������� ��������� �����
	    		        170,                                   // ����� ��������� �����
	    		        0,                                     // ������������ (0 = �����������)
	    		        "Hafnium",                             // ���������� ���
	    		        "Hafnium",                             // �������������� ���
	    		        0,                                     // ��� ������� (�� �������� ��������)
	    		        0,                                     // �������������� �������� �������
	    		        2506,                                  // ����������� ��������� (� ���������)
	    		        4876,                                  // ����������� ������� (� ���������)
	    		        true,                                  // ��������� �� �������� ����
	    		        false,                                 // ������������
	    		        2,                                     // �������� ����
	    		        2,                                     // ��������� ���������
	    		        1,                                     // �������� ���������
	    		        Dyes.dyeGray,                          // ���� ���������
	    		        Element.Hf,                            // ���������� ������� (������)
	    		        Arrays.asList(                         // Thaumcraft �������
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
	    			    856,                                  // ���������� ID ���������
	    			    TextureSet.SET_FINE,                  // ��������: ������ ���������
	    			    1.0F,                                 // �������� ������������
	    			    0,                                    // ��������� (�� ���������)
	    			    2,                                    // �������� ������������
	    			    10,                                   // ���� ��������
	    			    85,                                   // ������� ��������� �����
	    			    120,                                  // ������� ��������� �����
	    			    190,                                  // ����� ��������� �����
	    			    0,                                    // ������������ (0 = �����������)
	    			    "Violan",                            // ���������� ���
	    			    "Violan",                            // �������������� ���
	    			    0,                                    // ��� ������� (�� �������� ��������)
	    			    0,                                    // �������������� �������� �������
	    			    1780,                                 // ����������� ��������� (� ���������)
	    			    -1,                                   // ����������� ������� (�� ������������)
	    			    false,                                // ��������� �� �������� ����
	    			    false,                                // ������������
	    			    1,                                    // �������� ����
	    			    1,                                    // ��������� ���������
	    			    1,                                    // �������� ���������
	    			    Dyes.dyeBlue,                         // ���� ���������
	    			    2,                                    // ��������������� (0 = ��� ���������������)
	    			    Arrays.asList(
	    			        new MaterialStack(Materials.Calcium, 1L),        // �������� ���������
	    			        new MaterialStack(Materials.Magnesium, 1L),      // ������� ������
	    			        new MaterialStack(Materials.Silicon, 2L),        // ������� �������
	    			        new MaterialStack(Materials.Aluminium, 1L)        // ������� ��������
	    			    ),
	    			    Arrays.asList(
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.PERFODIO, 2L),
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.LUX, 1L)         // ���������� ������� ��� Thaumcraft
	    			    )
	    			);
	    		public static Materials BlueMarble = new Materials(
	    			    224,                                      // ���������� ID ��������� 897
	    			    TextureSet.SET_ROUGH,                      // ��������: ��������������
	    			    1.0F, 0, 1, 193,                            // ���������������� ��������������
	    			    50, 50, 200, 0,                           // ���� (�����)
	    			    "BlueMarble", "Blue Marble",              // ����� ���������
	    			    0, 0, -1, 0,                              // ��������� ������� � �����������
	    			    false, false,                             // �� ������� ����, �����������
	    			    1, 1, 1,                                  // �������� � ���������
	    			    Dyes.dyeBlue,                             // ���� ��������� (�����)
	    			    2,                                        // ��� ���������
	    			    Arrays.asList(                            // ������ ���������
	    			        new MaterialStack(Violan, 5L),      // ������� �������
	    			        new MaterialStack(Materials.Calcite, 5L)
	    			    ),
	    			    Arrays.asList(                            // Thaumcraft �������
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.PERFODIO, 1L)
	    			    )
	    			);
	    		

	    			public static Materials BlackMarble = new Materials(
	    			    898,
	    			    TextureSet.SET_FINE,
	    			    1.0F, 0, 1, 193,
	    			    20, 20, 20, 0,                            // ���� (������)
	    			    "BlackMarble", "Black Marble",
	    			    0, 0, -1, 0,
	    			    false, false,
	    			    1, 1, 1,
	    			    Dyes.dyeBlack,                            // ���� ��������� (������)
	    			    2,
	    			    Arrays.asList(
	    			        new MaterialStack(Bitumen, 3L),       // �����
	    			        new MaterialStack(Materials.Graphite, 2L),      // ������
	    			        new MaterialStack(Materials.Pyrite, 1L),        // �������� ������
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
	    			    220, 200, 180, 0,                         // ���� (�������)
	    			    "BeigeMarble", "Beige Marble",
	    			    0, 0, -1, 0,
	    			    false, false,
	    			    1, 1, 1,
	    			    Dyes.dyeBrown,                            // ���� ��������� (�������)
	    			    2,
	    			    Arrays.asList(
	    			        new MaterialStack(Materials.Manganese, 2L),     // ��������
	    			        new MaterialStack(Materials.BrownLimonite, 3L),      // �������
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
	    			    200, 50, 50, 0,                           // ���� (�������)
	    			    "RedMarble", "Red Marble",
	    			    0, 0, -1, 0,
	    			    false, false,
	    			    1, 1, 1,
	    			    Dyes.dyeRed,                              // ���� ��������� (�������)
	    			    2,
	    			    Arrays.asList(
	    			        new MaterialStack(Materials.Iron, 1L),     // ������ ������
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
	    			    150, 100, 50, 0,                          // ���� (����������)
	    			    "BrownMarble", "Brown Marble",
	    			    0, 0, -1, 0,
	    			    false, false,
	    			    1, 1, 1,
	    			    Dyes.dyeBrown,                            // ���� ��������� (����������)
	    			    2,
	    			    Arrays.asList(
	    			        new MaterialStack(Materials.Manganese, 3L),     // ��������
	    			        new MaterialStack(Materials.Iron, 4L),      // �������� ������
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
	    			    50, 200, 50, 0,                           // ���� (�������)
	    			    "GreenMarble", "Green Marble",
	    			    0, 0, -1, 0,
	    			    false, false,
	    			    1, 1, 1,
	    			    Dyes.dyeGreen,                            // ���� ��������� (�������)
	    			    2,
	    			    Arrays.asList(
	    			        new MaterialStack(Materials.Chlorine, 5L),      // �������
	    			        new MaterialStack(Materials.Calcite, 5L)
	    			    ),
	    			    Arrays.asList(
	    			        new TC_Aspects.TC_AspectStack(TC_Aspects.PERFODIO, 1L)
	    			    )
	    			);




	    	

	    	
	   
	    @Mod.EventHandler
	    public void preInit(FMLPreInitializationEvent event) {
	        // ��� ��� ������ �������������
	    	// ���������� ������ ������� Vacuum Tube
	    	// ������������� ����������
	    	ModBlocks.init();
	    	registerOreVeins();
	    	addMaceratorRecipes();
	    	addShapedRecipes();
	    	addVacuumTubeReceipt();
	    	addDiodeRecipe();
	    	addSMDDiodeRecipe();
	    	Materials.DeepIron.mOreReRegistrations.add(Materials.AnyIron);//��������� ������
	    	Materials.ShadowIron.mOreReRegistrations.add(Materials.AnyIron);//��������� ������
	    	Materials.DarkIron.mOreReRegistrations.add(Materials.AnyIron);//��������� ������
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
	    	
	        // ��� ��� ���������� ��������
	    }

	    @Mod.EventHandler
	    public void postInit(FMLPostInitializationEvent event) {
	        // ���, ��������� �� ������ �����
	    	addSamariumCobaltDust();
	    	addPolarizerRecipesForSamariumCobalt();
	    	addCentrifugeRecipes();
	    	addCompressorRecipes();
	    	
	        //addGregTechRecipes();
	    }
	    public static void registerOreVeins() {
	    	// ���� RareEarth1
	    	GT_Worldgen_GT_Ore_Layer rareEarth1 = new GT_Worldgen_GT_Ore_Layer(
	    	        "ore.mix.rareearth1", // ��� ����
	    	        true,                 // ������������ �������� �� ���������
	    	        10,                   // ����������� ������
	    	        50,                   // ������������ ������
	    	        80,                   // ���
	    	        8,                    // ���������
	    	        35,                   // ������
	    	        true,                 // � ������� ����
	    	        false,                // �� ���������� � ���
	    	        false,                // �� ���������� � ����
	    	        true,                 // �� ����
	    	        true,                 // �� �����
	    	        true,                 // � ����������
	    	        Xenotime,             // �������� �������� (��������)
	    	        Rheniite,             // ��������� �������� (������)
	    	        Samarskite,           // ������������� �������� (���������)
	    	        Parisite              // ��������� �������� (�������)
	    	);


         // ���� RareEarth2
            GT_Worldgen_GT_Ore_Layer rareEarth2 = new GT_Worldgen_GT_Ore_Layer(
                    "ore.mix.rareearth2", // ��� ����
                    true,                 // ������������ �������� �� ���������
                    10,                   // ����������� ������
                    40,                   // ������������ ������
                    100,                  // ���
                    12,                   // ���������
                    45,                   // ������
                    true,                 // � ������� ����
                    false,                // �� ���������� � ���
                    false,                // �� ���������� � ����
                    true,                 // �� ����
                    true,                 // �� �����
                    true,                 // � ����������
                    Corundum,             // �������� �������� (������)
                    Gadolinite,           // ��������� �������� (���������)
                    Euxenite,             // ������������� �������� (��������)
                    Loparite              // ��������� �������� (�������)
            );

            // ���� RareEarth3
            GT_Worldgen_GT_Ore_Layer rareEarth3 = new GT_Worldgen_GT_Ore_Layer(
                    "ore.mix.rareearth3", // ��� ����
                    true,                 // ������������ �������� �� ���������
                    10,                   // ����������� ������
                    50,                   // ������������ ������
                    100,                  // ��� (����� ���������������� ��������)
                    15,                   // ���������
                    40,                   // ������ ����
                    true,                 // � ������� ����
                    false,                // �� ���������� � ���
                    false,                // �� ���������� � ����
                    true,                 // �� ����
                    true,                 // �� �����
                    true,                 // � ����������
                    SphaleriteGeIn,       // �������� �������� (�������� ����������������)
                    Arsenopyrite,         // ��������� ��������
                    Baddeleyite,          // ��������� ��������
                    Thortveitite          // ����������
            );

         // ���� VolcanicDeposits
        //    GT_Worldgen_GT_Ore_Layer volcanicDeposits = new GT_Worldgen_GT_Ore_Layer(
         //           "ore.mix.volcanicdeposits", // ��� ����
         //           true,                       // ������������ �������� �� ���������
         //           40,                         // ����������� ������
         //           120,                        // ������������ ������
          //          150,                        // ���
          //          18,                         // ���������
          //          60,                         // ������
          //          true,                       // � ������� ����
          //          false,                      // �� ���������� � ���
          //          false,                      // �� ���������� � ����
           //         false,                      // �� ���������� �� ����
           //         false,                      // �� ���������� �� �����
           //         true,                       // � ����������
           //         Materials.Alunite,                    // �������� �������� (������)
            //        Materials.VolcanicAsh,                // ��������� �������� (������������� �����)
            //        Materials.Pumice,                     // ������������� �������� (�����)
           //         Materials.Zeolite                     // ��������� �������� (������)
          //  );
         // ���� SerpentineVeins � ���������� ������ ���������
            GT_Worldgen_GT_Ore_Layer serpentineVeins = new GT_Worldgen_GT_Ore_Layer(
                    "ore.mix.serpentineveins", // ��� ����
                    true,                      // ������������ �������� �� ���������
                    5,                         // ����������� ������
                    35,                        // ������������ ������
                    90,                        // ���
                    10,                        // ���������
                    30,                        // ������
                    true,                      // � ������� ����
                    false,                     // �� ���������� � ���
                    false,                     // �� ���������� � ����
                    true,                     // �� ���������� �� ����
                    true,                     // �� ���������� �� �����
                    true,                     // �� ���������� � ����������
                    Materials.Chromite,        // �������� �������� (������)
                    Materials.Soapstone,       // ��������� �������� (��������� ������)
                    Materials.Magnesite,       // ������������� �������� (��������)
                    Materials.Tantalite        // ��������� �������� (�������� � ������ ������� � ��������)
            );

         // ���� EvaporiteDeposits
          //  GT_Worldgen_GT_Ore_Layer evaporiteDeposits = new GT_Worldgen_GT_Ore_Layer(
             //       "ore.mix.evaporitedeposits", // ��� ����
             //       true,                        // ������������ �������� �� ���������
             //       50,                          // ����������� ������
              //      90,                          // ������������ ������
              //      180,                         // ���
              //      25,                          // ���������
              //      80,                          // ������
              //      true,                        // � ������� ����
             //       false,                       // �� ���������� � ���
             //       false,                       // �� ���������� � ����
              //      false,                       // �� ���������� �� ����
             //       false,                       // �� ���������� �� �����
              //      true,                        // � ����������
                    
             //       Materials.Gypsum,                      // �������� �������� (����)
             //       Materials.RockSalt,                    // ��������� �������� (�������� ����)
             //       Materials.RockSalt,                        // ������������� �������� (�� ���������)
             //       Materials.RockSalt                       // ��������� �������� (�� ���������)
          //  );
         // ���� MineralClayDeposits
        //    GT_Worldgen_GT_Ore_Layer mineralClayDeposits = new GT_Worldgen_GT_Ore_Layer(
             //       "ore.mix.mineralclaydeposits", // ��� ����
            //        true,                          // ������������ �������� �� ���������
            //        60,                            // ����������� ������
             //       120,                           // ������������ ������
             //       100,                           // ���
             //       15,                            // ���������
             //       50,                            // ������
             //       true,                          // � ������� ����
            //        false,                         // �� ���������� � ���
            //        false,                         // �� ���������� � ����
           //         false,                         // �� ���������� �� ����
           //         false,                         // �� ���������� �� �����
           //         false,                         // �� ���������� � ����������
            //        Materials.FullersEarth,                  // �������� �������� (Fuller's Earth)
          //          Materials.Bentonite,                     // ��������� �������� (Bentonite)
          //          Materials.Kaolinite,                     // ������������� �������� (Kaolinite)
         //           Materials.Kaolinite                           // ��������� �������� (�� ���������)
         //   );
            //���� �������
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
        		    true, // ������������ ������
        		    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, RareEarthDyErHoTmYtLu, 1) }, // �������� �������� (����)
        		    new ItemStack[] { 
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Dysprosium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Erbium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Holmium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thulium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ytterbium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lutetium, 1)
        		    }, // ��������� ���������
        		    null, // ��� �������������� ���������
        		    new FluidStack[] {}, // ��� ��������� �� �����
        		    null, // ��� ��������� �� ������
        		    500, // ������������: 500 �����
        		    120 // �����������������: 120 EU/t
, 0
        		);
        	GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes.addRecipe(
        		    true, // ������������ ������
        		    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, RareEarthDySmEuGd, 1) }, // �������� �������� (����)
        		    new ItemStack[] { 
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Dysprosium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Europium, 2),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Samarium, 2),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gadolinium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Praseodymium, 1)
        		    }, // ��������� ���������
        		    null, // ��� �������������� ���������
        		    new FluidStack[] {}, // ��� ��������� �� �����
        		    null, // ��� ��������� �� ������
        		    500, // ������������: 500 �����
        		    120 // �����������������: 120 EU/t
, 0
        		);
        	//RareEarthGdCeYDyTb
        	GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes.addRecipe(
        		    true, // ������������ ������
        		    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, RareEarthGdCeYDyTb, 1) }, // �������� �������� (����)
        		    new ItemStack[] { 
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Cerium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Yttrium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Dysprosium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gadolinium, 2),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Terbium, 1)
        		    }, // ��������� ���������
        		    null, // ��� �������������� ���������
        		    new FluidStack[] {}, // ��� ��������� �� �����
        		    null, // ��� ��������� �� ������
        		    500, // ������������: 500 �����
        		    120 // �����������������: 120 EU/t
, 0
        		);
        	//RareEarthGeInGa
        	GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes.addRecipe(
        		    true, // ������������ ������
        		    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, RareEarthGeInGa, 1) }, // �������� �������� (����)
        		    new ItemStack[] { 
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Germanium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Indium, 1),
        		        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gallium, 1),

        		    }, // ��������� ���������
        		    null, // ��� �������������� ���������
        		    new FluidStack[] {}, // ��� ��������� �� �����
        		    null, // ��� ��������� �� ������
        		    500, // ������������: 500 �����
        		    120 // �����������������: 120 EU/t
, 0
        		);
        }
	    private void addGregTechRecipes() {
	        // ���������� �������� (��� ����� ����)
	    }
	    private static void addMaceratorRecipes() {
	    	  // ������ ������ ������� � ��������������� �� �����
	        Object[][] marbleData = {
	            {ModBlocks.blueMarble, OrePrefixes.dust, "BlueMarble"},
	            {ModBlocks.blackMarble, OrePrefixes.dust, "BlackMarble"},
	            {ModBlocks.beigeMarble, OrePrefixes.dust, "BeigeMarble"},
	            {ModBlocks.redMarble, OrePrefixes.dust, "RedMarble"},
	            {ModBlocks.brownMarble, OrePrefixes.dust, "BrownMarble"},
	            {ModBlocks.greenMarble, OrePrefixes.dust, "GreenMarble"}
	        };

	        // ���� ��� ���������� ��������
	        for (Object[] entry : marbleData) {
	            ItemStack input = new ItemStack((Block) entry[0]); // ���� �������
	            ItemStack output = GT_OreDictUnificator.get((OrePrefixes) entry[1], entry[2], 1L); // ����

	            // ���������� ������� � ���������
	            GT_Recipe.GT_Recipe_Map.sMaceratorRecipes.addRecipe(
	                true,                        // ������� �� ������
	                new ItemStack[]{input},      // ������� ��������
	                new ItemStack[]{output},     // �������� ��������
	                null,                        // �������������� ���������
	                null,                        // �������������� ������
	                null,                        // ��������, ��������� ��� �������
	                null,                        // ��������, ������������ ��������
	                200,                         // ����� ��������� (���)
	                2,                           // ����������������� (EU/t)
	                0                            // ����������� �������� (������ �� ������������)
	            );
	        }
	    }
	    private static void addCompressorRecipes() {
	        // ������ � ���� � ��������������� ������ �������
	        Object[][] marbleData = {
	            {OrePrefixes.dust, "BlueMarble", ModBlocks.blueMarble},
	            {OrePrefixes.dust, "BlackMarble", ModBlocks.blackMarble},
	            {OrePrefixes.dust, "BeigeMarble", ModBlocks.beigeMarble},
	            {OrePrefixes.dust, "RedMarble", ModBlocks.redMarble},
	            {OrePrefixes.dust, "BrownMarble", ModBlocks.brownMarble},
	            {OrePrefixes.dust, "GreenMarble", ModBlocks.greenMarble}
	        };

	        // ���� ���������� ��������
	        for (Object[] entry : marbleData) {
	            ItemStack input = GT_OreDictUnificator.get((OrePrefixes) entry[0], entry[1], 1L); // 1
	            ItemStack output = new ItemStack((Block) entry[2]); // ���� �������

	            // ���������� �������
	            GT_Recipe.GT_Recipe_Map.sCompressorRecipes.addRecipe(
	                true,                        // ������� �� ������
	                new ItemStack[]{input},      // ������� ��������
	                new ItemStack[]{output},     // �������� ��������
	                null,                        // �������������� ���������
	                null,                        // �������������� ������
	                null,                        // ��������, ��������� ��� �������
	                null,                        // ��������, ������������ ��������
	                200,                         // ����� ��������� (���)
	                2,                           // ����������������� (EU/t)
	                0                            // ����������� �������� (������ �� ������������)
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
		    	        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Caesium, 1L), // 1 �����a �� �����
		    	    },
		    	    Materials.Plastic.getMolten(288), // 288 �� ������ ���� (2 ������)
		    	    ItemList.Circuit_Parts_Diode.get(32L, new Object[0]), // �� ������ 4 �����
		    	    400, // ����� ������������: 400 ����� (20 ������)
		    	    48  // ����������� �������: 48 EU/t
		    	);
	    }
	    public static void addSMDDiodeRecipe() {
	    	GT_Values.RA.addAssemblerRecipe(
		    	    new ItemStack[]{
		    	        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gallium, 1L), //
		    	        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 4L), // 
		    	        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Caesium, 1L), // 1 �����a �� �����
		    	    },
		    	    Materials.Plastic.getMolten(288), // 288 �� ������ ���� (2 ������)
		    	    ItemList.Circuit_Parts_DiodeSMD.get(64L, new Object[0]), // �� ������ 4 �����
		    	    400, // ����� ������������: 400 ����� (20 ������)
		    	    120  // ����������� �������: 48 EU/t
		    	);
	    }
	  
	    public static void addSamariumCobaltDust() 
	    {
	    
	    	   // ���������� �������� �������
	        ItemStack samariumCobaltDust = GT_OreDictUnificator.get(OrePrefixes.dust, SamariumCobalt, 5L);

	        // ��������� shapeless ������ ����� GT_ModHandler
	        GT_ModHandler.addShapelessCraftingRecipe(
	            samariumCobaltDust, // �������� �������
	            GT_ModHandler.RecipeBits.NOT_REMOVABLE, // ����� (��������, ������ ������ �������)
	            new Object[]{
	                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Samarium, 1L), // 1x ���� �������
	                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L) ,  // 4x ���� ��������
	                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L) ,  // 4x ���� ��������
	                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L) ,  // 4x ���� ��������
	                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L)   // 4x ���� ��������
	            }
	        );
	    }
	    
	
	 
	    public void addPolarizerRecipesForSamariumCobalt() {
	        // �������� ��� ������� � �������� ����������
	        OrePrefixes[] prefixes = {
	            OrePrefixes.dust,
	            OrePrefixes.stick,
	            OrePrefixes.plate,
	            OrePrefixes.nugget,
	            OrePrefixes.ingot
	        };

	        // ���� �� ������� ��������
	        for (OrePrefixes prefix : prefixes) {
	            // ������� ��������
	            ItemStack input = GT_OreDictUnificator.get(prefix, SamariumCobalt, 1L);

	            // �������� ��������
	            ItemStack output = GT_OreDictUnificator.get(prefix, SamariumCobaltMagnetic, 1L);

	            // ���������� �������
	            if (input != null && output != null) {
	                GT_Recipe.GT_Recipe_Map.sPolarizerRecipes.addRecipe(
	                    true,                          // ���������� ����������
	                    new ItemStack[] { input },     // ������� �������
	                    new ItemStack[] { output },    // �������� �������
	                    null,                          // ��� �������������� ������/�������
	                    null,                          // ��� ��������
	                    null,                          // ��� �������������� ������
	                    16,                            // ������������: 16 �����
	                    256,                           // ����������� �������: 256 EU/t
	                    0                              // �������������� ���������: �� ������������
	                );
	            } else {
	                System.err.println("Failed to add Polarizer recipe for " + prefix.name() + ": Input or output is null.");
	            }
	        }
	    }


	    public static void addVacuumTubeReceipt() {
	    GT_Values.RA.addAssemblerRecipe(
	    	    new ItemStack[]{
	    	        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Caesium, 1L), // 2 ������ �� �����
	    	        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L), // 2 ������ �� ����
	    	        //GT_OreDictUnificator.get(ItemList.Circuit_Parts_Glass_Tube, 1L),   // 1 ���������� ������
	    	        ItemList.Circuit_Parts_Glass_Tube.get(4L, new Object[0])
	    	    },
	    	    null, // ���� ����������� �� ���������, �������� null
	    	    ItemList.Circuit_Parts_Vacuum_Tube.get(4L, new Object[0]), // �� ������ 4 �����
	    	    200, // ����� ������������: 200 ����� (10 ������)
	    	    12  // ����������� �������: 32 EU/t
	    	    //ItemList.Circuit_Parts_Vacuum_Tube.get(4L, new Object[0]), // �� ������ 4 �����
	    	);
	    }
	  
	   
	        
	        //Neodymium.addOreByProducts(new Materials[] { Monazite, RareEarth });
	        static void addAsphaltRecipe() {
	        GT_ModHandler.addCraftingRecipe(
	        	    //new ItemStack(ModItems.asphalt, 1), // ���������: 1 ������� ��������
	        		ItemList.Circuit_Parts_Vacuum_Tube.get(4L, new Object[0]), // �� ������ 4 �����
	        	    GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
	        	    new Object[] {
	        	        "BB ",
	        	        "AA ",
	        	        "BB ",
	        	        Character.valueOf('B'), GT_OreDictUnificator.get(OrePrefixes.dust, Bitumen, 1L) // ������ 'C' ��� ��������� ������
	        	        //Character.valueOf('B'), new ItemStack(OreDictionary.getOres("dustBitumen").get(0)) // ���������� ����� �� OreDict
	        	        //Character.valueOf('B'), new ItemStack(OreDictionary.doesOreNameExist("dustBitumen"))
	        	    }
	        	);
	      //  GT//_Values.RA.addAssemblerRecipe(
	        	  //  new ItemStack[]{
	        	   //     new ItemStack(Metallurgy, 2), // 2 ������ �� Metallurgy 4
	        	 //       new ItemStack(Blocks.GRAVEL, 4),          // 4 ������
	        	 //       new ItemStack(Blocks.SAND, 2)            // 2 �����
	        	  //  },
	        	  //  Materials.Water.getFluid(1000), // 1000 �� ����
	        	  //  new ItemStack(ChiselBlocks.ASPHALT, 8), // 8 ������ ��������
	        	  //  400, // �����: 400 ����� (20 ������)
	        	 //   50   // �������: 50 EU/t
	        	//);
	    };


}
