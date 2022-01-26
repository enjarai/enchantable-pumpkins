package nl.enjarai.enchantablepumpkins.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net/minecraft/enchantment/EnchantmentTarget$10")
public class EnchantmentTargetHeadArmorMixin {
    @Inject(method = "isAcceptableItem(Lnet/minecraft/item/Item;)Z", at = @At("HEAD"), cancellable = true)
    private void modifyAcceptableItem(Item item, CallbackInfoReturnable<Boolean> cir) {
        if (item == Items.CARVED_PUMPKIN) {
            cir.setReturnValue(true);
        }
    }
}
