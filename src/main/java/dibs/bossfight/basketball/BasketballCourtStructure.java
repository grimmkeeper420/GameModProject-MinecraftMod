package dibs.bossfight.basketball;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.Optional;

public class BasketballCourtStructure extends Structure {
    
    // CODEC for Structure JSON file
    public static final Codec<BasketballCourtStructure> CODEC = RecordCodecBuilder.<BasketballCourtStructure>map(instance ->
            instance.group(
                    settingsCodec(instance),
                    StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    ResourceLocation.CODEC.fieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistance),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight)
            ).apply(instance, BasketballCourtStructure::new)).codec();

    private final Holder<StructureTemplatePool> startPool;
    private final ResourceLocation startJigsawName;
    private final int maxDistance;
    private final HeightProvider startHeight;

    public BasketballCourtStructure(Structure.Settings settings, 
                                    Holder<StructureTemplatePool> startPool, 
                                    ResourceLocation startJigsawName, 
                                    int maxDistance, 
                                    HeightProvider startHeight) {
        super(settings);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.maxDistance = maxDistance;
        this.startHeight = startHeight;
    }

    // Required getter
    @Override
    public StructureType<?> type() {
        return ModStructures.BASKETBALL_COURT_TYPE.get();
    }

    // Tells the game which terrain step to generate the structure during
    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    // Main generation method
    @Override
    public Optional<GenerationContext> findGenerationPoint(GenerationContext context) {
        ChunkPos chunkpos = context.chunkPos();
        WorldGenerationContext worldgencontext = context.context();

        // 1. Get the Y-position where the structure should start
        int startY = this.startHeight.sample(context.random(), worldgencontext);
        
        // Use the chunk's center position as the anchor
        BlockPos blockpos = new BlockPos(chunkpos.getMinBlockX(), startY, chunkpos.getMinBlockZ());

        // 2. Add structure pieces (Jigsaw Logic)
        return JigsawStructure.generate(
                context, 
                this.startPool, 
                this.startJigsawName, 
                this.maxDistance, 
                blockpos, 
                false, // Keep liquid-y pieces
                Optional.empty()
        );
    }
}