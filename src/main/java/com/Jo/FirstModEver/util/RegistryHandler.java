package com.Jo.FirstModEver.util;

import com.Jo.FirstModEver.First;
import com.Jo.FirstModEver.Tools.ModItemTier;
import com.Jo.FirstModEver.blocks.BlockItemBase;
import com.Jo.FirstModEver.blocks.RubyBlock;
import com.Jo.FirstModEver.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryHandler {

        public static final DeferredRegister<Item> ITEMS=new DeferredRegister<>(ForgeRegistries.ITEMS, First.MOD_ID);
        public static final DeferredRegister<Block> BLOCKS=new DeferredRegister<>(ForgeRegistries.BLOCKS,First.MOD_ID);

        public static void init(){
                ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
                BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        //Items
        public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
        public static final RegistryObject<Item> PURPLE_APPLE=ITEMS.register("purple_apple",ItemBase::new);

        //Blocks
        public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);


        //Block Items
        public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block",()-> new BlockItemBase(RUBY_BLOCK.get()));


        //Tools
        public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword",()->
                new SwordItem(ModItemTier.RUBY,2,-2.4F,new Item.Properties().group(First.TAB)));


}
