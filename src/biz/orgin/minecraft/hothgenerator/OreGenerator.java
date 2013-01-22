package biz.orgin.minecraft.hothgenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

/**
 * A generator that replaces stone blocks into strands of ore blocks.
 * The generator can operate in two modes.
 *  - Fast, this will inject ores during terrain chuck generation into the chunk byte array
 *  - Slow, this will schedule a delayed task to inject ores by setting block types and data values
 *  
 *  Which one that is used is determined by the hoth.generate.extendedore flag in the config file.
 *  In fast mode a typeID of 0-255 can be used with no data value
 *  In slow mode the type ID can be above 255 and a data value can be set
 *  Do not set hoth.generate.extendedore to true unless a custom ore list is used or else terrain
 *  generation will be slow for no good reason.
 *  
 *  An attempt to load a custom ore list from custom/custom_ores.ol will be made on start up and
 *  every time /hothreload is executed.
 *  
 * @author orgin
 *
 */
public class OreGenerator
{
	private static int[] iterations = new int[] {10, 10, 20, 20, 2, 8, 1, 1, 1};
	private static int[] amount =     new int[] {32, 32, 16,  8, 8, 7, 7, 6, 6};
	private static int[] type =       new int[] {
		Material.DIRT.getId(),         // 60
		Material.GRAVEL.getId(),       // 26
		Material.COAL_ORE.getId(),     // 128
		Material.IRON_ORE.getId(),     // 128
		Material.GOLD_ORE.getId(),     // 26
		Material.REDSTONE_ORE.getId(), // 16
		Material.DIAMOND_ORE.getId(),  // 16
		Material.LAPIS_ORE.getId(),    // 26
		Material.EMERALD_ORE.getId()}; // 128
	private static int[] data =     new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private static int[] maxHeight = new int[] {60, 26, 128, 128, 26, 16, 16,	26, 128};
	private static int REPLACE = Material.STONE.getId();
	
