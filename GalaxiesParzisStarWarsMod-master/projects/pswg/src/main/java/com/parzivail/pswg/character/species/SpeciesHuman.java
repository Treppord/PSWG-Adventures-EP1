package com.parzivail.pswg.character.species;

import com.parzivail.pswg.character.DatapackedSpeciesVariable;
import com.parzivail.pswg.character.SpeciesVariable;
import com.parzivail.pswg.character.SwgSpecies;
import com.parzivail.pswg.container.SwgSpeciesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collection;

public class SpeciesHuman extends SwgSpecies
{
	private static final SpeciesVariable VAR_SKINTONE = new DatapackedSpeciesVariable(SwgSpeciesRegistry.SPECIES_HUMAN, "skin_tone");

	public SpeciesHuman(String serialized)
	{
		super(serialized);
	}

	@Override
	public Identifier getSlug()
	{
		return SwgSpeciesRegistry.SPECIES_HUMAN;
	}

	@Override
	public SpeciesVariable[] getVariables()
	{
		return new SpeciesVariable[] {
				VAR_SKINTONE,
				VAR_HUMANOID_SCARS,
				VAR_HUMANOID_TATTOOS,
				VAR_HUMANOID_TATTOO_COLOR,
				VAR_HUMANOID_EYEBROWS,
				VAR_HUMANOID_HAIR,
				VAR_HUMANOID_HAIR_COLOR,
				VAR_HUMANOID_CLOTHES_UNDERLAYER,
				VAR_HUMANOID_EYE_COLOR,
				VAR_HUMANOID_CLOTHES_TOPS,
				VAR_HUMANOID_CLOTHES_BOTTOMS,
				VAR_HUMANOID_CLOTHES_BELTS,
				VAR_HUMANOID_CLOTHES_BOOTS,
				VAR_HUMANOID_CLOTHES_GLOVES,
				VAR_HUMANOID_CLOTHES_ACCESSORIES,
				VAR_HUMANOID_CLOTHES_OUTERWEAR
		};
	}

	@Override
	@Environment(EnvType.CLIENT)
	public Collection<Identifier> getTextureStack(PlayerEntity player)
	{
		var stack = new ArrayList<Identifier>();
		stack.add(getGenderedTexture(this, VAR_SKINTONE));
		if (SpeciesVariable.isNotEmpty(this, VAR_HUMANOID_SCARS))
			stack.add(getTexture(this, VAR_HUMANOID_SCARS));
		if (SpeciesVariable.isNotEmpty(this, VAR_HUMANOID_TATTOOS))
			stack.add(tint(getTexture(this, VAR_HUMANOID_TATTOOS), this, VAR_HUMANOID_TATTOO_COLOR));
		stack.add(getGlobalTexture("eyes_whites"));
		stack.add(tint(getGlobalTexture("eyes"), this, VAR_HUMANOID_EYE_COLOR));
		stack.add(getGenderedTexture(this, VAR_HUMANOID_EYEBROWS));
		stack.add(getClothes(this, player));
		if (SpeciesVariable.isNotEmpty(this, VAR_HUMANOID_HAIR))
			stack.add(tint(getTexture(this, VAR_HUMANOID_HAIR), this, VAR_HUMANOID_HAIR_COLOR));
		return stack;
	}
}
