package draconicevolution.common.container;

import draconicevolution.client.interfaces.SlotItemValid;
import draconicevolution.common.tileentities.TileWeatherController;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerWeatherController extends Container {

	private TileWeatherController tileWC;

	public ContainerWeatherController(InventoryPlayer invPlayer, TileWeatherController tileWC) {
		this.tileWC = tileWC;

		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 119));
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 61 + y * 18));
			}
		}

		addSlotToContainer(new SlotItemValid(tileWC, 0, 47, 15, Items.emerald));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileWC.isUseableByPlayer(player);
	}

	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		return null;
	}

	public TileWeatherController getTileWC(){
		return tileWC;
	}

}