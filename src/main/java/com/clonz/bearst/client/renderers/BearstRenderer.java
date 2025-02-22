package com.clonz.bearst.client.renderers;

import com.clonz.bearst.client.models.BearstModel;
import com.clonz.bearst.entity.BearstEntity;
import io.github.itskillerluc.duclib.client.model.Ducling;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BearstRenderer extends MobRenderer<BearstEntity, BearstModel> {
    private static final ResourceLocation BLACK = ResourceLocation.fromNamespaceAndPath("bearst","textures/entity/bearst_black.png");
    private static final ResourceLocation BROWN = ResourceLocation.fromNamespaceAndPath("bearst","textures/entity/bearst_brown.png");

    public BearstRenderer(EntityRendererProvider.Context context, BearstModel model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    public BearstRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BearstModel((Ducling) pContext.bakeLayer(BearstModel.LAYER_LOCATION)), 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(BearstEntity entity) {
        return BLACK;
    }
}
