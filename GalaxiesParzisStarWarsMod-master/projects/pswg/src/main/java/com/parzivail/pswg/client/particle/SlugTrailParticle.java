package com.parzivail.pswg.client.particle;

import com.parzivail.util.client.particle.PParticleType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.AnimatedParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;

@Environment(EnvType.CLIENT)
public class SlugTrailParticle extends AnimatedParticle
{
	protected SlugTrailParticle(ClientWorld clientWorld, double x, double y, double z, double vX, double vY, double vZ, SpriteProvider spriteProvider)
	{
		super(clientWorld, x, y, z, spriteProvider, 0.0F);
		this.velocityMultiplier = 0.92F;
		this.scale = this.random.nextFloat() * 0.2f + 0.2f;
		this.setAlpha(1.0F);
		var gray = 0.6f;
		this.setColor(gray, gray, gray);
		this.maxAge = (int)((double)(this.scale * 12.0F) / (this.random.nextFloat() * 0.8 + 0.2));
		this.setSpriteForAge(spriteProvider);
		this.collidesWithWorld = true;
		this.velocityX = vX;
		this.velocityY = vY;
		this.velocityZ = vZ;
	}

	@Override
	public void tick()
	{
		super.tick();
		if (!this.dead)
		{
			this.setAlpha(1);
			this.setSpriteForAge(this.spriteProvider);
		}
	}

	@Environment(EnvType.CLIENT)
	public static class Factory implements ParticleFactory<PParticleType>
	{
		private final SpriteProvider spriteProvider;

		public Factory(SpriteProvider spriteProvider)
		{
			this.spriteProvider = spriteProvider;
		}

		@Override
		public Particle createParticle(PParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i)
		{
			return new SlugTrailParticle(clientWorld, d, e, f, g, h, i, this.spriteProvider);
		}
	}
}
