package crafttweaker.api.event;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlock;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.world.*;
import stanhebben.zenscript.annotations.*;

/**
 * @author Stan
 */
@ZenClass("crafttweaker.event.PlayerUseHoeEvent")
@ZenRegister
public class PlayerUseHoeEvent implements IEventCancelable {
    
    private final IPlayer player;
    private final IItemStack item;
    private final IBlockGroup blocks;
    private final int x;
    private final int y;
    private final int z;
    private boolean canceled;
    private boolean processed;
    
    public PlayerUseHoeEvent(IPlayer player, IItemStack item, IBlockGroup blocks, int x, int y, int z) {
        this.player = player;
        this.item = item;
        this.blocks = blocks;
        this.x = x;
        this.y = y;
        this.z = z;
        
        canceled = false;
        processed = false;
    }
    
    @Override
    public void cancel() {
        canceled = true;
    }
    
    @ZenMethod
    public void process() {
        processed = true;
    }
    
    @Override
    public boolean isCanceled() {
        return canceled;
    }
    
    @ZenGetter("processed")
    public boolean isProcessed() {
        return processed;
    }
    
    @ZenGetter("player")
    public IPlayer getPlayer() {
        return player;
    }
    
    @ZenGetter("item")
    public IItemStack getItem() {
        return item;
    }
    
    @ZenGetter("blocks")
    public IBlockGroup getBlocks() {
        return blocks;
    }
    
    @ZenGetter("x")
    public int getX() {
        return x;
    }
    
    @ZenGetter("y")
    public int getY() {
        return y;
    }
    
    @ZenGetter("z")
    public int getZ() {
        return z;
    }
    
    @ZenGetter("dimension")
    public IDimension getDimension() {
        return blocks.getDimension();
    }
    
    @ZenGetter("block")
    public IBlock getBlock() {
        return blocks.getBlock(x, y, z);
    }
}
