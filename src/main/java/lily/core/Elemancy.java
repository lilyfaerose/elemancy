package lily.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Supplier;

import lily.bakery.RecipeBakery;
import lily.core.binders.AttributeBinder;
import lily.core.binders.BlockBinder;
import lily.core.binders.RecipeeBinder;
import lily.core.binders.itemBinder;
import lily.java.lily.faerose.blocks.BasicBlock;
import lily.java.lily.faerose.blocks.ItemBlock;
import lily.java.lily.faerose.blocks.TransmuteBlock;
import lily.java.lily.faerose.items.AttckTypes;
import lily.java.lily.faerose.items.MagicWeapon;
import lily.java.lily.faerose.items.basicitem;
import lily.tiles.TransmutationTile;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntityType.Builder;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@SuppressWarnings("unused")
@Mod(Misc.MODID)
public class Elemancy
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
public static Minecraft game;

	public static Logger getLogger() {
		return LOGGER;
	}

	
	
	public static Creativegroup TAB = new Creativegroup(Misc.MODID);
	public static itemBinder Items = new itemBinder(Misc.MODID);
	public static BlockBinder Blocks = new BlockBinder(Misc.MODID);
	public static RecipeeBinder Recipees = new RecipeeBinder(Misc.MODID);
	public static Creativegroup getTAB() {
		return TAB;
	}

	public static itemBinder getItems() {
		return Items;
	}

	public static BlockBinder getBlocks() {
		return Blocks;
	}

	public static AttributeBinder getAttribute() {
		return Attribute;
	}



	public static AttributeBinder Attribute = new AttributeBinder(Misc.MODID);

	
	
	@SuppressWarnings("static-access")
	public Elemancy() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::bindAttr);

this.getLogger().info("startup");
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
        // some preinit code
        LOGGER.info("FIRST Discovery unlocked");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    	game = event.getMinecraftSupplier().get();
        LOGGER.info("Got game settings {}", game.gameDirectory);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        //InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        /*LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));*/
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
        
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @EventBusSubscriber(bus= EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    	
    	
    	
        @SubscribeEvent
        public static void onTileRegistry(final RegistryEvent.Register<TileEntityType<?>> Event) {
        	
        	//Builder<TransmutationTile> obj = TileEntityType.Builder.of(TransmutationTile::new, Blocks.BRICKS);
        	
        	
        }

        	
        @SubscribeEvent
            public static void onRecipeRegistrytype(RegistryEvent.Register<IRecipeSerializer<?>> event) {

        	
        	echo("recipe serializer");
        	
        	
        	
        	Recipees.register(event);        	
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            LOGGER.info("SECOND Discovery unlocked");
        }
        
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
        	
        	Items.register(event);
        	
            echo(event.getName());
            
            Item item = new ItemBlock(null).setRegistryName(new ResourceLocation(Misc.MODID, "brass.block"));
            event.getRegistry().register(item);

             }
        
        
        


        public static void echo (Object obj) {System.out.println(obj);}
        
        public void onServerStarting(FMLServerStartingEvent event) {
            // do something when the server starts
            LOGGER.info("HELLO from server starting");
            
            

    }
        
        
        
        
        
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> event) {
        	
        	
        
        	
        	
        	Blocks.register(event);
        	
        }
        
        @SubscribeEvent
        public static void onAttrributeRegistry(final RegistryEvent.Register<Attribute> event) {
        	
        	Attribute.register(event);        	
        }
        
        @SubscribeEvent
        public static void onItemsRegistry(GatherDataEvent event) 
        {
        	

        	event.getGenerator().addProvider(new RecipeBakery(event.getGenerator()));
        	
        	Misc.echo("test12345" + event.includeClient());
        }
        
        
        @SuppressWarnings("unchecked")
		@SubscribeEvent
        public static void bindAttr(EntityAttributeModificationEvent event) 
        {
        	Misc.echo("binding Attributes");
        	for(@SuppressWarnings("rawtypes") EntityType type: event.getTypes())
        	{
        		//Misc.echo(type);
        		event.add(type, Misc.resistance);
        	}
        	
        	
        	event.add(EntityType.PLAYER, Misc.magic);
        	event.add(EntityType.PLAYER, Misc.purification);
        	event.add(EntityType.PLAYER, Misc.capacity);
        	event.add(EntityType.PLAYER, Misc.runicArmor);
        	event.add(EntityType.PLAYER, Misc.recharge);
        	
    }
}}
