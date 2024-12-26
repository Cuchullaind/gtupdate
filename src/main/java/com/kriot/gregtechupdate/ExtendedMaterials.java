package com.kriot.gregtechupdate;

import java.util.List;

import gregtech.api.enums.Dyes;
import gregtech.api.enums.Element;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TC_Aspects;
import gregtech.api.enums.TextureSet;

public class ExtendedMaterials extends Materials {
    //private final String customData; // Ваши новые свойства

    public ExtendedMaterials(
        int id, TextureSet texture, float toolSpeed, int durability, int toolQuality,
        int itemType, int red, int green, int blue, int transparency,
        String internalName, String localizedName, int fuelType, int fuelPower,
        int meltingPoint, int boilingPoint, boolean needsBlastFurnace,
        boolean isTransparent, int oreValue, int densityMultiplier, int densityDivisor,
        Dyes color, Element element, List<TC_Aspects.TC_AspectStack> aspects
       // String customData // Ваше дополнительное поле
    ) {
        super(id, texture, toolSpeed, durability, toolQuality, itemType, red, green, blue,
              transparency, internalName, localizedName, fuelType, fuelPower,
              meltingPoint, boilingPoint, needsBlastFurnace, isTransparent, oreValue,
              densityMultiplier, densityDivisor, color, element, aspects);
        //this.customData = customData;
    }
    public Materials removeOreByProduct(Materials aMaterial) {
        if (!this.mOreByProducts.contains(aMaterial.mMaterialInto))
          this.mOreByProducts.remove(aMaterial) ;
        return this;
      }

  //  public String getCustomData() {
  //      return customData;
   // }


}
