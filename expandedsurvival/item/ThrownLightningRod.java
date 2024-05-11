package net.steve.expandedsurvival.item;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownLightningRod extends ThrowableItemProjectile {
    public ThrownLightningRod(EntityType<? extends ThrownLightningRod> p_37391_, Level p_37392_) {
        super(p_37391_, p_37392_);
    }

    public ThrownLightningRod(Level p_37399_, LivingEntity p_37400_) {
        super(EntityType.SNOWBALL, p_37400_, p_37399_);
    }

    public ThrownLightningRod(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
        super(EntityType.SNOWBALL, p_37395_, p_37396_, p_37397_, p_37394_);
    }

    protected Item getDefaultItem() {
        return Items.SNOWBALL;
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (ParticleOptions)(itemstack.isEmpty() ? ParticleTypes.EXPLOSION : new ItemParticleOption(ParticleTypes.ITEM, itemstack));
    }

    public void handleEntityEvent(byte p_37402_) {
        if (p_37402_ == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void onHitEntity(EntityHitResult p_37404_) {
        super.onHitEntity(p_37404_);
        Entity $$1 = p_37404_.getEntity();
        int $$2 = $$1 instanceof Blaze ? 3 : 0;
        $$1.hurt(this.damageSources().thrown(this, this.getOwner()), (float)$$2);

        LightningBolt chicken = EntityType.LIGHTNING_BOLT.create(this.level());
        chicken.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
        this.level().addFreshEntity(chicken);
    }


    protected void onHit(HitResult p_37406_) {
        super.onHit(p_37406_);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
            LightningBolt chicken = EntityType.LIGHTNING_BOLT.create(this.level());
            chicken.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            this.level().addFreshEntity(chicken);
        }

    }


}