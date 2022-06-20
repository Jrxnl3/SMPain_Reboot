package de.jinx.smp_reborn.items;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemMobList {

    public static ArrayList<Material> woodBlocks = new ArrayList<>(Arrays.asList(
            Material.ACACIA_LOG,
            Material.BIRCH_LOG,
            Material.OAK_LOG,
            Material.DARK_OAK_LOG,
            Material.JUNGLE_LOG,
            Material.MANGROVE_LOG,
            Material.SPRUCE_LOG));

    public static ArrayList<EntityType> undeadList = new ArrayList<>(Arrays.asList(EntityType.ZOMBIE,EntityType.SKELETON,EntityType.CREEPER,EntityType.ZOMBIE_VILLAGER,EntityType.DROWNED
            ,EntityType.HUSK,EntityType.PHANTOM,EntityType.STRAY,EntityType.WITHER,EntityType.ZOGLIN));

    public static ArrayList<EntityType> peacefulList = new ArrayList<>(Arrays.asList(EntityType.COW,EntityType.PIG,EntityType.CHICKEN,EntityType.FOX,EntityType.SHEEP
            ,EntityType.MUSHROOM_COW,EntityType.RABBIT));

    public static ArrayList<EntityType> waterList = new ArrayList<>(Arrays.asList(EntityType.COD,EntityType.GLOW_SQUID,EntityType.SQUID,EntityType.SALMON,EntityType.GUARDIAN,EntityType.ELDER_GUARDIAN,EntityType.DROWNED
            ,EntityType.TURTLE,EntityType.DOLPHIN,EntityType.FROG,EntityType.PUFFERFISH,EntityType.TROPICAL_FISH));

    public static ArrayList<EntityType> fireList = new ArrayList<>(Arrays.asList(EntityType.BLAZE,EntityType.WITHER_SKELETON,EntityType.ZOMBIFIED_PIGLIN,EntityType.PIGLIN,EntityType.MAGMA_CUBE,EntityType.HOGLIN
            ,EntityType.GHAST,EntityType.PIGLIN_BRUTE));
}
