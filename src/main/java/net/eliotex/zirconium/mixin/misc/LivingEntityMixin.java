package net.eliotex.zirconium.mixin.misc;

import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.entity.Entity;
import net.minecraft.entity.living.LivingEntity;
import net.minecraft.entity.living.effect.StatusEffect;
import net.minecraft.entity.living.effect.StatusEffectInstance;
import net.minecraft.world.World;

// Credits to BugTorch for this!
@Mixin(value = LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

	LivingEntityMixin(World world) {
		super(world);
	}

	@Shadow
	@Final
	private Map<Integer, StatusEffectInstance> statusEffects;

	/**
	 * @author jss2a98aj
	 * @reason If the potion array is empty don't waste time checking it.
	 */
	@Overwrite()
	public boolean hasStatusEffect(int effectID) {
		return statusEffects.size() != 0 && statusEffects.containsKey(effectID);
	}

	/**
	 * @author jss2a98aj
	 * @reason If the potion array is empty don't waste time checking it.
	 */
	@Overwrite()
	public boolean hasStatusEffect(StatusEffect effect) {
		return statusEffects.size() != 0 && statusEffects.containsKey(effect.id);
	}

	/**
	 * @author jss2a98aj
	 * @reason Keeps the datawatcher from being updated when no change in air has occurred.
	 */
	/*@Override
	public void setAir(int airAmount) {
		if (getAir() != airAmount) {
			super.setAir(airAmount);
		}
	}*/

}
