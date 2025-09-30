package dibs.bossfight.basketball;
package structure.worldgen.structure;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ruins_trial {
  "type": "minecraft:jigsaw",
  "biomes": [
    "minecraft:desert",
    "minecraft:savanna"
  ],
  "step": "surface_structures",
  "spawn_overrides": {},
  "start_pool": "minecraft:trail_ruins/tower",
  "size": 1,
  "start_height": {
    "above_bottom":0
  },
  "start_jigsaw_name": "ruins_tower_trial",
  "project_start_to_heightmap": "WORLD_SURFACE_WG",
  "max_distance_from_center": 1,
  "use_expansion_hack": true,
  "liquid_settings": "ignore_waterlogging"
}
