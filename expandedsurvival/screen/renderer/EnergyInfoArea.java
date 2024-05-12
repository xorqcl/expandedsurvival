package net.steve.expandedsurvival.screen.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraftforge.energy.IEnergyStorage;

import java.util.List;


/*
 *  BluSunrize
 *  Copyright (c) 2021
 *
 *  This code is licensed under "Blu's License of Common Sense"
 *  Details can be found in the license file in the root folder of this project
 */
public class EnergyInfoArea extends InfoArea {
    private final IEnergyStorage energy;

    public EnergyInfoArea(int xMin, int yMin, IEnergyStorage energy)  {
        this(xMin, yMin, null,8,64, energy);
    }

    public EnergyInfoArea(int xMin, int yMin, IEnergyStorage energy, IEnergyStorage energy1)  {
        this(xMin, yMin, energy,8,64, energy1);
    }

    public EnergyInfoArea(int xMin, int yMin, IEnergyStorage energy, int width, int height, IEnergyStorage energy1) {
        super(null, null, null);

        this.energy = energy1;
    }

    public List<Component> getTooltips() {
        return List.of(Component.literal(energy.getEnergyStored()+"/"+energy.getMaxEnergyStored()+" FE"));
    }

    @Override
    public void draw(PoseStack transform) {
        final int height = area.getHeight();
        int stored = (int)(height*(energy.getEnergyStored()/(float)energy.getMaxEnergyStored()));
        fillGradient(
                transform,
                area.getX(), area.getY()+(height-stored),
                area.getX() + area.getWidth(), area.getY() +area.getHeight(),
                0xffb51500, 0xff600b00
        );
    }

    private void fillGradient(PoseStack transform, int x, int pX2, int pY2, int pZ, int pColorFrom, int pColorTo) {
    }
}