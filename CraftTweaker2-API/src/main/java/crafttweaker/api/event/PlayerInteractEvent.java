package crafttweaker.api.event;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlock;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.world.*;
import stanhebben.zenscript.annotations.*;

/**
 * @author Stan
 */
@ZenClass("crafttweaker.event.PlayerInteractEvent")
@ZenRegister
public class PlayerInteractEvent implements IEventCancelable {
    
    private final IPlayer player;
    private final IBlockGroup blocks;
    private final int x;
    private final int y;
    private final int z;
    
    private boolean canceled;
    private boolean useBlock;
    private boolean useItem;
    
    public PlayerInteractEvent(IPlayer player, IBlockGroup blocks, int x, int y, int z) {
        this.player = player;
        this.blocks = blocks;
        this.x = x;
        this.y = y;
        this.z = z;
        
        canceled = false;
        useBlock = false;
        useItem = false;
    }
    
    @Override
    public void cancel() {
        canceled = true;
    }
    
    @ZenMethod
    public void useBlock() {
        useBlock = true;
    }
    
    @ZenMethod
    public void useItem() {
        useItem = true;
    }
    
    @Override
    public boolean isCanceled() {
        return canceled;
    }
    
    @ZenGetter("usingBlock")
    public boolean isUsingBlock() {
        return useBlock;
    }
    
    @ZenGetter("usingItem")
    public boolean isUsingItem() {
        return useItem;
    }
    
    @ZenGetter("player")
    public IPlayer getPlayer() {
        return player;
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
    
    @ZenGetter("block")
    public IBlock getBlock() {
        return blocks.getBlock(x, y, z);
    }
    
    @ZenGetter("dimension")
    public IDimension getDimension() {
        return blocks.getDimension();
    }
}