	public static void generateOres(HothGeneratorPlugin plugin, World world, byte[][] chunk, Random random, int chunkx, int chunkz)
	{
		if(plugin.isGenerateOres())
		{
			if(!plugin.isGenerateExtendedOre()) // Generate single byte ores in the supplied chunk array
			{
				for (int i = 0; i < type.length; i++)
				{
					for (int j = 0; j < iterations[i]; j++)
					{
						OreGenerator.vein(chunk, random, random.nextInt(16),
								random.nextInt(maxHeight[i]), random.nextInt(16),
								amount[i], type[i]);
					}
				}
			}
			else // Schedule a delayed task to generate ores with typeID and data values
			{
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new PlaceOre(plugin, world, random, chunkx, chunkz));
			}
		}
	}

	/**
	 * Used to create veins using only the generator byte chunk
	 * @param chunk
	 * @param random
	 * @param originX
	 * @param originY
	 * @param originZ
	 * @param amount
	 * @param type
	 */
	private static void vein(byte[][] chunk, Random random, int originX,
			int originY, int originZ, int amount, int type)
	{

		int dx = originX;
		int dy = originY;
		int dz = originZ;
		
		for (int i = 0; i < amount; i++)
		{
			int dir = random.nextInt(6);
			switch(dir)
			{
			case 0:
			    dx++;
				break;
			case 1:
		        dx--;
		        break;
			case 2:
			    dy++;
				break;
			case 3:
		        dy--;
		        break;
			case 4:
			    dz++;
				break;
			case 5:
		        dz--;
		        break;
			}
			
			dx = dx & 0x0f;
			dz = dz & 0x0f;

			if (dy > 127 || dy < 0) {
				continue;
			}

			byte oldtype = HothUtils.getPos(chunk, dx, dy, dz);
			if(oldtype == REPLACE)
			{
				HothUtils.setPos(chunk, dx, dy, dz, type);
			}
			
		}
	}

	/**
	 * Used to generate veins when extendedore is set to true
	 * @param world
	 * @param chunkx
	 * @param chunkz
	 * @param random
	 * @param originX
	 * @param originY
	 * @param originZ
	 * @param amount
	 * @param typeID
	 * @param dataValue
	 */
	private static void extendedVein(World world, int chunkx, int chunkz, Random random, int originX,
			int originY, int originZ, int amount, int typeID, int dataValue)
	{

		int dx = originX;
		int dy = originY;
		int dz = originZ;
		
		for (int i = 0; i < amount; i++)
		{
			int dir = random.nextInt(6);
			switch(dir)
			{
			case 0:
			    dx++;
				break;
			case 1:
		        dx--;
		        break;
			case 2:
			    dy++;
				break;
			case 3:
		        dy--;
		        break;
			case 4:
			    dz++;
				break;
			case 5:
		        dz--;
		        break;
			}
			
			dx = dx & 0x0f;
			dz = dz & 0x0f;

			if (dy > 127 || dy < 0) {
				continue;
			}

			Block block = world.getBlockAt(chunkx*16 + dx, dy, chunkz*16 + dz);
			int oldTypeID = block.getTypeId();
			if(oldTypeID == REPLACE)
			{
				block.setTypeIdAndData(typeID, (byte)dataValue, false);
			}
			
		}
	}
	
	/**
	 * Loads the ore list from custom_ores.ol if found.
	 * @param plugin
	 */
	public static void load(HothGeneratorPlugin plugin)
	{
		Vector<Ore> ores = new Vector<Ore>();
		
		File dataFolder = plugin.getDataFolder();
		String path = dataFolder.getAbsolutePath() + "/custom/custom_ores.ol";
		File customOres = new File(path);
		if(customOres.isFile())
		{
			try
			{
				BufferedReader reader = new BufferedReader(new FileReader(customOres));
				
				String line;
				
				while( (line=reader.readLine())!=null)
				{
					String row = line.trim();
					if(row.length()>0 &&  row.charAt(0)!=';' && row.charAt(0)!='#')
					{
						String[] cols = row.split(",");
						if(cols.length!=6)
						{
							throw new IOException("Wrong number of parameters: " + row);
						}
						
						try
						{
							Ore ore = new Ore();
							ore.typeID = Integer.parseInt(cols[1].trim());
							ore.data = Integer.parseInt(cols[2].trim());
							ore.iterations = Integer.parseInt(cols[3].trim());
							ore.amount = Integer.parseInt(cols[4].trim());
							ore.maxHeight = Integer.parseInt(cols[5].trim());
							
							if(ore.typeID<0 || ore.data<0 || ore.iterations<0 || ore.amount<0 || ore.maxHeight<0 || ore.data>255)
							{
								throw new IOException("Invalid parameters: " + row);
							}
							
							// Check if there is a violation of extended ore
							if(!plugin.isGenerateExtendedOre() && ore.typeID>255)
							{
								plugin.debugMessage("ERROR: Type ID to large, generate.extendedore is false " + row);
							}
							else
							{
								ores.add(ore);
							}
						}
						catch(Exception e)
						{
							throw new IOException("Invalid parameters: " + row);
						}
						
					}
				}
				
				int types[] = new int[ores.size()];
				int data[] = new int[ores.size()];
				int iterations[] = new int[ores.size()];
				int amount[] = new int[ores.size()];
				int maxHeight[] = new int[ores.size()];
				
				for(int i=0;i<ores.size();i++)
				{
					types[i] = ores.elementAt(i).typeID;
					data[i] = ores.elementAt(i).data;
					iterations[i] = ores.elementAt(i).iterations;
					amount[i] = ores.elementAt(i).amount;
					maxHeight[i] = ores.elementAt(i).maxHeight;
				}
				
				OreGenerator.type = types;
				OreGenerator.data = data;
				OreGenerator.iterations = iterations;
				OreGenerator.amount = amount;
				OreGenerator.maxHeight = maxHeight;
				
			}
			catch(IOException e)
			{
				plugin.debugMessage("ERROR: Could not load /custom/custom_ores.ol " + e.getMessage());
			}
		}
	}
	
	private static class Ore
	{
		public int typeID;
		public int data;
		public int iterations;
		public int amount;
		public int maxHeight;
		
		public Ore()
		{
		}

	}
	
	static class PlaceOre implements Runnable
	{
		@SuppressWarnings("unused")
		private final HothGeneratorPlugin plugin;
		private final World world;
		private final Random random;
		private final int chunkx;
		private final int chunkz;

		public PlaceOre(HothGeneratorPlugin plugin, World world, Random random, int chunkx, int chunkz)
		{
			this.plugin = plugin;
			this.world = world;
			this.random = random;
			this.chunkx = chunkx;
			this.chunkz = chunkz;
		}

		@Override
		public void run()
		{	
			for (int i = 0; i < type.length; i++)
			{
				for (int j = 0; j < iterations[i]; j++)
				{
					OreGenerator.extendedVein(world, chunkx, chunkz, random, random.nextInt(16),
							random.nextInt(maxHeight[i]), random.nextInt(16),
							amount[i], type[i], data[i]);
				}
			}
		}
	}
}