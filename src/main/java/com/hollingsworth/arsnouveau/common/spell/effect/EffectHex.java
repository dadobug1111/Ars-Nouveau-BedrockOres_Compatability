package com.hollingsworth.arsnouveau.common.spell.effect;

import com.hollingsworth.arsnouveau.common.lib.GlyphLib;
import com.hollingsworth.arsnouveau.api.spell.*;
import com.hollingsworth.arsnouveau.common.potions.ModPotions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.common.ForgeConfigSpec;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.Set;

public class EffectHex extends AbstractEffect {
    public static EffectHex INSTANCE = new EffectHex();

    private EffectHex() {
        super(GlyphLib.EffectHexID, "Hex");
    }

    @Override
    public void onResolveEntity(EntityHitResult rayTraceResult, Level world, @Nullable LivingEntity shooter, SpellStats spellStats, SpellContext spellContext) {
        Entity entity = rayTraceResult.getEntity();
        if(!(entity instanceof LivingEntity))
            return;
        applyConfigPotion((LivingEntity) entity, ModPotions.HEX_EFFECT, spellStats);
    }

    @Override
    public void buildConfig(ForgeConfigSpec.Builder builder) {
        super.buildConfig(builder);
        addPotionConfig(builder, 30);
        addExtendTimeConfig(builder, 8);
    }

    @Nonnull
    @Override
    public Set<AbstractAugment> getCompatibleAugments() {
        return getPotionAugments();
    }

    @Override
    protected Map<String, Integer> getDefaultAugmentLimits() {
        Map<String, Integer> map = super.getDefaultAugmentLimits();
        map.put(GlyphLib.AugmentAmplifyID, 4);
        return map;
    }

    @Override
    public String getBookDescription() {
        return "Applies the Hex effect. Hex increases any damage taken by a small amount while the user is afflicted by poison, wither, or fire. Additionally, Hex cuts the rate of Mana Regeneration and healing in half.";
    }

    @Override
    public SpellTier getTier() {
        return SpellTier.THREE;
    }

    @Override
    public int getDefaultManaCost() {
        return 100;
    }

    @Nonnull
    @Override
    public Set<SpellSchool> getSchools() {
        return setOf(SpellSchools.ABJURATION);
    }
}
