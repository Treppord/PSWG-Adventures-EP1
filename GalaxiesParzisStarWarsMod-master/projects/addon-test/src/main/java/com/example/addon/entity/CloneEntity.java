package com.example.addon.entity;

import com.example.addon.TestItems;
import com.parzivail.pswg.BaseContent;
import com.parzivail.pswg.Config;
import com.parzivail.pswg.Galaxies;
import com.parzivail.pswg.Resources;
import com.parzivail.pswg.container.SwgItems;
import com.parzivail.pswg.item.blaster.BlasterItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;

public class CloneEntity extends SkeletonEntity {

    public CloneEntity(EntityType<? extends CloneEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000000298023224)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_ARMOR, 1.0);
    }

    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        super.initEquipment(random, localDifficulty);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Registries.ITEM.get(Resources.id("blaster_a280"))));
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(TestItems.Armor.Mandalorian.helmet));
        this.equipStack(EquipmentSlot.CHEST, new ItemStack(TestItems.Armor.Mandalorian.chestplate));
        this.equipStack(EquipmentSlot.LEGS, new ItemStack(TestItems.Armor.Mandalorian.leggings));
        this.equipStack(EquipmentSlot.FEET, new ItemStack(TestItems.Armor.Mandalorian.boots));
    }




    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PLAYER_BREATH;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }


    SoundEvent getStepSound() {return SoundEvents.ENTITY_ZOGLIN_STEP;}

    protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
        super.dropEquipment(source, lootingMultiplier, allowDrops);
        Entity entity = source.getAttacker();
        if (entity instanceof CreeperEntity creeperEntity) {
            if (creeperEntity.shouldDropHead()) {
                creeperEntity.onHeadDropped();
                this.dropItem(TestItems.DAGOBAH_HOLODRIVE);
            }
        }

    }
    public boolean canUseRangedWeapon(RangedWeaponItem weapon) {
        return weapon == Registries.ITEM.get(Resources.id("blaster_a280"));
    }
}
