package net.pl3x.forge.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;
import net.pl3x.forge.Pl3x;
import net.pl3x.forge.item.custom.ItemClaimTool;
import net.pl3x.forge.item.custom.ItemTrafficCone;
import net.pl3x.forge.item.custom.food.ItemCorn;
import net.pl3x.forge.item.custom.seed.ItemCornSeeds;
import net.pl3x.forge.item.custom.seed.ItemEnderPearlSeeds;

import java.util.HashSet;
import java.util.Set;

import static net.minecraft.item.ItemArmor.ArmorMaterial;

public class ModItems {
    public static final Set<Item> items = new HashSet<>();

    // ARMORS new int[]{ boots, leggings, chestplate, helmet }
    public static final ArmorMaterial boneArmorMaterial = EnumHelper.addArmorMaterial("BONE", Pl3x.modId + ":bone", 7, new int[]{1, 3, 5, 1}, 9, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 3);

    public static final ItemArmor BONE_BOOTS = new ItemArmor(boneArmorMaterial, EntityEquipmentSlot.FEET, "bone_boots").setCreativeTab(CreativeTabs.COMBAT);
    public static final ItemArmor BONE_CHESTPLATE = new ItemArmor(boneArmorMaterial, EntityEquipmentSlot.CHEST, "bone_chestplate").setCreativeTab(CreativeTabs.COMBAT);
    public static final ItemArmor BONE_HELMET = new ItemArmor(boneArmorMaterial, EntityEquipmentSlot.HEAD, "bone_helmet").setCreativeTab(CreativeTabs.COMBAT);
    public static final ItemArmor BONE_LEGGINGS = new ItemArmor(boneArmorMaterial, EntityEquipmentSlot.LEGS, "bone_leggings").setCreativeTab(CreativeTabs.COMBAT);
    public static final ItemClaimTool CLAIM_TOOL = new ItemClaimTool();
    public static final ItemMoney COIN = new ItemMoney("coin");
    public static final ItemCorn CORN = new ItemCorn();
    public static final ItemCornSeeds CORN_SEEDS = new ItemCornSeeds();
    public static final ItemEnderPearlSeeds ENDER_PEARL_SEEDS = new ItemEnderPearlSeeds();
    public static final ItemHat HAT_AFRO = new ItemHat("hat_afro");
    public static final ItemHat HAT_CAKE = new ItemHat("hat_cake");
    public static final ItemHat HAT_CLOAK = new ItemHat("hat_cloak");
    public static final ItemHat HAT_COWBOY = new ItemHat("hat_cowboy");
    public static final ItemHat HAT_EYE_BAND = new ItemHat("hat_eye_band");
    public static final ItemHat HAT_FEZ = new ItemHat("hat_fez");
    public static final ItemHat HAT_HARDHAT_OFF = new ItemHat("hat_hardhat_off");
    public static final ItemHat HAT_HARDHAT_ON = new ItemHat("hat_hardhat_on");
    public static final ItemHat HAT_HEADPHONES_CAT_EARS = new ItemHat("hat_headphones_cat_ears");
    public static final ItemHat HAT_HIGHHAT = new ItemHat("hat_highhat");
    public static final ItemHat HAT_MULLET = new ItemHat("hat_mullet");
    public static final ItemHat HAT_OCELOT = new ItemHat("hat_ocelot");
    public static final ItemHat HAT_OCELOT_SIAMESE = new ItemHat("hat_ocelot_siamese");
    public static final ItemHat HAT_OCELOT_TABBY = new ItemHat("hat_ocelot_tabby");
    public static final ItemHat HAT_OCELOT_TUX = new ItemHat("hat_ocelot_tux");
    public static final ItemHat HAT_SANTA = new ItemHat("hat_santa");
    public static final ItemHat HAT_SOMBRERO = new ItemHat("hat_sombrero");
    public static final ItemHat HAT_SQUID = new ItemHat("hat_squid");
    public static final ItemHat HAT_TOPHAT_BLACK_BLUE = new ItemHat("hat_tophat_black_blue");
    public static final ItemHat HAT_TOPHAT_BLACK_GRAY = new ItemHat("hat_tophat_black_gray");
    public static final ItemHat HAT_TOPHAT_BLACK_RED = new ItemHat("hat_tophat_black_red");
    public static final ItemHat HAT_TOPHAT_BLACK_WHITE = new ItemHat("hat_tophat_black_white");
    public static final ItemHat HAT_TOPHAT_BLACK_YELLOW = new ItemHat("hat_tophat_black_yellow");
    public static final ItemHat HAT_TOPHAT_ROUND_BLACK_WHITE = new ItemHat("hat_tophat_round_black_white");
    public static final ItemHat HAT_TOPHAT_ROUND_WHITE_BLACK = new ItemHat("hat_tophat_round_white_black");
    public static final ItemHat HAT_TOPHAT_WHITE_RED = new ItemHat("hat_tophat_white_red");
    public static final ItemHat HAT_WIZARD = new ItemHat("hat_wizard");
    public static final ItemHat HAT_WIZARD_2 = new ItemHat("hat_wizard2");
    public static final ItemBase PL3X_LOGO = new ItemBase("pl3x_logo");
    public static final ItemBase SEASONAL = new ItemBase("seasonal");
    public static final ItemTrafficCone TRAFFIC_CONE = new ItemTrafficCone();

    public static void register(IForgeRegistry<Item> registry) {
        items.forEach(registry::register);
    }

    public static void registerModels() {
        items.forEach(item -> Pl3x.proxy.registerItemRenderer(item, 0, item.getUnlocalizedName().substring(5)));
    }
}
