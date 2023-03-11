package com.trep.addon.entity;


import com.trep.addon.TestAddon;
import com.trep.addon.init.AdventureDamageSources;
import com.trep.addon.items.AdventureItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class CustomSnowballEntity extends ThrownItemEntity {

    public CustomSnowballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}
 
	public CustomSnowballEntity(World world, LivingEntity owner) {
		super(TestAddon.CustomSnowballEntityType, owner, world);
	}
 
	public CustomSnowballEntity(World world, double x, double y, double z) {
		super(TestAddon.CustomSnowballEntityType, x, y, z, world);
	}

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        this.explode();
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        this.explode();
    }

    public void setProperties(PlayerEntity user, float pitch, float yaw, float f, float g, float h) {
    }

    public static Builder createAttributes() {
        return null;
    }

    @Override
	protected Item getDefaultItem() {
		return AdventureItems.CUSTOM_SNOWBALL;
	}

    private void explode() {
		if (!this.getEntityWorld().isClient()) {
			this.getEntityWorld().createExplosion(this, AdventureDamageSources.CustomSnowball, null, this.getX(), this.getY(), this.getZ(), 2.0F, false, World.ExplosionSourceType.NONE);
			this.discard();
		}
	}

    

}