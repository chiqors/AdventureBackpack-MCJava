package com.darkona.adventurebackpack.handlers;

import com.darkona.adventurebackpack.proxy.ClientProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.RenderPlayerEvent;

/**
 * Created on 25/12/2014
 *
 * @author Darkona
 */
public class RenderHandler
{
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void playerSpecialsRendering(RenderPlayerEvent.Specials.Pre event)
    {

        float rotationY = event.renderer.modelBipedMain.bipedBody.rotateAngleY;
        float rotationX = event.renderer.modelBipedMain.bipedBody.rotateAngleX;
        float rotationZ = event.renderer.modelBipedMain.bipedBody.rotateAngleZ;

        double x = event.entity.posX;
        double y = event.entity.posY;
        double z = event.entity.posZ;

        float pitch = event.entity.rotationPitch;
        float yaw = event.entity.rotationYaw;
        ClientProxy.rendererWearableEquipped.render(event.entity, x, y, z, rotationX, rotationY, rotationZ, pitch, yaw);

        event.renderCape = true;
    }
}
