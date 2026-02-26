package com.protonmail.hallowfiend.nomoonnoproblem.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;

import com.Polarice3.Goety.api.ritual.IRitualType;
import com.Polarice3.Goety.common.blocks.entities.RitualBlockEntity;
import com.Polarice3.Goety.common.ritual.RitualRequirements;
import com.Polarice3.Goety.common.ritual.RitualTypes;
import com.Polarice3.Goety.common.ritual.type.NecroturgyRitualType;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(NecroturgyRitualType.class)
public abstract class NecroturgyRitualTypeMixin implements IRitualType{
    @Inject(method = "getRequirement", at = @At("HEAD"), cancellable = true, remap = false)
    private void nomoonnoproblem$getRequirement(RitualBlockEntity pTileEntity, Player pPlayer, BlockPos pPos, Level pLevel, CallbackInfoReturnable<Boolean> cir) {
        if (!(pLevel.getSkyDarken() >= 4 || !(pLevel.dimensionType().hasSkyLight()))) {
            if (pPlayer != null) {
                pPlayer.displayClientMessage(Component.translatable("info.goety.ritual.structure.night"), true);
            }
            cir.setReturnValue(false);
        }
        cir.setReturnValue(RitualRequirements.getStructures(RitualTypes.NECROTURGY, pPlayer, pPos, pLevel));
    }
    }

