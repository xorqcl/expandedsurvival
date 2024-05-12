package net.steve.expandedsurvival.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.steve.expandedsurvival.ExpandedSurvival;
import net.steve.expandedsurvival.screen.renderer.EnergyInfoArea;
import net.steve.expandedsurvival.screen.renderer.FluidTankRenderer;
import net.steve.expandedsurvival.util.MouseUtil;
import org.jetbrains.annotations.NotNull;

public class AlloyScreen extends AbstractContainerScreen<AlloyMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ExpandedSurvival.MODID,"textures/gui/alloy_gui.png");
    private EnergyInfoArea energyInfoArea;
    private FluidTankRenderer renderer;

    public AlloyScreen(AlloyMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
        assignEnergyInfoArea();
        assignFluidRenderer();
    }

    private void assignFluidRenderer() {
        renderer = new FluidTankRenderer(10000, true, 16, 61);
    }

    private void assignEnergyInfoArea() {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        super.renderLabels(guiGraphics, pMouseX, pMouseY);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

    }




    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        renderer.render(guiGraphics.pose(), x + 64, y + 15, menu.getFluidStack());

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 105, y + 33, 176, 0, 8, menu.getScaledProgress());
        }
    }



    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }



    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);

        FluidTank tank = this.menu.getBlockEntity().getFluidTank();
        FluidStack fluidStack = tank.getFluid();
        if(fluidStack.isEmpty())
            return;

        int fluidHeight = getFluidHeight(tank);
        if(!isHovering(64, getFluidY(fluidHeight) - this.topPos + 13, 16, fluidHeight, pMouseX, pMouseY))
            return;

        Component component = MutableComponent.create(fluidStack.getDisplayName().getContents())
                .append(" (%s/%s mB)".formatted(tank.getFluidAmount(), tank.getCapacity()));
        pGuiGraphics.renderTooltip(this.font, component, pMouseX, pMouseY);
    }

    private static int getFluidHeight(IFluidTank tank) {
        return (int) (61 * ((float) tank.getFluidAmount() / tank.getCapacity()));
    }

    private int getFluidY(int fluidHeight) {
        return this.topPos + 15 + (48 - fluidHeight);
    }

}



