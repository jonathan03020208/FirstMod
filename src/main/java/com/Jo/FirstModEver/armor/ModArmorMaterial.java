package com.Jo.FirstModEver.armor;

import com.Jo.FirstModEver.First;
import com.Jo.FirstModEver.util.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    RUBY(First.MOD_ID+":ruby" , 25 , new int[] { 2 , 5 , 6 , 2 }, 18 ,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC , 1.5F ,()->{return Ingredient.fromItems(RegistryHandler.RUBY.get());});


    private static final int[] MAX_DAMAGE_ARRAY = new int[]{ 11 , 16 , 15 , 13 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

    ModArmorMaterial(String name , int maxDamageFactor , int[] damageReductionAmountArray , int enchantability ,
                     SoundEvent soundEvent , float toughness , Supplier<Ingredient> repairMaterial){
        this.name=name;
        this.maxDamageFactor=maxDamageFactor;
        this.damageReductionAmountArray=damageReductionAmountArray;
        this.enchantability=enchantability;
        this.soundEvent=soundEvent;
        this.toughness=toughness;
        this.repairMaterial=repairMaterial;


    }


    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        return MAX_DAMAGE_ARRAY[equipmentSlotType.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        return this.damageReductionAmountArray[equipmentSlotType.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
