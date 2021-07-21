package com.minecraftabnormals.endergetic.client.models.eetle.eggs;

import com.minecraftabnormals.abnormals_core.core.endimator.entity.EndimatorModelRenderer;
import com.minecraftabnormals.endergetic.common.tileentities.EetleEggTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;

/**
 * @author Endergized
 * @author SmellyModder (Luke Tonon)
 * <p>
 * Created using Tabula 7.0.0
 */
public class LargeEetleEggModel implements IEetleEggModel {
	public EndimatorModelRenderer smallEgg;
	public EndimatorModelRenderer Egg;
	public EndimatorModelRenderer GiantEgg;
	public EndimatorModelRenderer smallEgg2;
	public ModelRenderer cross1;
	public ModelRenderer base;
	public ModelRenderer cross2;
	public ModelRenderer cross3;
	public ModelRenderer cross4;

	public LargeEetleEggModel() {
		int textureWidth = 64;
		int textureHeight = 64;
		this.Egg = new EndimatorModelRenderer(textureWidth, textureHeight, 0, 0);
		this.Egg.setRotationPoint(-5.0F, 24.0F, -1.0F);
		this.Egg.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F);
		this.cross2 = new ModelRenderer(textureWidth, textureHeight, 0, 29);
		this.cross2.setRotationPoint(7.8F, 21.0F, -7.8F);
		this.cross2.addBox(0.0F, 0.0F, 0.0F, 11, 3, 0, 0.0F);
		this.setRotateAngle(cross2, 0.0F, -2.356194490192345F, 0.0F);
		this.cross1 = new ModelRenderer(textureWidth, textureHeight, 0, 29);
		this.cross1.setRotationPoint(-7.8F, 21.0F, 7.8F);
		this.cross1.addBox(0.0F, 0.0F, 0.0F, 11, 3, 0, 0.0F);
		this.setRotateAngle(cross1, 0.0F, 0.7853981633974483F, 0.0F);
		this.smallEgg = new EndimatorModelRenderer(textureWidth, textureHeight, 46, 7);
		this.smallEgg.setRotationPoint(4.0F, 24.0F, 4.0F);
		this.smallEgg.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4, 0.0F);
		this.cross4 = new ModelRenderer(textureWidth, textureHeight, 0, 29);
		this.cross4.setRotationPoint(7.8F, 21.0F, 7.8F);
		this.cross4.addBox(0.0F, 0.0F, 0.0F, 11, 3, 0, 0.0F);
		this.setRotateAngle(cross4, 0.0F, 2.356194490192345F, 0.0F);
		this.GiantEgg = new EndimatorModelRenderer(textureWidth, textureHeight, 24, 42);
		this.GiantEgg.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.GiantEgg.addBox(-5.0F, -12.0F, -5.0F, 10, 12, 10, 0.0F);
		this.cross3 = new ModelRenderer(textureWidth, textureHeight, 0, 29);
		this.cross3.setRotationPoint(-7.8F, 21.0F, -7.8F);
		this.cross3.addBox(0.0F, 0.0F, 0.0F, 11, 3, 0, 0.0F);
		this.setRotateAngle(cross3, 0.0F, -0.7853981633974483F, 0.0F);
		this.base = new ModelRenderer(textureWidth, textureHeight, -16, 38);
		this.base.setRotationPoint(0.0F, 23.99F, 0.0F);
		this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 0, 16, 0.0F);
		this.smallEgg2 = new EndimatorModelRenderer(textureWidth, textureHeight, 28, 0);
		this.smallEgg2.setRotationPoint(3.5F, 24.0F, -4.5F);
		this.smallEgg2.addBox(-2.5F, -5.0F, -2.5F, 5, 5, 5, 0.0F);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder builder, int packedLight, int packedOverlay, float partialTicks, EetleEggTileEntity.SackGrowth[] sackGrowths) {
		float eggScale1 = sackGrowths[0].getGrowth(partialTicks);
		this.smallEgg.setScale(eggScale1, eggScale1, eggScale1);
		this.smallEgg.render(matrixStack, builder, 240, packedOverlay);

		float eggScale2 = sackGrowths[1].getGrowth(partialTicks);
		this.smallEgg2.setScale(eggScale2, eggScale2, eggScale2);
		this.smallEgg2.render(matrixStack, builder, 240, packedOverlay);

		float eggScale3 = sackGrowths[2].getGrowthMultiplied(partialTicks, 0.85F);
		this.Egg.setScale(eggScale3, eggScale3, eggScale3);
		this.Egg.render(matrixStack, builder, 240, packedOverlay);

		float eggScale4 = sackGrowths[3].getGrowthMultiplied(partialTicks, 0.35F);
		this.GiantEgg.setScale(eggScale4, eggScale4, eggScale4);
		this.GiantEgg.render(matrixStack, builder, 240, packedOverlay);

		this.base.render(matrixStack, builder, packedLight, packedOverlay);
	}

	@Override
	public void renderSilk(MatrixStack matrixStack, IVertexBuilder silkBuilder, int packedLight, int packedOverlay) {
		this.base.render(matrixStack, silkBuilder, packedLight, packedOverlay);
		this.cross2.render(matrixStack, silkBuilder, packedLight, packedOverlay);
		this.cross1.render(matrixStack, silkBuilder, packedLight, packedOverlay);
		this.cross4.render(matrixStack, silkBuilder, packedLight, packedOverlay);
		this.cross3.render(matrixStack, silkBuilder, packedLight, packedOverlay);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}