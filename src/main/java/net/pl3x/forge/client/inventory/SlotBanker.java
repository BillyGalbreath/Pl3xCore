package net.pl3x.forge.client.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pl3x.forge.client.ChatColor;
import net.pl3x.forge.client.container.ContainerBanker;

import java.util.ArrayList;
import java.util.List;

public class SlotBanker extends Slot {
    List<String> tooltip = new ArrayList<>();
    private ContainerBanker container;

    public SlotBanker(ContainerBanker container, IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
        this.container = container;

        tooltip.add(ChatColor.colorize("&a&oPurchase slot"));
        tooltip.add(ChatColor.colorize("&a&ofor &e" + slotCost() + " &a&ocoins"));
    }

    public int slotCost() {
        return getSlotIndex() * 10 + 10;
    }

    public List<String> getTooltipText() {
        return tooltip;
    }

    @SideOnly(Side.CLIENT)
    public boolean isEnabled() {
        return getSlotIndex() < container.getSlots();
    }

    public boolean isItemValid(ItemStack stack) {
        return getSlotIndex() < container.getSlots();
    }

    public boolean isPurchasable() {
        return getSlotIndex() == container.getSlots();
    }
}