package com.parzivail.pswg.character.species;

import com.parzivail.pswg.character.SpeciesVariable;
import com.parzivail.pswg.character.SwgSpecies;
import com.parzivail.pswg.container.SwgSpeciesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collection;

public class SpeciesBothan extends SwgSpecies
{
//	private static final SpeciesVariable VAR_BODY = new SpeciesVariable(
//			Resources.identifier("body"),
//			"white",
//			"green",
//			"pink",
//			"white"
//	);

	public SpeciesBothan(String serialized)
	{
		super(serialized);
	}

	@Override
	public Identifier getSlug()
	{
		return SwgSpeciesRegistry.SPECIES_BOTHAN;
	}

	@Override
	public SpeciesVariable[] getVariables()
	{
		return new SpeciesVariable[] { /*VAR_BODY*/ };
	}

	@Override
	@Environment(EnvType.CLIENT)
	public Collection<Identifier> getTextureStack(PlayerEntity player)
	{
		var stack = new ArrayList<Identifier>();
//		stack.add(getGenderedTexture(this, "base"));
//		stack.add(getGenderedTexture(this, getVariable(VAR_BODY)));
//		stack.add(getGenderedGlobalTexture(gender, "clothes"));
		return stack;
	}
}
