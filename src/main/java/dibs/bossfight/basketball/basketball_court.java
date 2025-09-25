package dibs.bossfight.basketball;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class basketball_court {
public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        // The registry we want to use.
        // Minecraft's registries can be found in BuiltInRegistries, NeoForge's registries can be found in NeoForgeRegistries.
        // Mods may also add their own registries, refer to the individual mod's documentation or source code for where to find them.
        BuiltInRegistries.BLOCKS,
        // Our mod id.
        basketball_court.MOD_ID
);
public static final DeferredHolder<Block, Block> EXAMPLE_BLOCK_1 = BLOCKS.register(
        // Our registry name.
        "example_block",
        // A supplier of the object we want to register.
        () -> new Block(...)
);

public static final DeferredHolder<Block, SlabBlock> EXAMPLE_BLOCK_2 = BLOCKS.register(
        // Our registry name.
        "example_block",
        // A function creating the object we want to register
        // given its registry name as a ResourceLocation.
        registryName -> new SlabBlock(...)
);
public static final Supplier<Block> EXAMPLE_BLOCK_1 = BLOCKS.register(
        // Our registry name.
        "example_block",
        // A supplier of the object we want to register.
        () -> new Block(...)
);

public static final Supplier<SlabBlock> EXAMPLE_BLOCK_2 = BLOCKS.register(
        // Our registry name.
        "example_block",
        // A function creating the object we want to register
        // given its registry name as a ResourceLocation.
        registryName -> new SlabBlock(...)
);
//This is our mod constructor
public void ExampleMod(IEventBus modBus) {
    ExampleBlocksClass.BLOCKS.register(modBus);
    //Other stuff here
}
}
