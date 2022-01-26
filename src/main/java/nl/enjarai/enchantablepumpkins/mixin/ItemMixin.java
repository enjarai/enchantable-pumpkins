package nl.enjarai.enchantablepumpkins.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "isEnchantable(Lnet/minecraft/item/ItemStack;)Z", at = @At("HEAD"), cancellable = true)
    private void modifyEnchantable(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() == Items.CARVED_PUMPKIN) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getEnchantability()I", at = @At("HEAD"), cancellable = true)
    private void modifyEnchantability(CallbackInfoReturnable<Integer> cir) {
        if (((Object) this) == Items.CARVED_PUMPKIN) {
            cir.setReturnValue(15);
        }
    }
}