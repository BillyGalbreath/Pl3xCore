package net.pl3x.forge.server.data;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.DimensionManager;
import net.pl3x.forge.server.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class PlayerDataImpl implements PlayerData {
    private TreeMap<String, Location> homes = new TreeMap<>();
    private boolean denyTeleports = false;

    @Override
    public void addHome(String name, Location location) {
        homes.put(name, location);
    }

    @Override
    public void removeHome(String name) {
        homes.remove(name);
    }

    @Override
    public Location getHome(String name) {
        return homes.get(name);
    }

    @Override
    public ArrayList<String> getHomeNames() {
        ArrayList<String> list = new ArrayList<>(homes.keySet());
        Collections.sort(list);
        return list;
    }

    @Override
    public TreeMap<String, Location> getHomes() {
        return homes;
    }

    @Override
    public void setHomes(TreeMap<String, Location> homes) {
        this.homes = homes;
    }

    @Override
    public boolean denyTeleports() {
        return this.denyTeleports;
    }

    @Override
    public void denyTeleports(boolean denyTeleports) {
        this.denyTeleports = denyTeleports;
    }

    @Override
    public NBTTagCompound getDataAsNBT() {
        NBTTagList nbtTagList = new NBTTagList();
        for (Map.Entry<String, Location> entry : homes.entrySet()) {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("name", entry.getKey());
            compound.setInteger("dimension", entry.getValue().getDimension());
            compound.setDouble("x", entry.getValue().getX());
            compound.setDouble("y", entry.getValue().getY());
            compound.setDouble("z", entry.getValue().getZ());
            compound.setFloat("pitch", entry.getValue().getPitch());
            compound.setFloat("yaw", entry.getValue().getYaw());
            nbtTagList.appendTag(compound);
        }
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("homes", nbtTagList);
        nbt.setBoolean("denyteleports", denyTeleports);
        return nbt;
    }

    @Override
    public void setDataFromNBT(NBTTagCompound nbt) {
        denyTeleports = nbt.getBoolean("denyteleports");
        NBTTagList nbtTagList = nbt.getTagList("homes", 10);
        for (int i = 0; i < nbtTagList.tagCount(); i++) {
            NBTTagCompound compound = nbtTagList.getCompoundTagAt(i);
            homes.put(compound.getString("name"), new Location(
                    DimensionManager.getWorld(compound.getInteger("dimension")),
                    compound.getInteger("dimension"),
                    compound.getDouble("x"),
                    compound.getDouble("y"),
                    compound.getDouble("z"),
                    compound.getFloat("pitch"),
                    compound.getFloat("yaw")));
        }
    }
}