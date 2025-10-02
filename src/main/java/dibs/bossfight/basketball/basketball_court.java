package dibs.bossfight.basketball;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class basketball_court {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, YourMod.MOD_ID);

    // 1. Define the ResourceKey for your Structure JSON (Structure)
    public static final ResourceKey<Structure> BASKETBALL_COURT_KEY = createStructureKey("basketball_court");

    // 2. Register a custom StructureType (optional, but good practice for custom logic)
    // For a simple structure using the vanilla Jigsaw mechanism, you might only need the key.
    public static final DeferredHolder<StructureType<?>, StructureType<BasketballCourtStructure>> BASKETBALL_COURT_TYPE =
            STRUCTURE_TYPES.register("basketball_court", () -> () -> BasketballCourtStructure.CODEC);

    // Helper method for the ResourceKey
    private static ResourceKey<Structure> createStructureKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(YourMod.MOD_ID, name));
    }
}
}
