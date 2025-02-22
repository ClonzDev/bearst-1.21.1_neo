package com.clonz.bearst.client.models;

import com.clonz.bearst.BearstMod;
import com.clonz.bearst.entity.BearstEntity;
import io.github.itskillerluc.duclib.client.model.AnimatableDucModel;
import io.github.itskillerluc.duclib.client.model.Ducling;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BearstModel extends AnimatableDucModel<BearstEntity> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(BearstMod.MODID, "bearst"), "main");

    public BearstModel(Ducling ducling) {
        super(ducling, RenderType::entityCutoutNoCull);
    }

    @Override
    protected Set<String> excludeAnimations() {
        return Set.of("animation.bearst.ground_walk");
    }

    @Override
    public void setupAnim(@NotNull BearstEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        super.setupAnim(pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
        this.animateWalk(pEntity.getAnimation().getAnimations().get("animation.bearst.ground_walk").animation(), pLimbSwing, pLimbSwingAmount, 1, 2);
        ((Ducling) getAnyDescendantWithName("head").orElseThrow()).xRot = pHeadPitch * ((float)Math.PI / 180F);
        ((Ducling) getAnyDescendantWithName("head").orElseThrow()).yRot = pNetHeadYaw * ((float)Math.PI / 180F);
    }
}
